<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="padding: 20px; background-color: aquamarine">${message}</div>
</c:if>
<h1>Lorem.</h1>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aliquam dolores itaque laboriosam non nostrum quaerat quas
    quibusdam rem sapiente voluptas? Aspernatur aut deleniti est libero obcaecati saepe sapiente sit, soluta!
</p>
</body>
</html>
