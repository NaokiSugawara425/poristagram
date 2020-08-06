<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>toi03_request.jsp</title>
</head>
<body>
<form action="toi03_response.jsp" method="post">
氏名：<input type="text" name="text01" size="20" maxlength="18" /><br>
年齢：<input type="text" name="text02" size="20" maxlength="18" /><br>
性別：男<input type="radio" name="s1" value="male" />
		女<input type="radio" name="s1" value="female" /><br>
ご意見、ご感想<br>
<textarea name = "text03"rows = "5" cols="50" >ご自由にお書きださい</textarea><br>
<input type="submit" value="送信" />
</form>
</body>
</html>