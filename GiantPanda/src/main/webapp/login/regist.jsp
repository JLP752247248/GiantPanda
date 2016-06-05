<%@ page language="java" contentType="text/html; charset=UTF-8"
	 pageEncoding="UTF-8"%>
<html>
<head>
<title>注册页面</title>
	<script  src="/GiantPanda/plugins/jquery-1.8.3.min.js"></script>
	<script  src="/GiantPanda/plugins/jquery.validate.min.js"></script>
	<script  src="/GiantPanda/plugins/jquery-ui-11/jquery-ui.min.js"></script>
	<script  src="/GiantPanda/plugins/messages_zh.js"></script>
	<link rel="stylesheet" href="/GiantPanda/ui/style/css/login.css">
	<script  src="/GiantPanda/plugins/jquery-ui-11/jquery-ui.js"></script>
	<link rel="stylesheet" href="/GiantPanda/plugins/jquery-ui-11/jquery-ui.css">
</head>

<body>
<form  >
<div class="regist">
	  <h1>注册</h1>
      <input type="text" placeholder="昵称"  name="username"  maxlength="18" required>
      <input type="password" placeholder="密码" id="password" name="password" required>
      <input type="password" placeholder="确认密码" name="confirm_password" equalTo="#password"  required>
      <div id="sort-sex">
	       <input type="radio"  checked='true' name="sex" id="radio1" value="m"/><label for="radio1">男</label>
	       <input type="radio" name="sex" id="radio2" value="w"/><label for="radio2">女</label>
      </div>
      <input type="text" placeholder="手机"  name="telephone" telphoneValid="true" required>
      <input type="email" placeholder="邮箱" name="mailAdd" required >
      <input  type="button" id="regist_sub" class="btn btn-primary btn-block btn-large" value="提交" />
      <a  href="login.jsp" class="a_login">去登陆</a>
 </div>
</form>
</body>
<script>
		$(document).ready(function(){
			
			$.validator.addMethod("telphoneValid", function(value, element) { 
			    var tel = /^(130|131|132|133|134|135|136|137|138|139|150|153|157|158|159|180|187|188|189)\d{8}$/; 
			    return tel.test(value) || this.optional(element); 
			}, "请输入正确的手机号码");
			
			
			var validator=$("form").validate(
					{
					    messages: {
					      username: {
					        required: "请输入昵称",
					      },
					      password: {
					        required: "请输入密码",
					        minlength: "密码长度不能小于 5 个字母"
					      },
					      confirm_password: {
					        required: "请输入密码",
					        minlength: "密码长度不能小于 5 个字母",
					        equalTo: "两次密码输入不一致"
					      },
					      email: "请输入一个正确的邮箱"
					    }
					}		
			);
			$('#sort-sex').buttonset();	
			$('#regist_sub').bind('click',function(){
				if(validator.form()){
				var data={};
				var formelems=$('form')[0];
				for(var i=0;i<formelems.length;i++)
				{	if(null!=formelems[i].name && ""!=formelems[i].name)
							data[formelems[i].name]=formelems[i].value;
				}
				$.ajax({
					  url:"${pageContext.request.contextPath}/service/userinfo/regist",
					  type:"POST",
					  contentType:'application/json',
					  async:false,
					  data:JSON.stringify(data),
					  success:function(data, textStatus, jqXHR){
						  alert(data);
					  },
					  error:function(XMLHttpRequest, textStatus, errorThrown){
						  alert("异常！");
					  }
				  });
				}
			})
		});
</script>
</html> 