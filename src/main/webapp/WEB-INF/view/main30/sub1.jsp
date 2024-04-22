<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty message}">
    <div style="padding:20px; background-color: palegreen">
            ${message}
    </div>
</c:if>
<h3>고객 정보 수정</h3>
<form action="">
    번호
    <input type="text" name="id">
    <button>조회</button>
</form>
<hr>
<form action="/main30/sub1/update" method="post">
    <div>
        번호
        <input type="text" name="id" value="${customer.id}">
    </div>
    <div>
        이름
        <input type="text" name="name" value="${customer.name}">
    </div>
    <div>
        계약명
        <input type="text" name="contactName" value="${customer.contactName}">
    </div>
    <div>
        주소
        <input type="text" name="address" value="${customer.address}">
    </div>
    <div>
        도시
        <input type="text" name="city" value="${customer.city}">
    </div>
    <div>
        우편번호
        <input type="text" name="postalCode" value="${customer.postalCode}">
    </div>
    <div>
        국가
        <input type="text" name="country" value="${customer.country}">
    </div>
    <form action="/main30/sub2/update" method="post" onsubmit="return confirm('정말 수정하시겠습니까?')">
        <div style="display: none">
            <input type="text" name="id" value="${customer.id}">
        </div>
        <div>
            <button style="background-color: rosybrown">
                수정
            </button>
        </div>
    </form>
</form>
</body>
</html>
