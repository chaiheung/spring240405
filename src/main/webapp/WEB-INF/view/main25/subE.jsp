<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }

        table {
            width: 100%;
        }
    </style>
</head>
<body>
<h3>직원 목록</h3>
<form>
    이름
    <input value="${prevSearch}" type="text" placeholder="조회할 직원의 이름을 입력하세요." name="search">
    <button>조회</button>
</form>
<hr>

<c:if test="${empty employeeList}" var="emptyEmployeeList">
    <p>존재하지 않는 직원입니다.</p>
</c:if>
<c:if test="${not emptyEmployeeList}">
    <table>
        <thead>
        <tr>
            <th>id</th>
            <th>first name</th>
            <th>last name</th>
            <th>birth date</th>
            <th>photo</th>
            <th>notes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employeeList}" var="employee">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.birthDate}</td>
                <td>${employee.photo}</td>
                <td>${employee.notes}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
</body>
</html>