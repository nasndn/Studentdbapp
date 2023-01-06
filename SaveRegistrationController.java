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

@WebServlet("/saveReg")
public class SaveRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SaveRegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newRegistration.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			session.setMaxInactiveInterval(10);
			if (session.getAttribute("email") != null) {
				int id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String city = request.getParameter("city");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");

				DAO dao = new DAOImpl();
				dao.connectDB();
				dao.saveRegistration(id, name, city, email, mobile);

				request.setAttribute("msg", "New Registration is created");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/newRegistration.jsp");
				rd.include(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("login1.jsp");
				rd.include(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			 request.setAttribute("msg", "Session Timeed Out.Please login again");
			RequestDispatcher rd = request.getRequestDispatcher("login1.jsp");
			rd.include(request, response);
		}
		}
	}


