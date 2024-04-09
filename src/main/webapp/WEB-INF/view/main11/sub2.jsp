<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>empty 연산자</h3>
<h3>길이가 0인 컬렉션, 문자열, 존재하지 않는 attribute, null</h3>
<h3>${empty attr1}</h3>
<h3>${empty attr2}</h3>
<h3>${empty attr3}</h3>
<h3>${empty attr4}</h3>
<h3>${empty attr5}</h3>
<h3>${empty attr6}</h3>

<%--! not과 조합하여 반대도 가능--%>
<h3>${not empty attr1}</h3>
<h3>${! empty attr2}</h3>
</body>
</html>
