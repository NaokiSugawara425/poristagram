<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- Orderクラスをインポート -->
<%@ page import="toi08_2.Order" %>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- ArrayListクラスをインポート -->
<!-- 送信先のコントローラで使う -->
<%@ page import="java.util.ArrayList" %>

<%

	// Orderクラスを利用しオブジェクトをアレイリストに格納
	Order order  = new Order();
	ArrayList<Order> list = new ArrayList<Order>();

	order.setSyohin("おいしいお茶");
	order.setPrice(1200);
	list.add(order);


	order = new Order();
	order.setSyohin("ミネラル健康水");
	order.setPrice(1000);
	list.add(order);

	order = new Order();
	order.setSyohin("スカッとメロン");
	order.setPrice(2400);
	list.add(order);

	// リクエストスコープに登録
	request.setAttribute("syohin", list);

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文</title>
</head>
<body>
<!-- データを送信するときは../Toi08_2ControllerToKakuninに送る、送信方式POST -->
<form action = "../Toi08_2ControllerToKakunin" method = "POST">

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

		<!-- 宣言しておいたsyohinの各要素に対して繰り返し -->
		<c:forEach var = "listItem" items = "${syohin }" >

		<!-- i行目 -->
		<tr>

			<!-- i行目、1列目 -->
			<td>

				<!-- syohinの名前のデータを隠しデータとして設定 -->
				<!-- 隠しデータは既に設定されているデータを渡したいときに使う -->
				<!-- 今回は商品名に"syohin"という名前を付けて送りたい -->
				<input type = "hidden" name = "syohin" value = "${listItem.syohin }"/>
				<c:out value = "${listItem.syohin }"/>
			</td>

			<!-- i行目、2列目 -->
			<td>

				<!-- 価格のデータを隠しデータとして設定 -->
				<!-- 隠しデータは既に設定されているデータを渡したいときに使う -->
				<!-- 今回は価格に"price"という名前を付けて送りたい -->
				<input type = "hidden" name = "price" value = "${listItem.price }"/>
				<c:out value = "${listItem.price }"/>円
			</td>
			<!-- i行目、3列目 -->
			<td>

				<!-- セレクトボックスを表示 -->
				<select name = "caseNum">

					<!-- 0から10を追加 -->
					<c:forEach var = "j" begin = "0" end = "10" step = "1">
						<option value = "${j }"><c:out value = "${j }ケース"/></option>
					</c:forEach>
				</select>
			</td>
		</tr>
		</c:forEach>
	</table>

	<!-- 送信ボタンの表示 -->
	<p>
		<input type = "submit" value = "送信">
	</p>
</form>
</body>
</html>