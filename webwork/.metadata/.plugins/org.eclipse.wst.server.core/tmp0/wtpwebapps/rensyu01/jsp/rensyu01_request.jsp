<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rensyu01_request</title>
</head>
<body>
<!-- Rensyu01Controllerにデータをおくるよー -->
<form action="../Rensyu01Controller" method="POST">
	<input type="text" name="text01" size="20" maxlength="18" />
	+
	<input type="text" name="text02" size="20" maxlength="18" />
	<input type="submit" value="実行"/>
</form>
</body>
</html>