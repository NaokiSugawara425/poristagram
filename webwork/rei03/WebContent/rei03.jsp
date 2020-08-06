<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%!
private int x = 0;
private int y = 0;

public void setData(int x, int y){
	this.x = x;
	this.y = y;
}

public int tashi(){
	return this.x + this.y;
}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei03.jsp</title>
</head>
<body>
<% setData(10, 20); %>
<%= "x=" + this.x %><br>
<%= "y=" + this.y %><br>
<%= "x+y" + this.tashi() %>
</body>
</html>