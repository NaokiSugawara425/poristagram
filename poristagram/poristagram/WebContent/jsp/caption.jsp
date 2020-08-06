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
	<title>caption.jsp</title>
	<style type="text/css">
	table{margin:80px;}
	</style>
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
<form method="POST"  action="./UploadOkController"><br/>
	<table border="0" align="center" >
		<tr>
			<td>
				<div>
					<a>
				 		<img src="${imageUrl }" class="img-circle">
					</a>
				</div>
			</td>
		</tr>
		<tr>
			<td align="right">
				<textarea name="kome" placeholder="コメントを入力" rows="13" cols="53"></textarea>
			</td>
		</tr>
		<tr>
			<td align="right">
			<input type="text" size="51" name="tag1" placeholder="タグ1"><br>
			<input type="text" size="51" name="tag2" placeholder="タグ2"><br>
			<input type="text" size="51" name="tag3" placeholder="タグ3"><br>
			<input type="text" size="51" name="tag4" placeholder="タグ4">
			</td>
		</tr>
		<tr >
		<td align="right">
		<input type="submit" value="シェア" />
		</td>
		</tr>
	</table>
</form>


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