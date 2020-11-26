package customer;

import static constants.MessageConstants.*;

import javax.servlet.http.HttpServletRequest;

import dao.CustomerDao;
import util.LogUtil;
import util.StringUtil;

/**
 * 顧客情報のロジック
 */
public class CustomerLogic {

    /**
     * DAO経由で顧客情報をDBから取得する
     * @param id 取得する顧客情報のID
     * @return 顧客情報Bean
     */
    public CustomerBean load(int id) {
        LogUtil.println(this.getClass().getSimpleName() + "#load");

        CustomerDao customerDao = new CustomerDao();
        CustomerBean customer = customerDao.load(id);

        return customer;
    }

    /**
     * DAO経由で顧客情報をDBに追加する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String add(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#add");

        // TODO 未実装
        String errMessage = null;
        CustomerDao customerDao = new CustomerDao();
        if ( customerDao.add(customer) != null ) {
            // errMessageを要確認
            errMessage = MESSAGE_CAN_NOT_ADD;
            return errMessage;
        }
        // ここまで

        return null;
    }

    /**
     * DAO経由でDBの顧客情報を更新する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String update(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#update");

        // TODO 未実装
        if (customer == null) {
            return MESSAGE_NO_EXIST_CORRESPOND_DATA;
        }

        String errMessage = null;
        CustomerDao customerDao = new CustomerDao();
        errMessage = customerDao.update(customer);
        if (errMessage != null) {
            errMessage = MESSAGE_CAN_NOT_UPDATE;
            return errMessage;
        }
        // ここまで

        return null;
    }

    /**
     * DAO経由でDBの顧客情報を削除する
     * @param customer 顧客情報Bean
     * @return エラーメッセージ(処理成功時、null)
     */
    public String delete(CustomerBean customer) {
        LogUtil.println(this.getClass().getSimpleName() + "#delete");

        // TODO 未実装
        if (customer == null) {
            return MESSAGE_NO_EXIST_CORRESPOND_DATA;
        }
        String errMessage = null;
        CustomerDao customerDao = new CustomerDao();
        errMessage = customerDao.delete( customer.getId() );
        if (errMessage != null) {
            errMessage = MESSAGE_CAN_NOT_DELETE;
            return errMessage;
        }
        // ここまで

        return null;
    }

    /**
     * リクエスト内の顧客情報をセッションに顧客情報Beanとして設定する
     * @param request 顧客情報を含むリクエスト
     */
    public void setCustomerBeanFromRequestToSession(HttpServletRequest request) {
        LogUtil.println(this.getClass().getSimpleName() + "#setCustomerBeanFromRequestToSession");

        // TODO 未実装
        CustomerBean customerEdit = (CustomerBean) request.getSession().getAttribute("customer");
        if ( customerEdit == null ) {
            customerEdit = new CustomerBean();
        }

        customerEdit.setName(StringUtil.exchangeESCEncoding(request.getParameter("name")));
        customerEdit.setZip(StringUtil.exchangeESCEncoding(request.getParameter("zip")));
        customerEdit.setAddress1(StringUtil.exchangeESCEncoding(request.getParameter("address1")));
        customerEdit.setAddress2(StringUtil.exchangeESCEncoding(request.getParameter("address2")));
        customerEdit.setTel(StringUtil.exchangeESCEncoding(request.getParameter("tel")));
        customerEdit.setFax(StringUtil.exchangeESCEncoding(request.getParameter("fax")));
        customerEdit.setEmail(StringUtil.exchangeESCEncoding(request.getParameter("email")));

        request.getSession().setAttribute("customer", customerEdit);
        // ここまで

    }
}