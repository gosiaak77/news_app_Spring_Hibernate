<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="article">
    <br><form:input path="title" placeholder="title"/>
    <br><form:textarea path="content" placeholder="content" cols="100" rows="5"/>
    <br><form:select path="author.id" items="${authorList}"
                 itemValue="id" itemLabel="lastName"/>
    <br><form:select path="categories" items="${categoryList}"
                 itemValue="id" itemLabel="name"/>
    <br><input type="submit">
</form:form>



</body>
</html>
