<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>category
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Category: ${category.name}
<c:forEach items="${articles}" var="article">
    <h4><a href="${pageContext.request.contextPath}/article/${article.id}">${article.title}</a></h4>
</c:forEach>
</body>
</html>
