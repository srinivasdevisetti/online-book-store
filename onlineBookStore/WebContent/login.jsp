<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"
%>
<!DOCTYPE html>
<head>
 <link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="heder.css">
<meta charset="ISO-8859-1">
<script src="login.js"></script>
<style type="text/css">
span{font-size: 9;
color: red;
}

</style>
<title>login page</title>
</head>
<body>

<div class="navbar">
  <a href="#home">Online Book Store</a>
  <div class="subnav">
    <button class="subnavbtn">About <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="#company">Company</a>
      <a href="#team">Team</a>
      <a href="#careers">Careers</a>
    </div>
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Services <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="#bring">Bring</a>
      <a href="#deliver">Deliver</a>
      <a href="#package">Package</a>
      <a href="#express">Express</a>
    </div>
  </div> <div class="subnav">
    <button class="subnavbtn">Partners <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="#link1">Link 1</a>
      <a href="#link2">Link 2</a>
      <a href="#link3">Link 3</a>
      <a href="#link4">Link 4</a>
    </div>
  </div>
  <a href="#contact">Contact</a>
</div>

<h1>Login Page</h1>
<form name="myform" action="post" method="post" style="margin-left: 650px"  onsubmit="return login()">
   
username<input type="text" name="username"><span id="suname"></span><br>
password<input type="password" name="password"><span id="pass"></span><br>
<input type="submit" value="login">
</form>
<form action="create" method="post"  style="margin-left: 650px">
<input type="submit" value="create account">
</form>
 <div id="degign">Designed by Srinivas</div>
</body>
</html>

 