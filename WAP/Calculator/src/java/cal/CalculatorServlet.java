/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cal;

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
public class CalculatorServlet extends HttpServlet {

    

   

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
        String firstPlus = request.getParameter("firstPlus");
        String secondPlus = request.getParameter("secondPlus");
        String firstTimes = request.getParameter("firstTimes");
        String secondTimes = request.getParameter("secondTimes");
        
        Integer totalPlus = Integer.valueOf(firstPlus) + Integer.valueOf(secondPlus);
        Integer totalTimes = Integer.valueOf(firstTimes) * Integer.valueOf(secondTimes);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<form action=\"calculate\" method=\"POST\">\n" +
"            <div>\n" +
"                <input type=\"text\" name=\"firstPlus\" value=\"" +firstPlus+ "\"/>\n" +
"                +\n" +
"                <input type=\"text\" name=\"secondPlus\" value=\"" +secondPlus+ "\"/>\n" +
"                =\n" +
"                <input type=\"text\" name=\"totalPlus\" value=\"" +totalPlus+ "\" disabled/>\n" +
"            </div>\n" +
"            <div>\n" +
"                <input type=\"text\" name=\"firstTimes\" value=\"" +firstTimes+ "\"/>\n" +
"                *\n" +
"                <input type=\"text\" name=\"secondTimes\" value=\"" +secondTimes+ "\"/>\n" +
"                =\n" +
"                <input type=\"text\" name=\"totalTimes\" value=\"" +totalTimes+ "\" disabled/>\n" +
"            </div>\n" +
"            <input type=\"submit\" value=\"submit\"/>\n" +
"        </form>");
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
