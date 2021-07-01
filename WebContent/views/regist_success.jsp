<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<% if(session.getAttribute("userBean")==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
} %>

<p class="hello">ようこそ${userBean.name}さん！</p>



<form method="post" name="logout" action="../jp.co.aforce.servlet/logoutservlet">
	<input type="hidden" name="logout"><!-- hiddenは送信する情報見えない -->
	<p class="logout"><a href="javascript:logout.submit()">ログアウト</a></p>
</form>

<div class="center">
新規登録に成功しました
<p><input class="backbutton" type="button" name="back" onclick="history.back()" value="戻る">
</p>
</div>
<%@include file="footer.jsp" %>