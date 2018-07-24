<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Please confirm deleting author:</h2>
<p>Id#${author.id} - ${author.firstName} ${author.lastName}
    <br><a href="${pageContext.request.contextPath}/author/deleteConfirmed/${author.id}">Confirm</a>
    <br><a href="${pageContext.request.contextPath}/author/">Cancel</a>
</p>
</body>
</html>
