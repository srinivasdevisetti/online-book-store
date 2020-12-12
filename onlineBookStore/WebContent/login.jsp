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

 