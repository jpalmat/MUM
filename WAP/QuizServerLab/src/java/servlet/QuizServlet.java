/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import data.SecuenceData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jimmypalma
 */
public class QuizServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        out.print("<html><head></head><body>");
        out.print("<h1>The number quiz</h1><br>");
        out.print("<p>Your current score is 0</p><br>");
        out.print("<p>Guess the next number in the sequence</p><br>");
        out.print("<p>" + SecuenceData.questions[0] + "</p>");
        out.print("<form method=\"post\">");
        out.print("<div>\n"
                + "            <p>Your answer</p>\n"
                + "            <input type=\"text\" name=\"answer\"/>\n"
                + "        </div>");
        out.print("<br><input type=\"submit\" value=\"Submit\"/></form>");
        out.print("</body></html>");

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
        String c = request.getParameter("answer");
        Integer index = Integer.valueOf(request.getSession().getAttribute("question").toString());
        Integer grade = Integer.valueOf(request.getSession().getAttribute("grade").toString());
        if (Integer.valueOf(c) == SecuenceData.answers[index]) {
            request.getSession().setAttribute("grade", ++grade);
        }
        request.getSession().setAttribute("question", ++index);
        PrintWriter out = response.getWriter();
        if (index < 5) {
            out.print("<html><head></head><body>");
            out.print("<h1>The number quiz</h1><br>");
            out.print("<p>Your current score is " + grade + "</p><br>");
            out.print("<p>Guess the next number in the sequence</p><br>");
            out.print("<p>" + SecuenceData.questions[index] + "</p>");
            out.print("<form method=\"post\">");
            out.print("<div>\n"
                    + "            <p>Your answer</p>\n"
                    + "            <input type=\"text\" name=\"answer\"/>\n"
                    + "        </div>");
            out.print("<br><input type=\"submit\" value=\"Submit\"/></form>");
            out.print("</body></html>");
        } else {
            out.print("<html><head></head><body>");
            out.print("<h1>The number quiz</h1><br>");
            out.print("<p>Your current score is " + grade + "</p><br>");
            out.print("<p>You have completed the Number Quiz, with a score of "+ grade+" out of 5</p><br>");
            out.print("</body></html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
