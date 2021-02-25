<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ログイン</h1>

<span class="label label-danger"><font color="red">${message}</font></span>
<form action = "/EC/login" method = "post">

<p>名前(ログインID)：<input type="text" name = "namae"></p>
<p>パスワード：<input type="password" name = "password"></p>
<input type="submit" value="Login">
<input type="submit" value="アカウントを作成する">

</form>

</body>
</html>