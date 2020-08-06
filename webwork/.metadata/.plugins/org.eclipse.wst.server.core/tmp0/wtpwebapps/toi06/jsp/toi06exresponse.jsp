<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "toi06.Circle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi06response.jsp</title>
</head>
<body>
<jsp:useBean id = "cir" scope = "request" type = "toi06.Circle" />
結果出力<br>
入力された半径は
${ circle.hankei }
でした<br>
<br>
直径は${ circle.tyokkei }<br>
円周は${ circle.tyokkei }<br>
面積は${ circle.tyokkei }です<br>
</body>
</html>