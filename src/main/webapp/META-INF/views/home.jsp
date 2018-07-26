<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Last 5 articles</h2>
<c:forEach items="${articles}" var="article">
    <h4>${article.title}</h4>
    <p>${article.content.substring(0,200)}...</p>
    <p>author: ${article.author.firstName} ${article.author.lastName}</p>
    <p>created: ${article.created}</p>
</c:forEach>
<br>
<div>
    <h4>Categories</h4>
<c:forEach items="${categoryList}" var="category">
    <p><a href="${pageContext.request.contextPath}/category/${category.id}">${category.name}</a></p>
</c:forEach>
</div>
</body>
</html>
