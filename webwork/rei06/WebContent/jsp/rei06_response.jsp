<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "rei06.Rei06Bean" %>
<%
	Rei06Bean rei06bean = (Rei06Bean)request.getAttribute("rei06bean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei06_response.jsp</title>
</head>
<body>
受け取ったデータ：
<%= rei06bean.getText01() %>
</body>
</html>