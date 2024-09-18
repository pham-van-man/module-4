<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: final
  Date: 18/09/2024
  Time: 9:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/result">
    <input name="a" type="number">
    <input name="b" type="number">
    <button type="submit" name="operation" value="+">+</button>
    <button type="submit" name="operation" value="-">-</button>
    <button type="submit" name="operation" value="*">*</button>
    <button type="submit" name="operation" value="/">/</button>
</form>
<c:if test="${result!=null}">
    Result: ${result}
</c:if>
</body>
</html>
