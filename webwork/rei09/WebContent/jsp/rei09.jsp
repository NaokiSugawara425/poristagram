<!-- 文字コードの設定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- rei09パッケージのRei09Beanクラスをインポート -->
<%@ page import="rei09.Rei09Bean"%>

<!-- ArrayListクラスをインポート -->
<%@ page import="java.util.ArrayList" %>

<!-- タグライブラリーを使うという記述 -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	// アレイリストの宣言
	ArrayList<Rei09Bean> rei09BeanArray = new ArrayList<Rei09Bean>();

	// Rei09Beanクラスのインスタンス化
	Rei09Bean rei09bean = new Rei09Bean();

	// セットメソッドでフィールドにデータをセット
	rei09bean.setValue1("データA");

	// オブジェクトをアレイリストに追加
	rei09BeanArray.add(rei09bean);

	// Rei09Beanクラスのインスタンス化
	rei09bean = new Rei09Bean();

	// セットメソッドでフィールドにデータをセット
	rei09bean.setValue1("データB");

	// オブジェクトをアレイリストに追加
	rei09BeanArray.add(rei09bean);

	// Rei09Beanクラスのインスタンス化
	rei09bean = new Rei09Bean();

	// セットメソッドでフィールドにデータをセット
	rei09bean.setValue1("データC");

	// オブジェクトをアレイリストに追加
	rei09BeanArray.add(rei09bean);

	// rei09BeanArrayという名前でアレイリストのデータをこのページスコープに登録
	pageContext.setAttribute("rei09BeanArray", rei09BeanArray);
%>
<!-- htmlのバージョンの記述 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<font size = "6">
	c:setとc:outの実験<br>

	<!-- JSTLタグで変数var、値10をセット -->
	<c:set var="cSetValue" value="10"/>

	<!-- JSTLタグで値の表示(変数を書くだけでは値は表示されない) -->
	cSetValue:<c:out value="${cSetValue }"/><br>

	c:outのエスケープ実験<br>

	<!-- ただ記述しただけでは表示されない文字もc:outを使うと表示できる -->
	&lt;:<c:out value="<"/><br>

	c:foreachの実験(begin、endを利用)<br>

	<!--
		c:forEachを利用し繰り返し文が書ける
		変数 i 初期値 10 修了条件 16 増減 +2 varStatus名 sv
	-->
	<c:forEach var="i" begin="10" end="16" step="2" varStatus="sv">

		<!-- i の値を表示 -->
		var:<c:out value="${i }"/><br>

		<!-- 現在何回目の繰り返しか表示 -->
		varStatus.count:<c:out value="${sv.count }"/><br>

		<!-- 現在が最後の繰り返しかtrueかfalseで表示 -->
		varStatus.last:<c:out value="${sv.last }"/><br>
	</c:forEach>

	c:forEachの実験(itemsを利用)<br>
	<!--
		拡張for文のような繰り返し文が書ける
		変数 item にアレイリストの要素0から最後までを代入し処理
	-->
	<c:forEach var = "item" items = "${rei09BeanArray }">

		<!-- item Rei09Bean型なのでフィールドを取り出せる-->
		<c:out value = "${item.value1 }"/><br>
	</c:forEach>

	c:choose、c:when、c:otherwise の実験<br>

	<!--
		条件分岐を書くことができる
		testに条件を代入しtrueなら処理するイメージ
	 -->
	<c:choose>
		<c:when test =  "${20 < cSetValue }">

			<!-- cSetValueが20より大きい時の処理 -->
			<c:out value = "cSetValueは20よりも大きい"/>
		</c:when>
		<c:when test =  "${(cSetValue <= 20) && (5 < cSetValue)}">

			<!-- cSetValueが20以下、５より大きい時の処理 -->
			<c:out value = "cSetValueは20以下で５より大きい"/>
		</c:when>
		<c:otherwise>

			<!-- それ以外の処理 -->
			<c:out value = "cSetValueは５以下"/>
		</c:otherwise>
	</c:choose><br>
</font>
</body>
</html>