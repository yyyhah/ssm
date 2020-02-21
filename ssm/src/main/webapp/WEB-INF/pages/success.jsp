<%--
  Created by IntelliJ IDEA.
  User: 53175
  Date: 2020/2/20
  Time: 20:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>跳转成功</h1>
    <c:forEach items="${list}" var="employee">
        ${employee.toString()}
    </c:forEach>
</body>
</html>
