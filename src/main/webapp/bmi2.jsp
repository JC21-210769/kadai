<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bmidata.BmiData" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>BMI2</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<%
	//--- 表示するデータをすべて取り込む
	BmiData data = (BmiData) request.getAttribute("DATA");
	%>
	<header>
		<h1>肥満度の計算</h1>
	</header>
	<main>
		<div class="centerBlock">
			<table>
				<tr>
					<td class="back1">身長</td>
					<td class="back2"><%=data.strHeight %>cm</td>
				</tr>
				<tr>
					<td class="back1">体重</td>
					<td class="back2"><%=data.strWeight %>Kg</td>
				</tr>
				<tr>
					<td class="back1">BMI</td>
					<td class="back1"><%=data.bmi %></td>
				</tr>
				<tr>
					<td class="back1">肥満度判定</td>
					<td class="back2"><%=data.himando %></td>
				</tr>
				<tr>
					<td></td>
					<td><a href="bmiform.html">戻る</a></td>
			</table>
		</div>	
	</main>
</body>
</html>