<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please confirm deleting category:</h2>
<p>Id#${category.id} - ${category.name}
    <br><a href="${pageContext.request.contextPath}/category/deleteConfirmed/${category.id}">Confirm</a>
    <br><a href="${pageContext.request.contextPath}/category/">Cancel</a>
</p>
</body>
</html>
