<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Expression Language</p>
<p>간단한 연산 사용 가능</p>
<p>산술 연산, 논리 연산, 비교 연산, 삼항 연산</p>

<h3>산술 연산 -> +, -, *, /, %</h3>
<p>${5 + 3}</p>
<p>${7 - 3}</p>
<p>${8 * 3}</p>
<p>${6 / 2}</p>
<p>${7 / 2}</p>
<p>${7 % 2}</p>
<p>${7 div 2}</p>
<p>${7 mod 2}</p>

<%--문자열 사용 가능--%>
<p>${"3"+"4"}</p>
<%--<p>${"three"+"four"}</p>--%>

<p>${num1}+${num2} = ${num1 + num2}</p>


<h3>비교 연산 -> >, <, >=, <=, =</h3>
<p>${5 > 3}</p>
<p>${5 gt 3}</p>

<p>${5 < 3}</p>
<p>${5 lt 3}</p>

<p>${5 >= 3}</p>
<p>${5 ge 3}</p>

<p>${5 <= 3}</p>
<p>${5 le 3}</p>

<p>${5 == 3}</p>
<p>${5 eq 3}</p>

<p>${"hello" < "spring"}</p>
<p>${"hello" < "Spring"}</p>

<p>${"11" < "2"}</p>
<p>${"11" < 2}</p>
<p>${11 < "2"}</p>
<p>${11 < 2}</p>
<%--<p>${11 < "two"}</p>--%>


<h3>논리 연산 -> &&, ||, !</h3>

<h4>&& and</h4>
<p>${true && true}</p>
<p>${true && false}</p>
<p>${false && true}</p>
<p>${false && false}</p>
<p>${true and true}</p>
<p>${true and false}</p>
<p>${false and true}</p>
<p>${false and false}</p>

<h4>|| or</h4>
<p>${true || true}</p>
<p>${true || false}</p>
<p>${false || true}</p>
<p>${false || false}</p>
<p>${true or true}</p>
<p>${true or false}</p>
<p>${false or true}</p>
<p>${false or false}</p>

<h4>! not</h4>
<p>${! true}</p>
<p>${! false}</p>
<p>${not true}</p>
<p>${not false}</p>


<h3>삼항 연산</h3>
<p>${true ? "hello" : "world"}</p>
<p>${false ? "hello" : "world"}</p>
<p>${age1 ge 18 ? "선거권 있음" : "선거권 없음"}</p>
<p>${age2 ge 18 ? "선거권 있음" : "선거권 없음"}</p>


<p>가격이 ${quantity}원인 물건 *${price}개의 총 가격은 = ${quantity * price}원이다.</p>
</body>
</html>
