<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginPage</title>
    <style>
        form{
            width: 30%;
        }
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 500px;
        }
    </style>
</head>
<body bgcolor="#fff8dc">

<form  align="center" action="${pageContext.request.contextPath}/login" method="post">
<fieldset>
    <legend><h1>LOGIN</h1></legend>
    <h4 align="center" style="color: red">${msg} </h4>
        EMAIL:<input type="text" name="username" > <br><br>
        PASSWORD:<input type="password" name="password"> <br><br>
        <input type="submit" value="SUBMIT">
        <button><a href="start">SIGN-UP</a></button>
</fieldset>
</form>

</body>
</html>

