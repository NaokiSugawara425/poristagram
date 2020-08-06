<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

request.setCharacterEncoding("UTF-8");
String[] color=request.getParameterValues("color");

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
好きな色は・・・<br>
<%
if(color != null){
	for(int i=0; i <= color.length-1; i++){

		out.print(color[i]);
		if(i != color.length-1)
			out.print("と");
	}
}
else{
	out.print("これ以外");
}
%><br>
ですね！
</body>
</html>