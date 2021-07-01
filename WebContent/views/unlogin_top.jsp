<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- ナビメニュー -->
<nav id="nav">
<img id="batsu" src="../img/batsu.png" style="width:9%; height:5%; padding-top:110px; padding-left:35px;">
  <ul>
  <li><h4>商品検索</h4></li>
  	<li><h4>　カテゴリ</h4></li>

    <li><a href="../jp.co.aforce.servlet/category1servlet">　フルーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/category2servlet">　ドライフルーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/category3servlet">　スイーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/category4servlet">　訳あり商品</a></li>

    <li><h4>　並び替え</h4></li>

    <li><a href="../jp.co.aforce.servlet/priceascservlet">　値段の安い順</a></li>
    <li><a href="../jp.co.aforce.servlet/pricedescservlet">　値段の高い順</a></li>

  </ul>
</nav>

<p class="hello">ようこそゲストさん！</p>

<form method="post" name="login" action="login.jsp">
	<input type="hidden" name="login"><!-- hiddenは送信する情報見えない -->
	<p class="logout"><a href="javascript:login.submit()">ログイン</a></p>
</form>


<form method="post" name="cart" action="../views/login.jsp">
	<input type="hidden" name="id" value="0">
	<p class="cartposition"><input type="image" src="../img/cart.png" style="width:20%; height:20%; display:inline;" name="cart" alt="カート"></p><!-- hiddenは送信する情報見えない -->
</form>
<h3 class="center">商品一覧</h3>






<p class="pink">全品全国送料無料！価格はすべて税込み表示です</p>
<div class="table">
<table>
<c:forEach var ="itemBean" items="${list}">

	<tr>
		<th><img src="${itemBean.img}"
			style="width: 360px; height: 260px; border-radius: 10px;"></th>
		<td class="center">${itemBean.itemName}</td>
		<td>${itemBean.price}円</td>
		<td><form method="post" name="id" action="../views/login.jsp">
				<input type="hidden" name="id">
				<input class="button" type="submit" value="カートに入れる">
			</form></td>
	</tr>
</c:forEach>
</table>
</div>

<%@include file="footer.jsp" %>