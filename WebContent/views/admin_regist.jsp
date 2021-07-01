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

<h3 class="center">新規商品登録</h3>

<div class="center">
<form method="post" name="update" action="../jp.co.aforce.servlet/adminregistservlet" onsubmit="return beforeSubmit()">
商品画像（画像のパスを入力してください。）：<input type="text" name="img" size="30" value="${itemBean.img}"><br>
	<p>商品名：<input type="text" name="itemname" size="30" value="${itemBean.itemName}"><br></p>
	<p>値段（税込み）：<input type="text" name="price" size="6" value="${itemBean.price}">円<br></p>
	<p>カテゴリ：
	<select class="inputselect" name="category">
		<option value="${itemBean.categoryId }" selected>${itemBean.category}</option>
		<option value="1">フルーツ</option>
		<option value="2">ドライフルーツ</option>
		<option value="3">スイーツ</option>
		<option value="4">訳あり商品</option>
	</select>
	<p style="text-align: center; color:red;">${itemBean.msg}</p>

	<p><input class="backbutton" type="button" name="back" onclick="history.back()" value="戻る">

	<input class="widewhitebutton" type="submit" value="新規登録"></p>
</form>
</div>

<footer>
<p class="copyright" style="text-align:center">Copyright 2021 Frutas</p>
</footer>
</div>
<script>
	function beforeSubmit(){
		if(window.confirm('商品を登録します。よろしいですか？')){
			return true;
		}else{
			return false;
		}
	}
</script>

</body>
</html>
<!-- %@include file="footer.jsp" %-->