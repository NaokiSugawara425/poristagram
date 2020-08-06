<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- rensyu2パッケージのRensyu2Beanクラスをインポート -->
<%@ page import="rensyu2.Rensyu2Bean"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 配列を宣言 -->
<%
	String[] ken = {"神奈川県","東京都","埼玉県","千葉県","栃木県","茨城県","群馬県"};

	// 配列の長さを宣言
	int kenLength = ken.length;

	// ken、kenLengthという名前で配列と整数のデータをこのページスコープに登録
	pageContext.setAttribute("ken", ken);
	pageContext.setAttribute("kenLength", kenLength);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rensyu2_request</title>
</head>
<body>
<!-- データを送信するときは../Rensyu2Controllerに送る、送信方式POST -->
<form action = "../Rensyu2Controller" method = "POST">

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>弊社を利用したことがありますか？</td>

			<!-- 1行目、2列目 -->
			<td>

				<!-- ラジオボタンを表示 -->
				<input type= "radio" name = "use" value = "初めて利用する" checked>初めて利用する
				<input type= "radio" name = "use" value = "利用したことがある">利用したことがある
			</td>
		</tr>

		<!-- 2行目 -->
		<tr>

			<!-- 2行目、1列目 -->
			<td>会社の所在地を入力してください<c:out value = "${ken[0] }"/></td>

			<!-- 2行目、2列目 -->
			<td>

				<!-- セレクトボックスを表示 -->
				<select name = "live1">

					<!-- 配列要素を追加 -->
					<c:forEach var = "i" begin = "0" end = "${kenLength }" step = "1">
						<option value = "${ken[i] }"><c:out value = "${ken[i] }"/></option>
					</c:forEach>
				</select>

				<!-- テキストボックスの追加 -->
				<input type = "text" name = "live2"/>
			</td>
		</tr>

		<!-- 3行目 -->
		<tr>

			<!-- 3行目、1列目 -->
			<td>会社名を入力してください</td>

			<!-- 3行目、2列目 -->
			<td>

				<!-- テキストボックス表示 -->
				<input type = "text" name = "company"/>
			</td>
		</tr>

		<!-- 4行目 -->
		<tr>

			<!-- 4行目、1列目 -->
			<td>発注予定のパソコン周辺機器を選択してください(複数選択可)</td>

			<!-- 4行目、2列目 -->
			<td>

				<!-- チェックボックス表示 -->
				<input type ="checkbox" name ="pcItem" value = "光学式マウス" >光学式マウス
				<input type ="checkbox" name ="pcItem" value = "19インチ液晶モニタ">19インチ液晶モニタ
				<input type ="checkbox" name ="pcItem" value = "DVD-RAMドライブ">DVD-RAMドライブ
			</td>
		</tr>

		<!-- 5行目 -->
		<tr>

			<!-- 5行目、1列目 -->
			<td>弊社の製品情報の入手方法を選択してください(複数選択可)</td>

			<!-- 5行目、2列目 -->
			<td>

				<!-- セレクトボックス表示 複数選択可-->
				<select name = "infomation" multiple>
					<option value = "郵送">郵送</option>
					<option value = "メール">メール</option>
					<option value = "訪問">訪問</option>
				</select>
			</td>
		</tr>
	</table>

	<!-- 送信ボタンの表示 -->
	<p>
		<input type = "submit" value = "決定">
	</p>
</form>
</body>
</html>