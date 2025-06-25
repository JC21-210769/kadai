<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
	<title>消費税の計算</title>
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<header>
		<h1>消費税の計算</h1>
	</header>
	<main>
		<jsp:useBean id="DATA" class="bean.Kadai1Bean" scope="request" />
		<div class="centerBlock">
			<table>
				<tr>
					<td class="back1">金額</td>
					<td class="back2">
						<jsp:getProperty name="DATA" property="money" />
					</td>
				</tr>	
				<tr>
					<td class="back1">消費税</td>
					<td class="back2">
						<jsp:getProperty name="DATA" property="hyoujiRate" />
					</td>
				</tr>
				<tr>
					<td class="back1">消費税</td>
					<td class="back2">
						<jsp:getProperty name="DATA" property="tax" />
					</td>
				</tr>
				<tr>
					<td class="back1">税込金額</td>
					<td class="back2">
						<jsp:getProperty name="DATA" property="withTax" />
					</td>
				</tr>	
				<tr>
					<td></td>
					<td><button><a href="kadai1form.html" >戻る</a></button></td>
				</table>
			</div>
	</main>
</body>
</html>