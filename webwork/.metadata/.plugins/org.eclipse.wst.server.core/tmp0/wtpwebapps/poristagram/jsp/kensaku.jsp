<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poristagram.LoginBean" %>
<%@ page import="poristagram.PostBean" %>
<%@ page import="poristagram.FollowerBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/default.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
<title>ユーザー検索</title>
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="header_logo_image"></div>
	</div>
	<!-- main要素に囲まれたところは各ページ自由に記述OKです。
	それ以外はいじらないでください。
	ここからがmain要素 -->
<form action="./KensakuServlet" method="post" name="form1" >
	<p>
		<input type = text name="kensakuname" size="50" />
		<input type="submit" value="検索" >
	</p>
</form>
		<table>
			<c:forEach var="list" items="${listAttribute}">
					<tr>
						<td align="right">
							<form action="/poristagram/TouserpageController" method="post">
								<div class="balloon1-right" align="left">
									<p>
										<input type="hidden" name="name" value= "${list.u_name}" >

										<c:out value="${list.u_name}"/>
										<input type="submit" value="プロフィールを見る">
										<br><img src="${list.u_icon}"  width="180" height="180px" /><br>
									</p>
								</div>
							</form>
						</td>
					</tr>
			</c:forEach>
		</table>

<!-- ここまでがmain要素 -->
	<div id="footer">
	<p>
		<a class="girly_btn_2" href="/poristagram/HomeController">Home</a>
		<a class="girly_btn_2" href="/poristagram/UploadController">Post</a>
		<a class="girly_btn_2" href="/poristagram/Tokensaku">Search</a>
		<a class="girly_btn_2" href="/poristagram/TomypageController">MyPage</a>
		<a class="girly_btn_2" href="/poristagram/LogoutController">Logout</a>
	</p>
	</div>
</div>
</body>
</html>