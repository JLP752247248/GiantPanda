<form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
	<input type="text" name="j_username" value="${SPRING_SECURITY_LAST_USERNAME }"><br>
	<input type="password" name="j_password" value="${SPRING_SECURITY_LAST_PASSWORD }"><br>
	<input type="submit" name="login"value="login">
</form>