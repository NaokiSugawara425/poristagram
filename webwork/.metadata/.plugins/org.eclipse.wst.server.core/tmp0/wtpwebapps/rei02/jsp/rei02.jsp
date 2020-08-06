<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.Date"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei02.jsp</title>
</head>
<body>
スクリプト式による出力:<%= new Date() %><br>
スクリプトレットによる出力:<% out.println(new Date()); %>
</body>
</html>