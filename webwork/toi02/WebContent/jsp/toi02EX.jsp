<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
private int max = 0;
private int ans = 0;
public void setData(int max){
	this.max = max;
}

int goukei(){
	for(int i = 0; i <= this.max; i++){
		this.ans += i;
	}
	return ans;
}


%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi02</title>
</head>
<body>
<% int k = 10; %>
問02のJSPからの出力です。<br>
<% setData(k) ;%>
0から
<%= k %>
までの合計は・・・<br>
<%= goukei()%><br>
です。
</body>
</html>