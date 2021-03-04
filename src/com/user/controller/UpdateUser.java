package com.user.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.entity.Teachers;
import com.entity.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/map/AdminUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		userDao = new UserDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<String> errors = new ArrayList<>();
		ArrayList<String> success = new ArrayList<>();
		String name= request.getParameter("name");
		String email = request.getParameter("email");

		if(name==null||name.equals("")||email==null||email.equals("")) {
			errors.add("All fields Required ..");

		};
		
		if(errors.size()>0) {
			request.setAttribute("errors", errors);
			RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
			rd.forward(request, response);
		}
		else {
			try {
				int user_id = Integer.parseInt(request.getParameter("user_id"));
				Users book = new Users(user_id,name,email);
				userDao.updateNameEmail(book);
				success.add("Profile SuccessFully Changed...");
				request.setAttribute("success",success);
				RequestDispatcher rd = request.getRequestDispatcher("ProfileServlet");
				rd.forward(request, response);
			} catch (NumberFormatException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
