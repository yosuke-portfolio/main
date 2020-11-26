<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean class="user.UserBean" id="user" scope="session" />
<jsp:useBean class="customer.CustomerBean" id="customer" scope="session" />
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

        <!-- ｢入力確認｣画面 -->
        <h2>入力の確認</h2>
        <table>
            <tr>
                <td>氏名</td>
                <td><%= customer.getName() %></td>
            </tr>
            <tr>
                <td>郵便番号</td>
                <td><%= customer.getZip() %></td>
            </tr>
            <tr>
                <td>住所1</td>
                <td><%= customer.getAddress1() %></td>
            </tr>
            <tr>
                <td>住所2</td>
                <td><%= customer.getAddress2() %></td>
            </tr>
            <tr>
                <td>TEL</td>
                <td><%= customer.getTel() %></td>
            </tr>
            <tr>
                <td>FAX</td>
                <td><%= customer.getFax() %></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><%= customer.getEmail() %></td>
            </tr>
        </table>
        <form action="CustomerServlet" method="post">
            <p>
                <button name="state" value="add" formaction="CustomerServlet">OK</button>
                <input type="button" value="戻る" onclick="history.back()" />
            </p>
        </form>
        <!-- ここまで -->


    </div>
</body>
</html>
