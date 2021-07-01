<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>



<h3 style="text-align:center">ログイン</h3>
<p class="error" style="text-align: center; color:red;">${userBean.msg}</p>

<form action="../jp.co.aforce.servlet/loginservlet" method="post">

	<p style="text-align: center">
		ユーザー名*<input type="text" name="userName" value="${userBean.username}">
	</p>

	<p style="text-align: center">
		パスワード*<input type="password" name="password" value="${userBean.password}">
	</p>

	<p style="text-align: center">
		<input type="submit" id="login" value="ログインする" class="button">
	</p>

</form>
<%@include file="footer.jsp" %>