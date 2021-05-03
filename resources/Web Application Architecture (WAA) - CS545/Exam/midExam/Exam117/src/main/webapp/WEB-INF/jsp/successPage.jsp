<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2019
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success Page</title>
</head>
<body>

<section>
    <div>
        Name: ${user.name}<br>
        Email:${user.email}<br>
        Age:${user.age}<br>
        Birthday:${user.birthDay}<br>
        Role:${user.role}<br>

        Address:<br>
        Street:${user.addr.street}<br>
        State: ${user.addr.state}<br>
        Zipcode: ${user.addr.zipcode}
    </div>
    <a href="${pageContext.request.contextPath}/add"> Back to Registration form</a>
</section>

</body>
</html>
