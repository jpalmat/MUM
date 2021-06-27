<%-- 
    Document   : Choose
    Created on : 02/03/2020, 16:38:23
    Author     : jimmypalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Choose</title>
    </head>
    <body>
        <form method="post" action="ChooseServlet" var="radioState">
            <p>Is JSP cool?</p>
            <!--
            <strong>Multiples . EL Example:</strong> ${requestScope.employee}
            -->
           
            <strong>Test:</strong> ${sessionScope.employee}
            <input type="radio" value="1" name="radioJSPCool" ><span>Yes</span><br/> 
            <input type="radio" value="0" name="radioJSPCool" ><span>No</span><br/> 
            <input type="submit" name="btnSubmit" value="Submit"/>
            
<!--            <p>Is JSF way cool?</p> ${radioState.yesCheck ? 'checked' : ''} ${radioState.noCheck ? 'checked' : ''}
            <input type="radio" value="1" name="JSFwayCool"><span>Yes</span><br/> 
            <input type="radio" value="0" name="JSFwayCool"><span>No</span><br/> 
            <input type="submit" name="btnSubmit" value="Submit"/>
            <p>Is the moon made of cheese?</p>
            <input type="radio" value="1" name="moonCheese"><span>Yes</span><br/> 
            <input type="radio" value="0" name="moonCheese"><span>No</span><br/> 
            <input type="submit" name="btnSubmit" value="Submit"/>-->
        </form>
    </body>
</html>
