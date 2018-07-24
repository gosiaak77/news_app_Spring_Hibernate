<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Author list</h3>
<ul>
<c:forEach items="${authors}" var="author">
    <li>${author.firstName} ${author.lastName}
        <br><a href="${pageContext.request.contextPath}/author/edit/${author.id}">edit</a>
        <a href="${pageContext.request.contextPath}/author/delete/${author.id}">delete</a></li>
</c:forEach>
</ul>

<div><a href="${pageContext.request.contextPath}/author/form">Add new author</a> </div>
<h5><a href="${pageContext.request.contextPath}/">Home</a></h5>f
</body>
</html>
