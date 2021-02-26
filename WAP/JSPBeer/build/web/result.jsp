<%-- 
    Document   : beer
    Created on : 03/03/2020, 14:28:59
    Author     : jimmypalma
--%>

<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Beer Recommendations JSP</h1>
        <!--
        <p>
            <% 
                /*List styles = (List)request.getAttribute("styles");
                Iterator it = styles.iterator();
                while(it.hasNext()) {
                    out.print("<br>try: " +it.next());
                }*/
            %>
        </p>
        -->
        <c:forEach items="${styles}" var="recom">
            <c:out value="${recom}" default="test"/>
        </c:forEach>
    </body>
</html>
