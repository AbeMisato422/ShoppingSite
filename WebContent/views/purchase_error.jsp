<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

<% if(session.getAttribute("userBean")==null){
	request.getRequestDispatcher("login.jsp").forward(request, response);
} %>

<div class="center">
購入手続き中にエラーが発生しました。
<p><input class="backbutton" type="button" name="back" onclick="history.back()" value="戻る">
<div class="center">
<%@include file="footer.jsp" %>