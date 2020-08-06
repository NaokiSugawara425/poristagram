<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "rei08.Rei08Bean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei08_response.jsp</title>
</head>
<body>
<jsp:useBean id = "rei08bean" scope = "request" type = "rei08.Rei08Bean" />
受け取ったデータ：
<%-- ${rei08bean.text01 } --%>
<jsp:getProperty name = "rei08bean" property = "text01" />
</body>
</html>