<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="poristagram.LoginBean" %>
<%@ page import="poristagram.PostBean" %>
<%@ page import="poristagram.FollowerBean" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <form action="/poristagram/LogoutController" method="post">

<input type="submit" value="ログアウト">

</form>