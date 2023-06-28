<%--
  Created by IntelliJ IDEA.
  User: SudheerTholeti
  Date: 5/18/2023
  Time: 2:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>DisplayPlayerList</title>
    <style>
        body{
            background-color:blanchedalmond;
        }
        h1{
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1 align="center">PlayersData</h1> <br>
<table border="2px solid" align="center">
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>ROLE</th>
        <th>NO OF MATCHES</th>
        <th>EMAIL</th>
        <th>EDIT</th>
        <th>DELETE</th>
    </tr>
    <c:forEach var="player" items="${list}">
        <tr>
            <td><a href="getPlayer/${player.id}">${player.id}</a></td>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td>${player.role}</td>
            <td>${player.noOfMatches}</td>
            <td>${player.email}</td>
            <td><a href="edit/${player.id}">Edit</a></td>
            <td><a href="delete/${player.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
    <div align="center">
        <button><a href="start">REGISTER</a></button>
        <button><a href="logout">LOGOUT</a></button>
    </div>

</body>
</html>
