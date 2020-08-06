<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>FileUpload</title>
<meta http-equiv="Content-Type"
        content="text/html; charset=Windows-31J">
</head>

<body>
<!-- (1)<FORM>タグにmultipart/form-dataを指定 -->
<form method="POST"
        enctype="multipart/form-data"
        action="UploadFile">
    <!-- (2)ファイルを選択する<input type="file">タグを指定 -->
    <input type="file" name="filefd" />
    <input type="submit" value="送信" />
</form>
</body>
</html>