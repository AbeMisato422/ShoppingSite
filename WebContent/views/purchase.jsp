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

<h3 class="center">購入手続き</h3>





<h4 class="heading">商品情報</h4>
<%int sum=0;
pageContext.setAttribute("sum", sum); %>
<table>
<c:forEach var="item" items="${cart}">
	<tr>
	<td><img src="${item.itemBean.img}" style="width:360px; height:260px; border-radius:10px;" ></td>
	<td><div class="small">商品名</div>${item.itemBean.itemName}<br></td>
	<td><div class="small">値段(税込み)</div>${item.itemBean.price}円<br></td>
	<td><div class="small">個数</div>${item.count}<br></td>
	<td><div class="small">小計</div> ${item.itemBean.price*item.count}円
	</tr>
	<div hidden>${sum=sum+item.itemBean.price*item.count}</div>
</c:forEach>
</table>
<hr><!--水平の横線  -->
<p class="right">送料　0円<br>
合計　${sum}円</p>

<form method="post" action="../jp.co.aforce.servlet/purchaseservlet" onsubmit="return beforeSubmit()">
<h4 class="heading">お届け先情報</h4>
<p class="error" style="text-align: center; color:red;">${userBean.errormsg}</p>
	<div class="purchase"><p>お名前*　　　<input type="text" name="name" value="${userBean.name}" readonly>様</p><br>
	<p>住所*　　　〒<input type="text" name="postalcode" size="8" value="${userBean.postalcode}"><br>
		　　　　　　　　<input type="text" name="address" size="40" value="${userBean.address}"></p><br>
	<p>お支払方法*
		<select name="payment" class="inputselect">
			<option value="${userBean.payment}">${userBean.payment}</option>
			<option value="クレジットカード">クレジットカード</option>
			<option value="コンビニ払い">コンビニ払い</option>
			<option value="銀行振込">銀行振込</option>
			<option value="代金引換">代金引換</option>
			<option value="キャリア決済">キャリア決済</option>
		</select>
	</p>
	</div>
<p class="right"><input class="widewhitebutton" type="submit" value="注文を確定する"></p></form>

<form method="post" action="../views/cart.jsp">
		<p class="right"><input class="backbutton" type="submit" value="カートへ戻る"></p></form>

<footer>
<p class="copyright" style="text-align:center">Copyright 2021 Frutas</p>
</footer>
</div>
<script src="../js/menu_bar.js"></script>
<script>
	function beforeSubmit(){
		if(window.confirm('注文を確定します。よろしいですか？')){
			return true;
		}else{
			return false;
		}
	}
</script>
</body>
</html>
<!--%@include file="purchasefooter.jsp" %-->



