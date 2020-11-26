package teamMasterMind;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Result
 */
@WebServlet("/index.html")
public class MasterMindController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//actionパラメータので分岐
		HttpSession session = request.getSession();
		ArrayList<PlayerResult> resultList = (ArrayList<PlayerResult>) session.getAttribute("resultList");

		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if ( action != null && action.equals("reStart") ) {
			//セッションインスタンスを破棄して始めから
			session.invalidate();
			request.getRequestDispatcher("/WEB-INF/game-start.jsp").forward(request, response);
		} else if( action != null && action.equals("continue") ) {
			//途中から再開(挑戦回数が10回未満ならResult.jsp、それ以上ならgameover.jsp)
			int count = resultList.size();
			if( count < 10 ) {
				request.getRequestDispatcher("/WEB-INF/Result.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/gameover.jsp").forward(request, response);
			}

		}

		//セッションがある場合に履歴の途中から開始するかを選択する
		if ( resultList == null ) {
			//セッションインスタンスがなければ始めから
			request.getRequestDispatcher("/WEB-INF/game-start.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/continueSelect.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからインスタンスの取り出し、なければ作成
		HttpSession session = request.getSession();
		AnsNum cpu;
		cpu =  (AnsNum) session.getAttribute("cpu");
		if ( cpu == null ) {
			cpu = new AnsNum();
		}

		ArrayList<PlayerResult> resultList;
		resultList = (ArrayList<PlayerResult>) session.getAttribute("resultList");
		if ( resultList == null ) {
			resultList = new ArrayList<PlayerResult>();
		}

		//パラメータの取り出し、セッションスコープへ保存
		request.setCharacterEncoding("utf-8");
		String playerNumber = request.getParameter("playerNumber");
		PlayerResult result = new PlayerResult( playerNumber );
		LogicMM logic = new LogicMM();
		boolean judge = logic.masterMindLogic(result, cpu);
		resultList.add(result);

		session.setAttribute("resultList", resultList);
		session.setAttribute("cpu", cpu);



		if( judge == true ) {
			request.getRequestDispatcher("/WEB-INF/gameComplete.jsp").forward(request, response);
		}else{
			//Arrayリストの数が10になったらゲームオーバー
			if( resultList.size() >= 10  ) {
				request.getRequestDispatcher("/WEB-INF/gameover.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/WEB-INF/Result.jsp").forward(request, response);
			}
		}
	}

}
