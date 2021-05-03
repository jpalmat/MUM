<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2019
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css"/>">
</head>
<body>
<fieldset> <legend>Add new User</legend>
    <form:form modelAttribute="user" action="add" method="post">
        <form:errors path="*" cssStyle="color: red;"/>

        <div>
            <label>User Name</label>
            <form:input path="name"/>
            <form:errors path="name" cssStyle="color: red;"/>
        </div>

        <div>
            <label>Email</label>
            <form:input path="email"/>
            <form:errors path="email" cssStyle="color: red;"/>
        </div>

        <div>
        <label>Age</label>
        <form:input path="age"/>
        <form:errors path="age" cssStyle="color: red;"/>
    </div>

        <div >
            <label>Birth Date</label>
            <form:input path="birthDay"/>
            <form:errors path="birthDay" cssStyle="color: red;"/>
        </div>

        <div >
            <label>Role </label>

            <form:select path="role">
                <form:option value="" label="Select Gender"/>
                <form:option value="Admin"/>
                <form:option value="DBA"/>
                <form:errors path="role" cssStyle="color: red;"/>
            </form:select>
            <form:errors path="role" cssStyle="color: red;"/>
        </div>
        <h2> Address </h2>
        <div><label>Street</label>
            <form:input path="addr.street"/>
            <form:errors path="addr.street" cssStyle="color: red;"/>
        </div>

        <div><label>State</label>
            <form:input path="addr.state"/>
            <form:errors path="addr.state" cssStyle="color: red;"/>
        </div>

        <div><label>Zipcode</label>
            <form:input path="addr.zipcode"/>
            <form:errors path="addr.zipcode" cssStyle="color: red;"/>
        </div>
        <input type="submit"  id="btnAdd" value="Add">
    </form:form></fieldset>
</body>
</html>