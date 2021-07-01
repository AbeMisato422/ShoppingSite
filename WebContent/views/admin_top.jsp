<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if(session.getAttribute("userBean")==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
} %>

<!-- ナビメニュー -->
<nav id="nav">
<img id="batsu" src="../img/batsu.png" style="width:7%; height:5%; padding-top:85px; padding-left:30px;">
  <ul>
  <li><h4>商品検索</h4></li>
  	<li><h4>　カテゴリ</h4></li>

    <li><a href="../jp.co.aforce.servlet/admincategory1servlet">　フルーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/admincategory2servlet">　ドライフルーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/admincategory3servlet">　スイーツ</a></li>
    <li><a href="../jp.co.aforce.servlet/admincategory4servlet">　訳あり商品</a></li>

    <li><h4>　並び替え</h4></li>

    <li><a href="../jp.co.aforce.servlet/adminpriceascservlet">　値段の安い順</a></li>
    <li><a href="../jp.co.aforce.servlet/adminpricedescservlet">　値段の高い順</a></li>

  </ul>
</nav>



<h2 class="center">管理者画面</h2>
<p class="hello">ようこそ${userBean.name}さん！</p>

<form method="post" name="logout" action="../jp.co.aforce.servlet/logoutservlet">
	<input type="hidden" name="logout"><!-- hiddenは送信する情報見えない -->
	<p class="logout"><a href="javascript:logout.submit()">ログアウト</a></p>
</form>


<!-- ハンバーガーメニューのアイコン -->
<div id="hamburger">
	<img id="search" src="../img/search.png" style="width:75%; height:75%;">

</div>

<form method="post" name="regist" action="../views/admin_regist.jsp">
	<input type="hidden" name="regist"><!-- hiddenは送信する情報見えない -->
	<p class="plusposition"><a href="javascript:regist.submit()"><img src="../img/plus.png" style="width:20%; height:20%;"></a></p>
</form>


<h3 class="center">商品管理</h3>
<p class="pinkadmin">全品全国送料無料！価格はすべて税込み表示です</p>
<div class="table">
<table>
<c:forEach var ="itemBean" items="${list}">
	<tr><th><img src="${itemBean.img}" style="width:360px; height:260px; border-radius:10px;" ></th>
	<td class="center">${itemBean.itemName}</td>
	<td>${itemBean.price}円</td>

	<td><form method="post" name="id" action="../jp.co.aforce.servlet/adminupdateservlet">
		<input type="hidden" name="id" value="${itemBean.id}">
		<input class="button" type="submit" value="変更する"></form></td>

	<td><form method="post" name="id" action="../jp.co.aforce.servlet/admindeleteservlet">
		<input type="hidden" name="id" value="${itemBean.id}">
		<input class="yellowbutton" type="submit" value="削除する"></form></td></tr>
</c:forEach>
</table>
</div>
<%@include file="footer.jsp" %>