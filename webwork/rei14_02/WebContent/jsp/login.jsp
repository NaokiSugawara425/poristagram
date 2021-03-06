<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン画面</title>
</head>
<body>
<center><h1>ログイン</h1></center><br>

<!-- アカウント認証コントローラ(LoginController)へのリクエスト -->
<form action = "/loginapp/Logincontroller" method = "POST">
<center>

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>ログイン名</td>

			<!-- 1行目、2列目 -->
			<td>

				<!-- テキストボックスの表示 -->
				<input type = "text" size = "50" name = "loginName">
			</td>
		</tr>

		<!-- 2行目 -->
		<tr>

			<!-- 2行目、1列目 -->
			<td>パスワード</td>

			<!-- 2行目、2列目 -->
			<td>

				<!-- パスワード入力ボックスの表示 -->
				<input type = "password" size = "50" name = "password">
			</td>
		</tr>
	</table>

	<c:if test = "${!sessionScope.login }">
		<!-- ログインがfalseの時ログインボタン表示 -->
		<input type = "submit" value = "ログイン"/>
	</c:if>
</center>
</form><br>
<c:if test = "${sessionScope.login }"/>
<center>

	<jsp:include page="footer.jsp"/>
</center>
</body>
</html>