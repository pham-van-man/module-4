<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: final
  Date: 17/09/2024
  Time: 2:35 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result">
    <label>USD:
        <input name="usd" value="0" type="number">
    </label>
    <label>
        Result:
        <c:if test="${usd!=null}">${usd}</c:if>
    </label>
</form>
</body>
</html>
