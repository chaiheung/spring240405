<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="atter1" value="page value1" scope="page"/>
<c:set var="atter1" value="page value1" scope="request"/>
<c:import url="navbar5.jsp"/>

<div>
    <div>
        ${attr1}, ${pageScope.attr1}, ${pageScope["attr1"]}
    </div>
    <div>
        ${requestScope.attr1}, ${requestScope["attr1"]}
    </div>
</div>
</body>
</html>
