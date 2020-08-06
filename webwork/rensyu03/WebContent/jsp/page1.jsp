<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- ArrayListクラスをインポート -->
<%@ page import="java.util.ArrayList" %>

<%
	// 配列を宣言
	String[] syohin = {"光学式マウス", "19インチ液晶モニタ", "DVD-RAMドライブ"};

	//seminarという名前で配列のデータをこのページスコープに登録
	pageContext.setAttribute("syohin", syohin);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>page1.jsp</title>
</head>
<body>
<!-- データを送信するときは../page1to2Controllerに送る、送信方式POST -->
<form action = "../Rensyu03Controller" method = "POST">
発注したい品名と発注数

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>品名</td>

			<!-- 1行目、2列目 -->
			<td>発注数</td>
		</tr>

		<!-- 宣言しておいたseminarの各要素に対して繰り返し -->
		<c:forEach var = "syohinItem" items = "${syohin }">

		<!-- i行目 -->
		<tr>

			<!-- i行目、1列目 -->
			<td>

				<!-- syohinの名前のデータを隠しデータとして設定 -->
				<!-- 隠しデータは既に設定されているデータを渡したいときに使う -->
				<!-- 今回は商品名に"syohin"という名前を付けて送りたい -->
				<input type = "hidden" name = "syohin" value = "${syohinItem }"/>
				<c:out value = "${syohinItem }"/>
			</td>

			<!-- i行目、2列目 -->
			<td>

				<!-- セレクトボックスを表示 -->
				<select name = "number">

					<!-- 0から100を追加 -->
					<c:forEach var = "i" begin = "0" end = "10" step = "1">
						<option value = "${i }"><c:out value = "${i }"/></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</c:forEach>
	</table>


	<!-- 送信ボタンの表示 -->
	<p>
		<input type = "submit" value = "決定">
	</p>
</form>
</body>
</html>