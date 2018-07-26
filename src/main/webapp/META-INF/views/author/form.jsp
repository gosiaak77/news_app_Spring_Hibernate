<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <form:input path="firstName" placeholder="first name"/>
    <form:input path="lastName" placeholder="last name"/>
    <input type="submit">
</form:form>
</body>
</html>
