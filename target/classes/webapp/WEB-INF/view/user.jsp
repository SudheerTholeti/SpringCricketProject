<%--
  Created by IntelliJ IDEA.
  User: SudheerTholeti
  Date: 6/7/2023
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <style>
        body{
            background-color: blanchedalmond;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 500px;
        }
        div{
            border: 2px solid;
            height: 200px;
            width: 30%;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>Welcome to the ${email}</h1>
    <button><a href="getPlayers/${email}">Click here to get details</a></button>
</div>
</body>
</html>
