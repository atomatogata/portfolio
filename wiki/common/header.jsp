<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>PunchiWiki</title>
</head>
<body>

<%-- ロゴ --%>
<img src="img/logo.gif" width="100" height="100">

<%-- ヘッダメニュー --%>
<a href="list">一覧</a>
|
<a href="create.jsp">新規</a>

<%-- メッセージ表示 --%>
<p>${message}
<hr>