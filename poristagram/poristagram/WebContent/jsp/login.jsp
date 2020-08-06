<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poristagram.LoginBean" %>
<%@ page import="poristagram.PostBean" %>
<%@ page import="poristagram.FollowerBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">

<title>Pristagram</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="header_logo_image"></div>
	</div>
	<div id = "main">

	<form action="/poristagram/LoginController" method="post">
		<center>
			<!--  <img src="${pageContext.request.contextPath}/images/logo.png" > -->
			<br>
			<table border="1">
				<tr>
					<td>User Name </td>
					<td><input type="text" size="50" name="u_name"></td>
				</tr>
			</table>
			<br>
			<table border="1">
				<tr>
					<td>Password</td>
					<td><input type="text" size="50" name="u_pass"></td>
				</tr>
			</table>
			<br>
			<c:if test="${!sessionScope.login }">
				<input type="submit" value="ログイン">
				<a href="./new_account.jsp"> 新規登録 </a>
			</c:if>
		</center>
	</form><br>
	<c:if test="${sessionScope.login }">
		<center><jsp:include page="footer.jsp"/></center>
	</c:if>
	</div>
		<div id="footer">
		</div>
	</div>
</body>

</html>