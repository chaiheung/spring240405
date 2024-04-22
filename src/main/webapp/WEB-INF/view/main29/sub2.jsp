<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="background-color: orangered; padding: 20px;">
            ${message}
    </div>
</c:if>
<h3>직원 조회</h3>
<form>
    직원 번호
    <input type="number" name="id">
    <button>조회</button>
</form>
<hr>
<c:if test="${empty employee}">
    조회된 직원이 없습니다.
</c:if>
<c:if test="${not empty employee}">
    <div>
        번호
        <input type="number" value="${employee.id}" readonly>
    </div>
    <div>
        성
        <input type="text" value="${employee.lastName}" readonly>
    </div>
    <div>
        이름
        <input type="text" value="${employee.firstName}" readonly>
    </div>
    <div>
        생년월일
        <input type="date" value="${employee.birthDate}" readonly>
    </div>
    <div>
        사진
        <input type="image" value="${employee.photo}" readonly>
    </div>
    <div>
        비고
        <textarea name="" id="" cols="30" rows="10" readonly>${employee.notes}</textarea>
    </div>
    <form action="/main29/sub2/delete" method="post" onsubmit="return confirm('정말 삭제하시겠습니까?')">
        <div style="display: none">
            <input type="text" name="id" value="${employee.id}">
        </div>
        <div>
            <button style="background-color: rosybrown">
                삭제
            </button>
        </div>
    </form>
</c:if>
</body>
</html>
