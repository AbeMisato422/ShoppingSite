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

<h3 class="center">商品情報変更</h3>
<div class="center">

<form method="post" name="update" action="../jp.co.aforce.servlet/adminupdate2servlet" onsubmit="return beforeSubmit()">
	<input type="hidden" name="img" value="${itemBean.img}">
	<img src="${itemBean.img}" style="width:360px; height:260px; border-radius:10px;" ><br>
	<p>商品名：<input type="text" name="updatename" size="30" value="${itemBean.itemName}"><br></p>
	<p>値段（税込み）：<input type="text" name="updateprice" size="6" value="${itemBean.price}">円<br></p>
	<p style="text-align: center; color:red;">${itemBean.msg}</p>

	<p><input class="backbutton" type="button" name="back" onclick="history.back()" value="戻る">
	<input type="hidden" name="id" value="${itemBean.id}">
	<button class="widewhitebutton" type="submit">変更</button></p>
</form>
</div>
<footer>
<p class="copyright" style="text-align:center">Copyright 2021 Frutas</p>
</footer>
</div>
<script>
	function beforeSubmit(){
		if(window.confirm('商品を変更します。よろしいですか？')){
			return true;
		}else{
			return false;
		}
	}
</script>


</body>
</html>
<!-- %@include file="footer.jsp" %-->