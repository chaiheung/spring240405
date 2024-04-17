<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    나라 목록
</h3>
<table>
    <c:forEach items="${countryList}" var="country" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${country}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
