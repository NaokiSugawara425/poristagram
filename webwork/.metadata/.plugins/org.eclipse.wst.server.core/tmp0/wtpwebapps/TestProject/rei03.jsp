<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rei03.jsp</title>
</head>

<!-- テストコントローラーにゲットでデータを送る -->
<form action =  "TestController" method = "get">

<!-- テキストボックスを用意し文字列のデータをvalueという名前にする-->
<input type = "text" name = "value"/>

<!-- ボタンを用意する、表示は送信 -->
<input type = "submit" value = "送信">

</form>
<body>
ガースー<br>
すーがー<br>
<!-- testはコントローラーで設定した名前 -->
送り先：${test}
</body>
</html>