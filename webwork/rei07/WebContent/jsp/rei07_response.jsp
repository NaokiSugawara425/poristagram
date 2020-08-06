<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ page import = "rei07.Rei07Bean" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei07_response.jsp</title>
</head>
<body>
<jsp:useBean id="rei07bean" scope="request" type="rei07.Rei07Bean" />
受け取ったデータ：
<%-- <jsp:getProperty name="rei07bean"
 property="text01" /> --%>
${rei07bean.text01}
</body>
</html>