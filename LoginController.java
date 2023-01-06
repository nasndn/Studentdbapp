package com_Studentdbapp1_controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com_studentapp1_model.DAO;
import com_studentapp1_model.DAOImpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	String email = request.getParameter("email");
       String password = request.getParameter("password");
       
       DAO dao=new DAOImpl();
       dao.connectDB();
       boolean status=dao.verifyLoginCredentials(email, password);
       if (status==true) {
    	   HttpSession session = request.getSession(true);
    	   session.setAttribute("email", email);
    	   session.setMaxInactiveInterval(10);
    	   RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newRegistration.jsp");
    	   rd.forward(request, response);
	} else {
           request.setAttribute("msg", "invalid username/password");
    	   RequestDispatcher rd = request.getRequestDispatcher("login1.jsp");
    	   rd.include(request, response);

	}

	}

}
