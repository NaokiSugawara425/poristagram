<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poristagram.LoginBean" %>
<%@ page import="poristagram.PostBean" %>
<%@ page import="poristagram.FollowerBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アイコンアップロード</title>
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
	自分のアイコンに登録する画像を選択してください
		<form method="POST" enctype="multipart/form-data" action="./IconController">
		<input type="file" name="Icon"/><br />
		<input type="submit" value="アップロード" />
		アップロードには10秒かかります。
		</form>
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
