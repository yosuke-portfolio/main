<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>顧客管理</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <h1>顧客管理</h1>
    <div class="main">

        <!-- TODO ｢削除完了｣画面 -->
        <h2>削除完了</h2>
        <form action="CustomerServlet" method="post">
            <p>
                <button name="state" value="search" formaction="CustomerServlet">検索画面</button>
            </p>
        </form>
        <!-- ここまで -->
    </div>
</body>
</html>
