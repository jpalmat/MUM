<%-- 
    Document   : Quiz
    Created on : 03/03/2020, 10:35:57
    Author     : jimmypalma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html><head></head><body>
        <h1>The number quiz</h1><br>

        <p>Your current score is ${grade}</p><br>
        <p>Guess the next number in the sequence</p><br>
        <p>${questions[index]}</p>
        <form method="post">
            <div><p>Your answer</p>
                <input type="text" name="answer"/>
                <abbr title="${hint[index]}">Hint</abbr> 
            </div>
            <br>
            <p>
                Age :<input type="text" name="age" value="${age}">
            </p>
            <input type="submit" value="Submit"/>
        </form>
    </body></html>
