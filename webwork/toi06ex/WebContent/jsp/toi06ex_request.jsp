<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi06ex_request.jsp</title>
</head>
<body>
<!-- 1つ上のディレクトリのtoi06Controllerという名前にPOST形式で送る -->
<form action="../toi06Controller" method="POST">
	半径を入力：
	<!-- テキストボックスを用意しデータにtext01という名前を付ける -->
	<input type="text" name="text01" size="20" maxlength="18" /><br>
	<!-- ボタンの実装、表示は実行 -->
	<input type="submit" value="実行"/>
</form>
</body>
</html>