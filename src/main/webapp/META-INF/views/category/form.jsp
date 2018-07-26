<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <form:input path="name" placeholder="name"/>
    <form:errors path="name"/>
    <form:input path="description" placeholder="description"/>
    <form:errors path="description"/>
    <input type="submit">
</form:form>
</body>
</html>
