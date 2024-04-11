<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, th, tr, td {
            border-collapse: collapse;
            border: 1px solid black;
        }

        table {
            width: 100%;
        }

        th, td {
            text-align: center;
            padding: 5px;
        }
    </style>
</head>
<body>
<h3>선수 목록</h3>
<table>
    <thead>
    <tr>
        <th>NO.</th>
        <th>이름</th>
        <th>소속팀</th>
        <th>국적</th>
        <th>종목</th>
        <th>포지션</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${playerList}" var="player" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${player.name}</td>
            <td>${player.team}</td>
            <td>${player.country}</td>
            <td>${player.event}</td>
            <td><c:forEach items="${player.position}" var="pos" varStatus="stat">
                ${pos}
                <c:if test="${not stat.last}">
                    ,
                </c:if>
            </c:forEach></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
