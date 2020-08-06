<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main.jsp</title>
</head>
<body>
<center>
	アクションタグ実験
</center>
<table width = "100%" border = '1'>
	<tr>
		<td width = "20%" height = "500">
			<div align = "center">
				<jsp:include page = "left.jsp"/>
			</div>
		</td>
		<td>
			<div align = "center">
				<jsp:include page = "right.jsp"/>
			</div>
		</td>
	</tr>
</table>
<center>
	copyright 2017 saitamacenter
</center>
</body>
</html>