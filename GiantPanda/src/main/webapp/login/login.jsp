<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<html>
<head>
<title>登录页面</title>
	<link rel="stylesheet" href="/GiantPanda/style/css/login.css">
</head>
<body>

				<form action="${pageContext.request.contextPath}/login" method="post">
					<div class="login">
					<h1>Login</h1>
				<!-- 	<input type="hidden" name="_csrf"
                    value="e170a292-a247-46f0-a40e-2cc80df39391" /> -->
				<input type="text" name="username" placeholder="用户名"value="${SPRING_SECURITY_LAST_USERNAME }">
				<input type="password" name="password" placeholder="密码" value="${SPRING_SECURITY_LAST_PASSWORD }">
				<input type="submit" name="login"value="登录" class="btn btn-primary btn-block btn-large"><input type="button" name="reghist"class="btn btn-primary btn-block btn-large"value="注册">
					</div>	
				</form>
		
</body>
</html>