<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${myAttr1.jh}</p>

<p>${myAttr1[lee]}</p>
<%--son--%>
<p>${myAttr2}</p>
<%--london--%>
<p>${myAttr1["son"]}</p>
<p>${myAttr1[myAttr2]}</p>
<%--munich--%>
<p>${myAttr1["kim"]}</p>
<p>${myAttr1[myAttr3]}</p>

<%--san francisco--%>
<p>${myAttr1.jh}</p>
<p>${myAttr1["jh"]}</p>

<%--${myAttr1["lee"]}--%>
<p>${myAttr1[jh]}</p>
</body>
</html>
