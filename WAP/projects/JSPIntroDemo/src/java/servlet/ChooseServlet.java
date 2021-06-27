/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author jimmypalma
 */
public class ChooseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Employee emp = new Employee();
		emp.setId(1);
		emp.setName("Pankaj Kumar");
                emp.setTest(true);
                
                HttpSession session = request.getSession();
		request.setAttribute("employee", emp);
                
//                
//                RadioState radioState = new RadioState();
//                radioState.setYesCheck(true);
//                radioState.setNoCheck(false);
//                
//                session.setAttribute("radioState", radioState);
                
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String choice = request.getParameter("radioJSPCool");
        RadioState radioState = new RadioState();
        if (choice != null) {
            System.out.println("choice= " + choice);
//            if(choice.equals("1")) {
//                radioState.setYesCheck(true);
//                radioState.setNoCheck(false);
//            } else {
//                radioState.setNoCheck(true);
//                radioState.setYesCheck(false);
//            }
//            request.getSession().setAttribute("radioState", radioState);
        } else {
            System.out.println("No choice made");
        }
        RequestDispatcher dispatch = request.getRequestDispatcher("Choose.jsp");
        dispatch.forward(request, response);
    }

}
class RadioState {
    private Boolean yesCheck;
    private Boolean noCheck;

    public Boolean isYesCheck() {
        return yesCheck;
    }

    public void setYesCheck(Boolean yesCheck) {
        this.yesCheck = yesCheck;
    }

    public Boolean isNoCheck() {
        return noCheck;
    }

    public void setNoCheck(Boolean noCheck) {
        this.noCheck = noCheck;
    }
}

class Employee  {

	private String name;
	private int id;
        private boolean test;
        

	public Employee() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String nm) {
		this.name = nm;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public boolean isTest() {
        return test;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
	
	@Override
	public String toString(){
		return "ID="+id+",Name="+name;
	}

}