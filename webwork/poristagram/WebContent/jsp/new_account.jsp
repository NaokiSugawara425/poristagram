<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="../Save_accountController" method="post">
<center>
<!--  <img src="${pageContext.request.contextPath}/images/logo.png" > -->
<br>
<table border="1">
	<tr>
	<td>User Name </td>
	<td><input type="text" size="50" name="u_name"></td>
	</tr>
	<tr>
	<td>Password</td>
	<td><input type="password" size="50" name="u_pass"></td>
	</tr>
</table>
<br>
<c:if test="${!sessionScope.login }">
<input type="submit" value="登録">
</c:if>
</center>
</form><br>

</div>
<div id="footer">
	<p>

		<a class="girly_btn_2" href="/poristagram/HomeController">Home</a>
		<a class="girly_btn_2" href="/poristagram/UploadController">Post</a>
		<a class="girly_btn_2" href="/poristagram/Tokensaku">Search</a>
		<a class="girly_btn_2" href="/poristagram/TomypageController">MyPage</a>
		<a class="girly_btn_2" href="/poristagram/LogoutController">Logout</a>
	</p>
	</div>
</div>
</body>

</html>
