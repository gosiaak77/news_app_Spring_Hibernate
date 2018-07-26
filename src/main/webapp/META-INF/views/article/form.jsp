<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new Article</title>
    <style>
        input{
            display:block;
        }
    </style>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <form:input path="title" placeholder="title"/>
    <form:errors path="title"/>
    <form:textarea path="content" placeholder="content" cols="100" rows="5"/>
    <form:errors path="content"/>
    <form:select path="author.id" items="${authorList}"
                 itemValue="id" itemLabel="lastName"/>
    <form:errors path="author"/>
    <form:select path="categories" items="${categoryList}"
                 itemValue="id" itemLabel="name"/>
    <form:errors path="categories"/>
    <input type="submit">
</form:form>



</body>
</html>
