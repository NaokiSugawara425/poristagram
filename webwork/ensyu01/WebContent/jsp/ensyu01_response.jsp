<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%

request.setCharacterEncoding("UTF-8");
String name=request.getParameter("text01");
String age=request.getParameter("text02");
String s=request.getParameter("r1");
String k=request.getParameter("kanto");
String[] syumi=request.getParameterValues("syumi");
String[] drink=request.getParameterValues("drink");
boolean b = true;

%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ensyu01_response</title>
</head>
<body>
<%= name %>さんの情報<br>
年齢：<%= age %>才<br>
性別：<%= s %><br>
出身地：<%= k %>
趣味：<%
if(syumi != null){
	for(int i=0; i <= syumi.length-1; i++){
		out.print(syumi[i]);
		if(i != syumi.length-1)
			out.print(",");
	}
}
else{
	out.print("なし");
}
%>
です。<br>
<%
if(drink == null){
	out.print("好きな飲み物を選択してください。");
	b = false;
}else {
	out.print("好きな飲み物は"+ drink.length+"つです。");
}
if(b == true){
	for(int i=0; i <= drink.length-1; i++){
		if(drink[i].equals("なし")){
			out.print("好きな飲み物はなしです。");
			b = false;
		}else if(drink[i].equals("生き血")){
			out.print("あなたはヴァンパイアです。");
		}
	}
}
%>
<br>
<%
if (b == true){
	out.print("(");
	for(int i=0; i <= drink.length-1; i++){
		out.print(drink[i]);
		if(i != drink.length-1)
		out.print(",");
	}
	out.print(")");
}

%>
</body>
</html>