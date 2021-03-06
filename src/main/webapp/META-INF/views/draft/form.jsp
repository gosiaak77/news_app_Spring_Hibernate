<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Article</title>
    <style>
        input, textarea, select{
            display:block;
        }
    </style>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <input type="hidden" name="draft" value="true">
    <form:input path="title" placeholder="title"/>
    <form:errors path="title"/>
    <form:textarea path="content" placeholder="content" cols="100" rows="5"/>
    <form:errors path="content"/>
    <input type="submit">
</form:form>



</body>
</html>
