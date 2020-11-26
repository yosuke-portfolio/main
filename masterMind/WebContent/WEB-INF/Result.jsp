<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList,teamMasterMind.PlayerResult" %>
<%@page import="teamMasterMind.AnsNum" %>
<%
ArrayList<PlayerResult> resultList = ( ArrayList<PlayerResult> ) session.getAttribute("resultList");
//Arrayリストに入っている要素の数を取得
int challenge = resultList.size();
AnsNum cpuAns = (AnsNum) session.getAttribute("cpu");
%>

<!DOCTYPE html>
<html lang="ja" dir="ltr">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width" />
<title>マスターマインド</title>
<link rel="stylesheet" href="css/cssFile.css">
<script src="js/javaScriptFile.js"></script>

</head>
<body onload="selectBtn()">
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

<!-- 上段数字 -->
<div>
<img src="number/number0.png" name="numberSelect" onclick="select(0)" class="number" />
<img src="number/number0.png" name="numberSelect" onclick="select(1)" class="number" />
<img src="number/number0.png" name="numberSelect" onclick="select(2)" class="number" />
<img src="number/number0.png" name="numberSelect" onclick="select(3)" class="number" />

<!-- 送信ボタン、リセットボタン  -->
<form action="/masterMind/index.html" method="post">
<input type="submit" onmouseover="setValue()" value="OK" /><br />
<input type="hidden" name="playerNumber" value="">
<button type="button" onclick="reSet()">reset</button>
</form>
</div>

<!-- 選択ボタン -->
<div>
<table class="selectTable">
<tr>
	<td><img src="button/btn_1.gif" id="first" onclick="select(0)" class="sentaku" /></td>
	<td><img src="button/btn_1.gif" id="second" onclick="select(1)" class="sentaku" /></td>
	<td><img src="button/btn_1.gif" id="third" onclick="select(2)" class="sentaku" /></td>
	<td><img src="button/btn_1.gif" id="fourth" onclick="select(3)" class="sentaku" /></td>
</tr>
</table>
</div>

<!-- numberボタン  -->
<div>
<table class="miniNumberTable">
<tr>
	<td><img src="number/number1.png" onclick="numClick(1)" class="miniNumber" /></td>
	<td><img src="number/number2.png" onclick="numClick(2)" class="miniNumber" /></td>
	<td><img src="number/number3.png" onclick="numClick(3)" class="miniNumber" /></td>
	<td><img src="number/number4.png" onclick="numClick(4)" class="miniNumber" /></td>
	<td><img src="number/number5.png" onclick="numClick(5)" class="miniNumber" /></td>
</tr>

<tr>
	<td><img src="number/number6.png" onclick="numClick(6)" class="miniNumber" /></td>
	<td><img src="number/number7.png" onclick="numClick(7)" class="miniNumber" /></td>
	<td><img src="number/number8.png" onclick="numClick(8)" class="miniNumber" /></td>
	<td><img src="number/number9.png" onclick="numClick(9)" class="miniNumber" /></td>
	<td><img src="number/number0.png" onclick="numClick(0)" class="miniNumber" /></td>
</tr>
</table>
</div>
<!-- テスト用 -->
<h2>cpuの数字：<%= cpuAns.getAnsNum() %></h2>
</body>
</html>