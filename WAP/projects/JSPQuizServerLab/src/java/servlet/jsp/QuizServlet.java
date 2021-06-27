/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.jsp;

import data.SecuenceData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jimmypalma
 */
public class QuizServlet extends HttpServlet {

    String[] questions
            = {
                "3, 1, 4, 1, 5", //pi
                "1, 1, 2, 3, 5",//fibonacci
                "1, 4, 9, 16, 25", //squares
                "2, 3, 5, 7, 11", //primes
                "1, 2, 4, 8, 16" //power of 2
            };

    String[] hint
            = {
                "PI  Sequence",
                "fib Sequence",
                "Square Sequence",
                "Primes Sequence",
                "Power of 2 Sequence"
            };

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getSession().setAttribute("question", 0);
        request.getSession().setAttribute("grade", 0);
        request.getSession().setAttribute("questions", questions);
        request.getSession().setAttribute("hint", hint);
        request.getSession().setAttribute("index", 0);
        request.getSession().setAttribute("validation", 0);
        RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
        dispatch.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String test = request.getSession().getAttribute("validation").toString();
        Integer validation = Integer.valueOf(test);

        String c = request.getParameter("answer");
        String agecheck = request.getParameter("age");
        System.out.print("la edad al " + agecheck);

        String age = checkInput(agecheck) ? agecheck : "error, age must be a number";

        request.getSession().setAttribute("age", age);

        Integer index = Integer.valueOf(request.getSession().getAttribute("index").toString());
        Integer grade = Integer.valueOf(request.getSession().getAttribute("grade").toString());
        if (validation < 3 && Integer.valueOf(c) == SecuenceData.answers[index]) {
            ++index;
            switch (validation) {
                case 0:
                    grade += 10;
                    break; // optional

                case 1:
                    grade += 5;
                    break; // optional

                case 2:
                    grade += 2;
                    break; // optional

                // You can have any number of case statements.
                default: // Optional
                // Statements
            }
            validation = 0;
        } else if (validation == 3) {
            ++index;
            validation = 0;
        } else {
            ++validation;
        }
        System.out.println("antes validacion "+validation);
        request.getSession().setAttribute("grade", grade);
        request.getSession().setAttribute("index", index);
        request.getSession().setAttribute("validation", validation);
        PrintWriter out = response.getWriter();
        if (index < 5) {
            RequestDispatcher dispatch = request.getRequestDispatcher("Quiz.jsp");
            dispatch.forward(request, response);
        } else {
            out.print("<html><head></head><body>");
            out.print("<h1>The number quiz</h1><br>");
            out.print("<p>Your current score is " + grade + "</p><br>");
            out.print("<p>You have completed the Number Quiz, with a score of " + grade + " out of 5</p><br>");
            out.print("</body></html>");
        }
    }

    public boolean checkInput(String age) {
        int intvalue2;
        try {
            intvalue2 = Integer.parseInt(age);

            if (intvalue2 > 4 && intvalue2 < 100) {
                return true;
            }

        } catch (RuntimeException ex) {
            return false;
        }
        return false;
    }

}
