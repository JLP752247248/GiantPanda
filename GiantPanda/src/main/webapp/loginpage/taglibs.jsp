<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<% 
//response.setHeader("Pragma","No-cache"); 
//response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
//response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
request.setAttribute("ctx", request.getContextPath());
%> 

<script>
	window.CTX = "${ctx }";
</script>