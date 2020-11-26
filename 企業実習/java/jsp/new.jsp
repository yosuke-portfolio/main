<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean class="user.UserBean" id="user" scope="session" />
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顧客管理</title>
<link rel="stylesheet"
    href="${pageContext.request.contextPath}/style.css">
</head>
<body>
    <h1>顧客管理</h1>
    <div class="main">


        <!-- TODO ｢新規登録｣画面 -->
        <h2>新規登録</h2>
        <form name="form1" action="CustomerServlet" method="post" onsubmit="return funcConfirm()">
            <table>
                <tr>
                     <td>氏名</td>
                     <td><input type="text" name="name" maxlength="20" /></td>
                </tr>
                <tr>
                     <td>郵便番号</td>
                     <td><input type="text" name="zip" maxlength="20" /></td>
                </tr>
                <tr>
                     <td>住所1</td>
                     <td><input type="text" name="address1" maxlength="100" /></td>
                </tr>
                <tr>
                     <td>住所2</td>
                     <td><input type="text" name="address2" maxlength="100"/></td>
                </tr>
                <tr>
                     <td>TEL</td>
                     <td><input type="text" name="tel" maxlength="20" /></td>
                </tr>
                <tr>
                     <td>FAX</td>
                     <td><input type="text" name="fax" maxlength="20" /></td>
                </tr>
                <tr>
                     <td>E-mail</td>
                     <td><input type="text" name="email" maxlength="100" /></td>
                </tr>
            </table>
            <p>
                <button name="state" value="new_confirm">送信</button>
                <input type="button" value="戻る" onclick="history.back()" />
            </p>
        </form>
        <!-- ここまで -->


    </div>
</body>
<script type="text/javascript">
    function funcConfirm() {

        // TODO バリデーションチェック･alertダイアログ処理
        if (document.form1.name.value == "") {
            alert("氏名が入力されていません。");
            return false;
        }
        if (!document.form1.zip.value.match(/^[0-9]{3}-[0-9]{4}$/)) {
            alert("郵便番号は半角数字と‐(ハイフン)のみ〇〇〇‐〇〇〇〇の形で入力してください");
            return false;
        }
        if (document.form1.address1.value == "") {
            alert("住所1が入力されていません。");
            return false;
        }
        if (document.form1.address2.value == "") {
            alert("住所2が入力されていません。");
            return false;
        }
        if (document.form1.tel.value == "") {
            alert("電話番号が入力されていません。");
            return false;
        }
//        if (!document.form1.tel.value.match(/^[0-9-]+$/)) {
//            alert("電話番号は半角数字と‐(ハイフン)のみで入力してください");
//            return false;
//        }
        if (!document.form1.email.value.match(/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/)) {
            alert("E-mailは〇〇〇@XXXの形で入力してください");
            return false;
        }
        // ここまで

    }
</script>
</html>
