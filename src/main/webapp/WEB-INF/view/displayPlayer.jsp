<%@ page import="com.skytech.cricket.model.Player" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: SudheerTholeti
  Date: 5/17/2023
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DisplaySinglePlayer</title>
    <style>
        body{
            background-color: honeydew;
        }
    </style>
</head>
<body>
<%--<% Player player= (Player) request.getAttribute("getPlayer");%>--%>
    <table border="2px solid" align="center">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>AGE</th>
            <th>ROLE</th>
            <th>NO OF MATCHES</th>
            <th>EMAIL</th>
        </tr>
        <tr>
            <td>${player.id}</td>
            <td>${player.name}</td>
            <td>${player.age}</td>
            <td>${player.role}</td>
            <td>${player.noOfMatches}</td>
            <td>${player.email}</td>
        </tr>
    </table>
        <div align="center">
            <button><a href="getList">DISPLAY ALL</a></button>
        </div>
</body>
</html>
