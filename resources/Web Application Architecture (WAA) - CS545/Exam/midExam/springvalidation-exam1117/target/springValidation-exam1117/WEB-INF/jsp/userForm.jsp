<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2019
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new User</title>
    <style>.error{color: red}</style>
    </head>
<body>
<h1> Add new User</h1>

<form:form modelAttribute="user">
    <form:errors path="*" cssClass="error"/>
    <p> User Name   <form:input path="name"/>
        <form:errors path="name" cssStyle="color: red;"/></p>
    <p> Email  <form:input path="email"/>
        <form:errors path="email" cssClass="error"/> </p>
    <p> Birth Day  <form:input path="birthDay"/>
        <form:errors path="birthDay" cssClass="error"/></p>
    <p> Age  <form:input path="age"/>
        <form:errors path="age" cssClass="error"/></p>

    <p>Role:
    <form:select path="role">
    <form:option value=""> Select Role</form:option>
        <form:options items="${roles}"/>
    </form:select>
        <form:errors path="role" cssClass="error" />
    </p>
    <h2>Address Info </h2>

    <p> Street:   <form:input path="addr.street"/>
        <form:errors path="addr.street" cssClass="error"/></p>
    <p> State:   <form:input path="addr.state"/>
        <form:errors path="addr.state" cssClass="error"/></p>
    <p> Zipcode:   <form:input path="addr.zipcode"/>
        <form:errors path="addr.zipcode" cssClass="error"/></p>
    <input type="submit" value="Add">
</form:form>
</body>
</html>