<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
private int x = 0;
private int y = 0;
public void setData(int x){
	this.x = x;
}
int goukei(){
	for(int i = 0; i <= this.x; i++){
		this.y += i;
	}
	return y;
}

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi02</title>
</head>
<body>
問02のJSPからの出力です。<br>
<% setData(100) ;%>
0から100までの合計は・・・<br>
<%= goukei()%><br>
です。
</body>
</html>