<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,teamMasterMind.PlayerResult,teamMasterMind.AnsNum" %>
<%
AnsNum cpu = (AnsNum) session.getAttribute("cpu");
ArrayList<PlayerResult> resultList = ( ArrayList<PlayerResult> ) session.getAttribute("resultList");
//Arrayリストに入っている要素の数を取得
int challenge = resultList.size();
%>

<!DOCTYPE html>
<html lang="ja" dir="ltr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width" />
<title>マスターマインド</title>
<link rel="stylesheet" href="css/cssFile.css" />
<script src="js/javaScriptFile.js"></script>
</head>
<body>
<h1>MasterMindゲーム</h1>

<table class="rireki" border="1">
<caption>履歴</caption>

<!-- 履歴表の表示 -->
<%
for (int i = 0; i < 10; i++){
	if( i < challenge ){
%>
<tr><td><%= i + 1 %>回目：<%= resultList.get(i).getPlayerResult() %></td><td>Hit：<%= resultList.get(i).getHit() %><br />Blow：<%= resultList.get(i).getBlow()  %></td></tr>

<%	} else { %>
<tr><td>？回目：？？？？</td><td>Hit：？<br />Blow：？</td></tr>
<%  }	} %>

</table>

<h1>おめでとうございます！正解です！</h1>
<br />
<p><%= challenge %>回目の挑戦で正解しました！</p>
<p>おめでとうございます！天才！！</p>
<br />
<hr />
<p>正解の数字：<span><%= cpu.getAnsNum() %></span></p>
<%-- セッションスコープの削除 --%>
<% session.invalidate();%>
</body>
</html>