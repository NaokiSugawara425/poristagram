<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 円クラスをインポート -->
<%@ page import ="toi06ex.Circle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi06ex_response.jsp</title>
</head>
<body>
結果出力<br>
入力された半径は
<!-- cirのオブジェクトのフィールドを参照している -->
${cir.hankei}
でした...<br>
<br>
これに対する...<br>
直径：${cir.tyokkei}<br>
円周：${cir.ensyu}<br>
面積：${cir.menseki}<br>
です。
</body>
</html>