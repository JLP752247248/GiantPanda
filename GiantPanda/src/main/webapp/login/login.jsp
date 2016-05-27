<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<html>
<head>
<title>登录页面</title>
	<link rel="stylesheet" href="/GiantPanda/style/css/login.css">
</head>
<body>

				<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
					
					<div class="login">
					<h1>Login</h1>
				<input type="text" name="j_username" placeholder="用户名"value="${SPRING_SECURITY_LAST_USERNAME }">
				<input type="password" name="j_password" placeholder="密码" value="${SPRING_SECURITY_LAST_PASSWORD }">
				<input type="submit" name="login"value="登录" class="btn btn-primary btn-block btn-large"><input type="button" name="reghist"class="btn btn-primary btn-block btn-large"value="注册">
					</div>	
				</form>
		
</body>
</html>