<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page2.jsp</title>
</head>
<body>
<!-- データを送信するときはPage2to3Controllerに送る、送信方式POST -->
<!-- ここではコントローラーがフォワードするのでパスの書き方はカレントディレクトリでよい -->
<form action = "Rensyu03_2Controller" method = "POST">
以下の内容でよろしいでしょうか？

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>品名</td>

			<!-- 1行目、2列目 -->
			<td>発注数</td>
		</tr>
		<c:forEach var = "orderListItem" items = "${orderList }">
		<!-- i行目 -->
		<tr>

			<!-- i行目、1列目 -->
			<td>
				<c:out value = "${orderListItem.syohin }"/>
			</td>

			<!-- i行目、2列目 -->
			<td>
				<c:out value = "${orderListItem.number }"/>
			</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	会社名を入力してください<br>
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>会社名</td>

			<!-- 1行目、2列目 -->
			<td>
				<input type = "text" name = "company" size = "80" maxlength = "80"/>
			</td>
		</tr>
	</table>
	<p>
	<!-- 送信ボタンの表示 -->
		<input type = "submit" value = "決定">
	</p>
</form>
</body>
</html>