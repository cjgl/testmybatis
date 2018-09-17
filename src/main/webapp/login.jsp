<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
</head>
<body>
<form id="loginForm" action="login/login.do" method="post">

  <label for="name">姓名</label>
  <input type="text" class="required" id="name" name="name" value="" />

  <label for="pwd">密码</label>
  <input type="text" class="required" id="pwd" name="pwd" value="" />

  <div class="form-actions">
	<input type="submit" value="登录" />
  </div>
</form>
</body>
</html>