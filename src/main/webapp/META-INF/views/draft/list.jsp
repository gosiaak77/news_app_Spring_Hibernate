<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Drafts list</h3>
<ul>
    <c:forEach items="${articles}" var="article">
        <li>${article.title} : <br>${article.content}
            <br><a href="${pageContext.request.contextPath}/draft/edit/${article.id}">edit</a>
            <a href="${pageContext.request.contextPath}/article/delete/${article.id}">delete</a></li>
    </c:forEach>
</ul>

<div><a href="${pageContext.request.contextPath}/draft/form">Add new draft</a> </div>
</body>
</html>
