<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>入力エラー</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <header>
    <h1>入力エラー</h1>
  </header>
  <main>
    <div class="centerBlock">
      <p style="color: red; font-weight: bold;">
        <%= request.getAttribute("error") %>
      </p>
      <p>
        入力内容を確認して、もう一度やり直してください。
      </p>
      <a href="kadai1form.html">
        <button type="button">戻る</button>
      </a>
    </div>
  </main>
</body>
</html>