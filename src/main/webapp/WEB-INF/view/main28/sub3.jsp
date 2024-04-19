<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        @keyframes fadeOut {
            0% {
                opacity: 1;
            }
            100% {
                opacity: 0
            }
        }

        .message {
            text-align: center;
            font-size: larger;
            border-radius: 20px;
            padding: 20px;
            background-color: springgreen;
            animation: fadeOut 5s forwards;
        }
    </style>
</head>
<body>
<div>
    <c:if test="${not empty message}">
        <div class="message">
                ${message}
        </div>
    </c:if>
</div>
<h3>직원 정보를 입력하세요.</h3>
<form action="" method="post">
    <div>
        성
        <input type="text" name="lastName">
    </div>
    <div>
        이름
        <input type="text" name="firstName">
    </div>
    <div>
        생년월일
        <input type="date" name="birthDate">
    </div>
    <div>
        사진
        <input type="file" name="photo">
    </div>
    <div>
        <textarea rows="5" cols="30" name="notes"></textarea>
    </div>
    <div>
        <input type="submit" value="등록">
    </div>
</form>
</body>
</html>
