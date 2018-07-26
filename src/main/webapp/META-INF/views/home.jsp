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
    <c:set var="shortDesc" value="${fn:substring(article.content, 0, 200)}" />
    <p>${shortDesc}...</p>
    <p>${article.author.firstName} ${article.author.lastName}</p>
    <p>created: ${article.created}</p>
</c:forEach>

<br>

<p><a href="${pageContext.request.contextPath}/category/">Categories manager</a> ||
    <a href="${pageContext.request.contextPath}/author/">Authors manager</a> ||
    <a href="${pageContext.request.contextPath}/article/">Articles manager</a></p>
</body>
</html>
