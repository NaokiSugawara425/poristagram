<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>確定</title>
</head>
<body>
<c:out value = "${company }"/>様 以下の内容で注文を確定しました。<br>
<br>
送付先<br>
<c:out value = "${address }"/>

<!-- 表の作成、線の太さ１ -->
<table border = "1">

	<!-- 1行目 -->
	<tr>

		<!-- 1行目、1列目 -->
		<td>商品名</td>

		<!-- 1行目、2列目 -->
		<td>価格</td>

		<!-- 1行目、3列目 -->
		<td>数量</td>
	</tr>

	<c:forEach var = "orderListItem" items = "${orderListTotal }">
	<!-- i行目 -->
	<tr>

		<!-- i行目、1列目 -->
		<td>
			<c:out value = "${orderListItem.syohin }"/>
		</td>

		<!-- i行目、2列目 -->
		<td>
			<c:out value = "${orderListItem.price }"/>円
		</td>

		<!-- i行目、3列目 -->
		<td>
			<c:out value = "${orderListItem.caseNum }"/>ケース
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>