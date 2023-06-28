<%--
  Created by IntelliJ IDEA.
  User: SudheerTholeti
  Date: 6/7/2023
  Time: 2:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
    <style>
        body{
            background-color: beige;
        }
        div{
            padding-top: 20px;
        }
        h1{
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1 align="center">ApplicationDetails</h1> <br>
    <table align="center" border="2px solid" cellpadding="15px">
        <tr>
            <td>ID</td>
            <td>${player.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${player.name}</td>
        </tr>

        <tr>
            <td>Age</td>
            <td>${player.age}</td>
        </tr>

        <tr>
            <td>Role</td>
            <td>${player.role}</td>
        </tr>
        <tr>
            <td>No Of Matches Played</td>
            <td>${player.noOfMatches}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${player.email}</td>
        </tr>
    </table>
    <div align="center">
        <button><a href="edit/${player.id}">UPDATE</a></button>
        <button><a href="delete/${player.id}">DELETE</a></button>
        <button><a href="logOut">LOGOUT</a></button>
    </div>
</body>
</html>
