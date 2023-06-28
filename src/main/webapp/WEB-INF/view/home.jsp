<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: SudheerTholeti
  Date: 5/18/2023
  Time: 3:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterPlayer</title>
    <style>
        body{
            background-color: cornsilk;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 500px;
        }
        form{
            width: 50%;
        }
        .error{
            color: red;
        }
    </style>
</head>
<body>
<%--@elvariable id="player" type="com.skytech.cricket"--%>
<form:form modelAttribute="player" action="entry" method="post" align="center">
    <h1 align="center">Welcome to the new cricket Board</h1>

    <fieldset>
       <legend><h1>Register</h1></legend>
        <table align="center" >
            <tr>
                <td>
                    <form:label path="name">NAME:</form:label>
                </td>
                <td>
                    <form:input  path="name"/>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="age">AGE:</form:label>
                </td>
                <td>
                    <form:input form:type="number" path="age"/>
                    <form:errors path="age" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="role">ROLE:</form:label>
                </td>
                <td>
                    <form:select path="role">
                    <form:option value="" label="Select any one"/>
                    <form:option value="Batsman" label="Batsman"/>
                    <form:option value="Bowler" label="Bowler"/>
                    <form:option value="AllRounder" label="AllRounder"/>
                </form:select>
                    <form:errors path="role" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="noOfMatches">NO OF MATCHES:</form:label>
                </td>
                <td>
                    <form:input path="noOfMatches"/>
                    <form:errors path="noOfMatches" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email"> EMAIL:</form:label>
                </td>
                <td>
                   <form:input path="email"/>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password"> PASSWORD:</form:label>
                </td>
                <td>
                   <form:input path="password"/>
                    <form:errors path="password"  cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td></td>
                <td >
                    <input type="submit" value="REGISTER" style="background-color: #18ff33">
                    <button><a href="login">Back</a></button>
                </td>
            </tr>
        </table>
   </fieldset>
</form:form>
</body>
</html>
