<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String value = null;
	request.setCharacterEncoding("UTF-8");
	value = request.getParameter("text01");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei04_response.jsp</title>
</head>
<body>
受け取ったデータ　：
<%= value %>
</body>
</html>