<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Homepage</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <hr>
        User: <span sec:authentication="principal.username"></span>
        <br><br>
        Role: <span sec:authentication="principal.authorities"></span>
    <hr>

    Welcome to Event Management System

<p>
    <a href="@{/Club}"></a>"
<form action="addevent.jsp" method="get">
    <input type="submit" value="Add Event">
</form>

</p>

<form action="getclubevent.jsp" method="get">
    <input type="submit" value="Clubs Event">
</form>

<form action="geteventbydate.jsp" method="get">
    <input type="submit" value="Check Event Dates">
</form>

<form action="showEvents" method="get">
    <input type="submit" value="Get all Events">
</form>

<form action="/logout" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>