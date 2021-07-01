<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Frutas ONLINE SHOP</title>
<link href="../css/shopping_site.css" media="all" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<style>
.center{
	text-align:center;
}
.right{
	text-align:right;
}


.purchase{
	margin-left:400px;
}

.heading{
	margin-left:200px;
}

.headingleft{
	margin-left:100px;
}

table {
    margin-left: auto;
    margin-right: auto;
    margin-top:120px;
}

body{
	background:#F0E0CE;
 	font-size:22px;
}

.table{
width:1000px;
 margin-right:auto;
 margin-left:auto;
 margin-top:25px;
}


#nav{
  position: absolute;
  top: 0;
  z-index:1;
  left: -29%;
  width: 28%;
  height: 120vh;
  background-color:rgba(255,255,255,0.8);
  transition: .7s;
}
#nav ul{
  padding-top: 15px;
}
#nav ul li{
  list-style-type: none;
  font-size: 24px;
}
#nav a{
  display: block;
  text-decoration: none;
  color: #000000;
  margin: 0 15px;
  padding: 10px;
  transition: .5s;
}
#nav li a:hover{
  color: #FFFFFF;
  background: #F47A91;
  border-bottom: none;
}

#hamburger {
  display: block;
  position: absolute;
  z-index:1;
  top: 80px;
  left: 30px;
  width: 50px;
  height: 44px;
  cursor: pointer;
  transition: 1s;
}


.in{
  transform: translateX(100%);
}


.search{
	visibility:hidden;
}

header,footer{
	background-image:url(../img/fruits_header2.jpg);
	background-size:15%;
	color:black;
	text-shadow:1px 1px 0 white;
}

.wrapper{
    min-height: 100vh;
    position: relative;/*←相対位置*/
    padding-bottom: 100px;/*←footerの高さ*/
    box-sizing: border-box;/*←全て含めてmin-height:100vhに*/
}

footer{
    margin-top: 200px;
    padding-bottom:15px;
	width:100%;
    position: absolute;/*←絶対位置*/
    bottom: 0; /*下に固定*/
    height:30px;
    font-size:20px;
    font-weight:bolder;
}

header{
	height:50px;
	padding-top:10px;
}

input{
	height:25px;
	border-radius:20px;
	font-size:100%;
}

.inputselect{
	height:30px;
	border-radius:20px;
	font-size:100%;
}

.button{
	height:35px;
	font-size:20px;
	background-color:#61b852;
	color:white;
	border-rodius:20px;
}


.yellowbutton{
	height:35px;
	font-size:20px;
	background-color:#f7db66;
	border-rodius:20px;
}

.widebutton{
	height:35px;
	font-size:20px;
	background-color:#61b852;
	border-radius:20px;
	width:170px;
}

.widewhitebutton{
	height:35px;
	font-size:20px;
	background-color:#61b852;
	border-radius:20px;
	width:170px;
	color:white;
}
.backbutton{
	height:35px;
	font-size:20px;
	border-rodius:20px;
	width:170px;
	background-color:darkgray;
	color:white;
}

.pink{
	background-color:#f47a91;
	color:white;
	position:absolute;
	top:150px;
	left:300px;

}

.pinkadmin{
	background-color:#f47a91;
	color:white;
	position:absolute;
	top:220px;
	left:300px;
}

.small{
	font-size:19px;
	color:#583822;
}

h3{
	color:#61b852;
	margin-top:50px;
}

.hello{
	position:absolute;
	top:60px
}

.cartposition{
	position:absolute;
	top:80px;
	right:-200px;
}

.plusposition{
	position:absolute;
	top:80px;
	right:-170px;
}

.logout{
	position:absolute;
	top:50px;
	right:10px;
}

#search{
	width:100%;
	height:100%;
	position:absolute;
	top:30px;
}

h2{
	color:#f47a91;
}

</style>

</head>
<body>
<div class="wrapper">
<header>
<h1 style="display:inline;">Frutas</h1><h4 style="display:inline;">   ONLINE SHOP</h4>
</header>
