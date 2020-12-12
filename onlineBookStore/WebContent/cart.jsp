<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
      <%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String username=request.getParameter("username");%>
<sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost/book_store"
         user = "root" password = "14597"/>
     <sql:query dataSource = "${snapshot}" var = "result">
         SELECT * FROM  books b
join cart c
on b.id = c.book_id
where username="<%=username %>"
      </sql:query>
    <table  border="1" >
         <tr>
            <th>id</th>
            <th>book name</th>
            <th>author</th>
            <th>price</th>
            <th></th>
         <th></th>
         </tr>
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td > <c:out  value = "${row.id}"/> </td>
            
               <td ><img  src="images/${row.name}.jpg" width="150" height="160"/> <c:out value = "${row.name}"/></td>
               <td > <c:out value = "${row.author}"/></td>
               <td > <c:out value = "${row.price}"/></td>
                <td ><form action="buy" method="post">
           <input type="hidden" name="username" value="<%=username%>" />
             <input type="hidden" name="id" value="${row.id}" />
             <input type="submit" value="buy">
               </form></td>
       <td ><form action="remove" method="post">
           <input type="hidden" name="username" value="<%=username%>" />
             <input type="hidden" name="id" value="${row.id}" />
             <input type="submit" value="Remove">
               </form></td>
            </tr>
         </c:forEach>
      </table>
</body>
</html>