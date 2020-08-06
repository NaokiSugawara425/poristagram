<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei10_response</title>
</head>
<body>

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

	<!-- 1行目 -->
	<tr>

		<!-- 1行目、1列目 -->
		<td>性別</td>

		<!-- 1行目、2列目 -->
		<td>

			<!-- rei10beanのデータが送られてきているのでフィールドを参照できる -->
			<c:out value = "${rei10bean.sei }"/>
		</td>
	</tr>

	<!-- 2行目 -->
	<tr>

		<!-- 2行目、1列目 -->
		<td>年齢</td>

		<!-- 2行目、2列目 -->
		<td>
			<c:out value = "${rei10bean.nen }"/>
		</td>
	</tr>

	<!-- 3行目 -->
	<tr>

		<!-- 3行目、1列目 -->
		<td>セミナーを知った理由</td>

		<!-- 3行目、2列目 -->
		<td>

			<!-- このデータは複数あるのでforEachですべて取り出す -->
			<c:forEach var = "mosidokiData" items = "${rei10bean.mosidoki }">
				<c:out value = "${mosidokiData }"/>
			</c:forEach>
		</td>
	</tr>

	<!-- 4行目 -->
	<tr>

		<!-- 3行目、1列目 -->
		<td>希望セミナー</td>

		<!-- 3行目、2列目 -->
		<td>

			<!-- このデータは複数あるのでforEachですべて取り出す -->
			<c:forEach var = "seminarData" items = "${rei10bean.seminar }">
				<c:out value = "${seminarData }"/>
			</c:forEach>
		</td>
	</tr>
	</table>
</body>
</html>