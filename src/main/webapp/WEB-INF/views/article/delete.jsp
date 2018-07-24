<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please confirm deleting article:</h2>
<p>Id#${article.title} - (author: ${article.author})
    <br><a href="${pageContext.request.contextPath}/article/deleteConfirmed/${article.id}">Confirm</a>
    <br><a href="${pageContext.request.contextPath}/article/">Cancel</a>
</p>
</body>
</html>
