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
<c:choose>
	<c:when test="${cart.size()>0}">
		<p class="headingleft">${cart.size()}種類の商品があります。</p>
		<hr>
	</c:when>
	<c:otherwise>
		<% request.getRequestDispatcher("cart_noitem.jsp").forward(request, response);%>
	</c:otherwise>
</c:choose>
<%int sum=0;
pageContext.setAttribute("sum", sum); %>
<table>
<c:forEach var="I" items="${cart}">
	<tr>
	<td><img src="${I.itemBean.img}" style="width:360px; height:260px; border-radius:10px;" ></td>
	<td><div class="small">商品名</div>${I.itemBean.itemName}<br></td>
	<td><div class="small">値段(税込み)</div>${I.itemBean.price}円<br></td>
	<td><div class="small">個数</div>${I.count}<br></td>
	<td><div class="small">小計</div> ${I.itemBean.price*I.count}円
	<td><a href="../jp.co.aforce.servlet/cartremoveservlet?id=${I.itemBean.id}">
	削除する</a></td>
<div hidden>${sum=sum+I.itemBean.price*I.count}</div>
	</tr>
</c:forEach>

</table>
<hr><!--水平の横線  -->
<p class="right">送料　0円<br>
合計　${sum}円</p>


<form method="post" name="purchase" action="../views/purchase.jsp">
		<p class="right"><input class="button" type="submit" value="購入手続きへ進む"></p></form>

<form method="post" name="top" action="../views/top.jsp">
		<p class="right"><input class="backbutton" type="submit" value="戻る"></p></form>


<%@include file="footer.jsp" %>