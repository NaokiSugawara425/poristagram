<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei10_request.jsp</title>
</head>
<body>

<!-- データを送信するときは../Rei10Controllerに送る、送信方式POST -->
<form action = "../Rei10Controller" method = "POST">

	<!-- 表の作成、線の太さ１ -->
	<table border = "1">

		<!-- 1行目 -->
		<tr>

			<!-- 1行目、1列目 -->
			<td>性別</td>

			<!-- 1行目、2列目 -->
			<td>

				<!-- ラジオボタンを表示 -->
				<input type= "radio" name = "sei" value = "男" checked>男
				<input type= "radio" name = "sei" value = "女">女
			</td>
		</tr>

		<!-- 2行目 -->
		<tr>

			<!-- 2行目、1列目 -->
			<td>年齢</td>

			<!-- 2行目、2列目 -->
			<td>

				<!-- セレクトボックスを表示 -->
				<select name = "nen">

					<!-- 18から90を追加 -->
					<c:forEach var = "i" begin = "18" end = "90" step = "1">
						<option value = "${i }"><c:out value = "${i }"/></option>
					</c:forEach>
				</select>
			</td>
		</tr>

		<!-- 3行目 -->
		<tr>

			<!-- 3行目、1列目 -->
			<td>このセミナーをどのように知りましたか？(複数回答可)</td>

			<!-- 3行目、2列目 -->
			<td>

				<!-- チェックボックス表示 -->
				<input type ="checkbox" name ="mosidoki" value = "パンフレット">パンフレット
				<input type ="checkbox" name ="mosidoki" value = "ホームページ">ホームページ
				<input type ="checkbox" name ="mosidoki" value = "会社指示">会社指示
			</td>
		</tr>

		<!-- 4行目 -->
		<tr>

			<!-- 4行目、1列目 -->
			<td>開講を希望するセミナーを選択してください(複数選択可)</td>

			<!-- 4行目、2列目 -->
			<td>

				<!-- セレクトボックス表示 複数選択可-->
				<select name = "seminar" multiple>
					<option value = "Javaデザインパターン">Javaデザインパターン</option>
					<option value = "Spring">Spring</option>
					<option value = "JSF">JSF</option>
					<option value = "Eclipse">Eclipse</option>
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