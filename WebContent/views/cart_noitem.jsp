<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if(session.getAttribute("userBean")==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
} %>
<p class="hello">ようこそ${userBean.name}さん！</p>

<form method="post" name="logout" action="../jp.co.aforce.servlet/logoutservlet">
	<input type="hidden" name="logout"><!-- hiddenは送信する情報見えない -->
	<p class="logout"><a href="javascript:logout.submit()">ログアウト</a></p>
</form>

<h3 class="center">カート</h3>




<p class="center">カートに商品がありません。</p>

<hr>

<form method="post" name="top" action="../views/top.jsp">
		<p class="right"><input class="button" type="submit" value="商品一覧へ戻る"></p></form>

<%@include file="footer.jsp" %>