<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 02.12.2018
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>page 1</title>
</head>
<body>


<div>
    ${error}

</div>

<spring:form action="/controller" method="post" modelAttribute="gameKey">
<div>

    <spring:input path="a1"/>
    <spring:input path="a2"/>
    <spring:input path="a3"/>
</div>
<div>
    <spring:input path="b1"/>
    <spring:input path="b2"/>
    <spring:input path="b3"/>
</div>
<div>
    <spring:input path="c1"/>
    <spring:input path="c2"/>
    <spring:input path="c3"/>
</div>
<div>
    <spring:errors path="*"/>
</div>
    <input type="submit" value="передать ход "/>
    </spring:form>


</body>
</html>
