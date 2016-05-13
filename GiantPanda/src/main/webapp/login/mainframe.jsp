<%@ page language="java"  pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>

<html ng-app="myModel">
	
	
		
		
	
		
		
		
	
<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    	<meta name="renderer" content="webkit">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>主页</title>
		<link rel="stylesheet" href="css/mainpage.css" />
		<script src="<%=request.getContextPath()%>/plugins/angular-1.4.0/angular.min.js"></script>
    	<script src="<%=request.getContextPath()%>/plugins/restangular-1.4.0/restangular.min.js"></script>
		<script src="<%=request.getContextPath()%>/plugins/lodash.js"></script>
		<script src="<%=request.getContextPath()%>/myjs/controller.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/jquery-1.8.3.min.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/myjs/menu.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/myjs/mainpage.js" ></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/tableexport/tableExport.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/plugins/tableexport/jquery.base64.js"></script>
		
	</head>
	<body>
		<div>
		<a href="${pageContext.request.contextPath}/j_spring_security_logout">logout</a></div>
		<div id="menubox" class="menubox">
			
		</div>
		<div ng-controller="TestController">
			<a href="#" ng-click="post()">post</a>
			<a href="#" ng-click="list()">list</a>
			<a href="#" ng-click="export()">export</a>
			<table id="tbtoexp">
				<tr>
				<td colspan="2">中国</td><td>num3</td>
				</tr>
				<tr>
				<td>1</td><td>2</td><td>3</td>
				</tr>
				<tr>
				<td>4</td><td>5</td><td>6</td>
				</tr>
			</table>
		</div>
	</body>
	
	
</html>

