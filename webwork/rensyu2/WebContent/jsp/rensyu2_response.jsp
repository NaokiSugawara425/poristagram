<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rensyu2_response</title>
</head>
<body>
<!-- 表の作成、線の太さ１ -->
	<table border = "1">

	<!-- 1行目 -->
	<tr>

		<!-- 1行目、1列目 -->
		<td>弊社の利用</td>

		<!-- 1行目、2列目 -->
		<td>

			<!-- rei10beanのデータが送られてきているのでフィールドを参照できる -->
			<c:out value = "${rensyu2Bean.use }"/>
		</td>
	</tr>

	<!-- 2行目 -->
	<tr>

		<!-- 2行目、1列目 -->
		<td>会社の所在地</td>

		<!-- 2行目、2列目 -->
		<td>
			<c:out value = "${rensyu2Bean.live }"/>
		</td>
	</tr>

	<!-- 3行目 -->
	<tr>

		<!-- 3行目、1列目 -->
		<td>会社名</td>

		<!-- 3行目、2列目 -->
		<td>
			<c:out value = "${rensyu2Bean.company }"/>
		</td>
	</tr>

	<!-- 4行目 -->
	<tr>

		<!-- 3行目、1列目 -->
		<td>発注予定のパソコン周辺機器</td>

		<!-- 3行目、2列目 -->
		<td>

			<!-- このデータは複数あるのでforEachですべて取り出す -->
			<c:forEach var = "pcItem" items = "${rensyu2Bean.pcItem }">
				<c:out value = "${pcItem }"/><br>
			</c:forEach>
		</td>
	</tr>

	<!-- 5行目 -->
	<tr>

		<!-- 5行目、1列目 -->
		<td>製品情報の入手方法</td>

		<!-- 5行目、2列目 -->
		<td>

			<!-- このデータは複数あるのでforEachですべて取り出す -->
			<c:forEach var = "infomation" items = "${rensyu2Bean.infomation }">
				<c:out value = "${infomation }"/><br>
			</c:forEach>
		</td>
	</tr>
	</table>
</body>
</html>