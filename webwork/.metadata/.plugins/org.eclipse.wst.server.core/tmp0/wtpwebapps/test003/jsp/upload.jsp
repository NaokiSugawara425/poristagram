<%@ page
 language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ファイルアップロード</title>
</head>
<body>
<form method="POST" enctype="multipart/form-data" action="../UploadServlet">
<input type="file" name="file"/><br />
<input type="submit" value="アップロード" />
アップロードには10秒程度かかります。
</form>
</body>
</html>
