<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <%--텍스트 인풋--%>
    <input type="text">
</div>
<div>
    <%--숫자 입력--%>
    <input type="number">
</div>
<div>
    <%--날짜 입력--%>
    <input type="date">
</div>
<div>
    <%--날짜 및 시간 입력--%>
    <input type="datetime-local">
</div>
<div>
    <%--파일 입력--%>
    <input type="file">
</div>
<div>
    <%--암호 입력--%>
    <input type="password">
</div>
<div>
    <%--라디오 버튼--%>
    <div>
        <input type="radio" name="alt">
        바나나
    </div>
    <div>
        <input type="radio" name="alt">
        커피
    </div>
    <div>
        <input type="radio" name="alt">
        피자
    </div>
</div>
<div>
    <div>
        <input type="checkbox" name="alt">
        Lorem.
    </div>
    <div>
        <input type="checkbox" name="alt">
        Autem.
    </div>
    <div>
        <input type="checkbox" name="alt">
        Ad.
    </div>
</div>
</body>
</html>
