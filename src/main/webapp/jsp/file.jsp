<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>画像リスト</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./css/style.css" rel="stylesheet">
<script>
function submitCheck() {
    return window.confirm("削除してよろしいですか？");
}
</script>
</head>
<body>
<header>
    <h1>画像リスト</h1>
</header>

<form method="post" action="delete" onsubmit="return submitCheck()">
    <div class="buttonArea">
        <button type="submit">削除</button>
        <a href="./html/uploadform.html"><button type="button">新規登録</button></a>
    </div>

    <main class="gridview">
    <%
        String path = (String) request.getAttribute("PATH");
        if (path == null) {
            request.getRequestDispatcher("upload").forward(request, response);
            return;
        }
        List<String> files = (List<String>) request.getAttribute("FILES");
        if (files != null) {
            for (String file : files) {
                String pathName = path + file;
    %>
        <div class="item">
            <input type="checkbox" name="check" value="<%=file %>">
            <img src="<%=pathName %>" alt="画像ファイル">
            <div class="filename"><%=file %></div>
        </div>
    <%
            }
        }
    %>
    </main>
</form>
</body>
</html>
