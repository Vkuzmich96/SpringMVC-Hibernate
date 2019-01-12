<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 16.12.2018
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>registration</title>
</head>
<body>
<spring:form action="/" method="post" modelAttribute="profileKey">
    <p>
        login
    </p>
        <spring:input path="login"/>
    <p>
        name
    </p>
        <spring:input path="name"/>
    <p>
        password
    </p>
        <spring:input path="password"/>
    <p>
        email
    </p>
        <spring:input path="email"/>
    <p>
        <input type="submit" value="зарегистрироваться"/>
    </p>
    <p>
        <spring:errors path="*"/>
    </p>
</spring:form>

</body>
</html>
