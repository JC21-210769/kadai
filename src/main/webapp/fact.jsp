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
		String value = (String) request.getAttribute("VALUE");
		String result = (String) request.getAttribute("RESULT");
	%>
	<header>
		<h1>素因数分解</h1>
	</header>
	<main>
		<div clss="centerBlock">
			<div class="centerBlock">
				<p><%=value %>=<%=result %></p>
				</div>
			</div>
		</main>
</body>
</html>