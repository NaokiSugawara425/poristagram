<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- main要素に囲まれたところは各ページ自由に記述OKです。
	それ以外はいじらないでください。
	ここからがmain要素 -->
<div id = "main">
<center>
<h1>ログアウトしました</h1>
<a href="./jsp/login.jsp">ログイン画面へ</a>
</center>
</div>
	<!-- ここまでがmain要素 -->
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

