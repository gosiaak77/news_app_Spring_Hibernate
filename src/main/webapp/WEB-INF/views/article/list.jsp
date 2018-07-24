<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Article list</h3>
<ul>
    <c:forEach items="${articles}" var="article">
        <li>${article.title}
            <br><a href="${pageContext.request.contextPath}/article/edit/${article.id}">edit</a>
            <a href="${pageContext.request.contextPath}git remote add origin https://github.com/gosiaak77/news_app_Spring_Hibernate.git/article/delete/${article.id}">delete</a></li>
    </c:forEach>
</ul>

<div><a href="${pageContext.request.contextPath}/article/form">Add new article</a> </div>
<h5><a href="${pageContext.request.contextPath}/">Home</a></h5>
</body>
</html>
