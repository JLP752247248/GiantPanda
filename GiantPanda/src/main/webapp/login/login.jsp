<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<html>
<head>
<title>登录页面</title>
	<script  src="/GiantPanda/plugins/jquery-1.8.3.min.js"></script>
	<script  src="/GiantPanda/plugins/jquery.validate.min.js"></script>
	<script  src="/GiantPanda/plugins/jquery-ui-11/jquery-ui.min.js"></script>
	<script  src="/GiantPanda/plugins/messages_zh.js"></script>
	<link rel="stylesheet" href="/GiantPanda/ui/style/css/login.css">
	<script  src="/GiantPanda/plugins/jquery-ui-11/jquery-ui.js"></script>
	<link rel="stylesheet" href="/GiantPanda/plugins/jquery-ui-11/jquery-ui.css">
</head>
<body>

				<form action="${pageContext.request.contextPath}/login" method="post">
					<div class="login">
					<h1>登录</h1>
				<input type="text" name="username" placeholder="昵称/手机/邮箱"value="${SPRING_SECURITY_LAST_USERNAME }" required>
				<input type="password" name="password" placeholder="密码" value="${SPRING_SECURITY_LAST_PASSWORD }"required>
				<label class="error">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</label>
				<input type="button" id="login_sub" name="login" value="登录" class="btn btn-primary btn-block btn-large">
				<!-- <a  href="#" class="a_forget">忘记密码</a> -->
				<a  href="regist.jsp" class="a_forget">立即注册</a>
					</div>	
				</form>
		
</body>

<script>
		$(document).ready(function(){
			var validator=$("form").validate({
			    messages: {
				      username: {
				        required: "登录名不可为空！",
				      },
				      password: {
				        required: "密码不可为空！"
				      }
				    }
				}		);
			$('#login_sub').bind('click',function(){
				$("form").submit();
			})
		});
</script>
</html>