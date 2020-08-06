<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.net.URLEncoder" %>
<%
 	String jsp = URLEncoder.encode("JSP", "UTF-8");
 	String servlet = URLEncoder.encode("サーブレット", "UTF-8");
	String mvc = URLEncoder.encode("MVCパターン", "UTF-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>re-08_request</title>
</head>
<body>
<a href= "../Rei08Controller?text01=<%= jsp %>">JSP</a><br>
<a href= "../Rei08Controller?text01=<%= servlet %>">サーブレット</a><br>
<a href= "../Rei08Controller?text01=<%= mvc %>">MVCパターン</a><br>
</body>
</html>