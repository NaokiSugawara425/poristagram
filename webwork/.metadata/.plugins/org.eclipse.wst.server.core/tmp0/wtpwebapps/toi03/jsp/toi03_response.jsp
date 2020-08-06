<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
	String value1 = request.getParameter("text01");
	String value2 = request.getParameter("text02");
	String value3 = request.getParameter("s1");
	String value4 = request.getParameter("text03");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi03_response</title>
</head>
<body>
問03のJSPからの出力<br>
氏名欄の入力：「<%= value1 %>」<br>
年齢欄の入力：「<%= value2%>」<br>
性別の選択：「<%= value3%>」<br>
感想欄の入力：「<%= value4%>」
</body>
</html>