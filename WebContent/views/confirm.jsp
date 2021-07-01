<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% if(session.getAttribute("userBean")==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
} %>


<p class="hello">ようこそ${userBean.name}さん！</p>
<h3 class="center">ご注文ありがとうございました！</h3>

<h4 class="heading">ご注文情報</h4>
<%int sum=0;
pageContext.setAttribute("sum", sum); %>
<table>
<c:forEach var="item" items="${cart}">
	<tr>
	<td><div class="small">商品名</div>${item.itemBean.itemName}<br></td>
	<td><div class="small">値段(税込み)</div>${item.itemBean.price}円<br></td>
	<td><div class="small">個数</div>${item.count}<br></td>
	<td><div class="small">小計</div> ${item.itemBean.price*item.count}円
	</tr>
	<div hidden>${sum=sum+item.itemBean.price*item.count}</div>
</c:forEach>
</table>

<p class="right">送料　0円<br>
合計　${sum}円</p>

<%session.removeAttribute("cart"); %>

<form method="post" name="logout" action="logoutservlet">
	<p class="center"><input class="button" type="submit" value="ログアウト"></p>
</form>


<%@include file="footer.jsp" %>
