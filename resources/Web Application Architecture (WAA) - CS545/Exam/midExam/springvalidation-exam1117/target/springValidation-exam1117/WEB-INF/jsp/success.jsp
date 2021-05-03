<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/8/2019
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>

<h1>User saved successfully </h1>
<p> User name: ${user.name}</p>
<p> Email: ${user.email}</p>
<p>Birth Day: ${user.birthDay}</p>
<p>Age: ${user.age}</p>


<h2> Address</h2>
<p> Street: ${user.addr.street}</p>
<p> State: ${user.addr.state}</p>
<p> Zip Code : ${user.addr.zipcode}</p>
</body>
</html>
