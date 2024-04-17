<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>
    고객 목록
</h3>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>City</th>
        <th>Country</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.customerName}</td>
            <td>${customer.city}</td>
            <td>${customer.country}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
