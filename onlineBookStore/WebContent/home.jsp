<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
    <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"
%>
<!DOCTYPE html>
<html>
<head><style type="text/css">
table{color: white;

}

</style>

 <link rel="stylesheet" href="style.css">
 <link rel="stylesheet" href="head.css">
<meta charset="ISO-8859-1">
<title>users</title>
</head>
<body>
<div class="navbar">
  <a href="#home">online shopping cart</a>
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
  </div> 
  <div class="subnav">
    <button class="subnavbtn">Partners <i class="fa fa-caret-down"></i></button>
    <div class="subnav-content">
      <a href="#link1">Link 1</a>
      <a href="#link2">Link 2</a>
      <a href="#link3">Link 3</a>
      <a href="#link4">Link 4</a>
    </div>
  </div>
  <a href="#contact"><form id="cart" action="cart.jsp" method="post"  style="float: left;">
          <input type="hidden" name="username" value="${username}" />
      <input type="image" src="images/cart.jpg" width="40" height="50" alt="cart">
      </form></a>
</div>



      
<h1>List of books</h1>
${username}
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/book_store"
         user = "root" password = "14597"/>
         <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * from books;
      </sql:query>
    
      <table border="1" >
         <tr >
            <th>id</th>
            <th>name</th>
            <th>author</th>
            <th>price</th>
            <th>stock</th>
            <th></th>
            <th></th>
         </tr>
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td > <c:out  value = "${row.id}"/> </td>
            
               <td >
<img  src="images/${row.name}.jpg" width="150" height="160"/> <c:out value = "${row.name}"/></td>
               <td > <c:out value = "${row.author}"/></td>
               <td > <c:out value = "${row.price}"/></td>
                <td > <c:out value = "${row.stock}"/></td>
               <td >
               <form action="cart" method="post">
           <input type="hidden" name="username" value="${username}" />
             <input type="hidden" name="id" value="${row.id}" />
             <input type="submit" value="add to cart">
               </form> </td>
               <td ><form action="buy" method="post">
           <input type="hidden" name="username" value="${username}" />
             <input type="hidden" name="id" value="${row.id}" />
             <input type="submit" value="buy">
               </form> </td>
            </tr>
         </c:forEach>
      </table>
      
     
</body>
</html>