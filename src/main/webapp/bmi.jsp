<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<%
	String height = (String) request.getAttribute("HEIGHT");
	String weight = (String) request.getAttribute("WEIGHT");
	double bmi = (double) request.getAttribute("BMI");
	String judge = (String) request.getAttribute("JUDGE");
	%>
	<header>
		<h1>肥満度の計算</h1>
	</header>
	<main>
	<div class="centerBlock">
		<div class="centerBlock">
			<table>
				<tr>
					<td class="back1">身長</td>
					<td class="back2"><%=height%> cm</td>
				</tr>
				<tr>
					<td class="back1">体重</td>
					<td class="back2"><%=weight%> Kg</td>
				</tr>
				<tr>
					<td class="back1">BMI 値</td>
					<td class="back2"><%=bmi%></td>
				</tr>
				<tr>
					<td class="back1">判定</td>
					<td class="back2"><%=judge%></td>
				</tr>
			</table>
		</div>
		<p>
	</div>
</main>
</body>
</html>