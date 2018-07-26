<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Category list</h3>
<ul>
<c:forEach items="${categories}" var="category">
    <li>${category.name} - ${category.description}
        <br><a href="${pageContext.request.contextPath}/category/edit/${category.id}">edit</a>
        <a href="${pageContext.request.contextPath}/category/delete/${category.id}">delete</a></li>
</c:forEach>
</ul>

<div><a href="${pageContext.request.contextPath}/category/form">Add new category</a> </div>

<h5><a href="${pageContext.request.contextPath}/">Home</a></h5>
</body>
</html>
