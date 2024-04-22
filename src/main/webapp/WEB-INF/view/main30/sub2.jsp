<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="padding: 20px; background-color: orangered">
            ${message}
    </div>
</c:if>
<h3>직원 정보 조회/수정</h3>
<form action="">
    번호
    <input type="text" name="id">
    <button>조회</button>
</form>
<hr>
<h3>${employee.id}번 직원</h3>
<form action="/main30/sub2/update" method="post">
    <input type="hidden" name="id" value="${employee.id}">
    <div>
        번호
        <input type="text" name="id" value="${employee.id}">
    </div>
    <div>
        성
        <input type="text" name="lastName" value="${employee.lastName}">
    </div>
    <div>
        이름
        <input type="text" name="firstName" value="${employee.firstName}">
    </div>
    <div>
        생년월일
        <input type="date" name="birthDate" value="${employee.birthDate}">
    </div>
    <div>
        사진
        <input type="text" name="photo" value="${employee.photo}">
    </div>
    <div>
        비고
        <textarea name="notes" id="" cols="30" rows="10">${employee.notes}</textarea>
    </div>
    <div>
        <input type="submit" value="수정">
    </div>
</form>
</body>
</html>
