<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Birthクラスをインポート -->
<%@ page import ="toi07.Birth" %>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi07_response</title>
</head>
<body>
※誕生日を迎えていない場合は-1歳してください。
<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>年</td>

			<!-- 1行目、2列目 -->
			<td>年齢</td>
		</tr>

		<!-- 渡されたArrayListの各要素に対して繰り返し -->
		<c:forEach var = "yearAndOld" items = "${yearAndOld }">

		<!-- i行目 -->
		<tr>

			<!-- i行目、1列目 -->
			<td>
				<c:out value = "${yearAndOld.wareki }"/>(<c:out value = "${yearAndOld.birthYear }"/>年)
			</td>

			<!-- i行目、2列目 -->
			<td>
				<c:out value = "${yearAndOld.old }"/>歳
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>