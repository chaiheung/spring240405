<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${names.son}</h1>
<h1>${names.lee}</h1>
<h1>${names.kim}</h1>
<hr>
<h1>${names["son"]}</h1>
<h1>${names["lee"]}</h1>
<h1>${names["kim"]}</h1>
<hr>
<h1>${others["hm"]}</h1>
<h1>${others["ki"]}</h1>
</body>
</html>
