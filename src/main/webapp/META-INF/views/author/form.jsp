<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new author</title>
    <style>
        input {
            display: block;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:input path="firstName" placeholder="first name"/>
    <form:errors path="firstName"/>
    <form:input path="lastName" placeholder="last name"/>
    <form:errors path="lastName"/>
    <input type="submit">
</form:form>
</body>
</html>
