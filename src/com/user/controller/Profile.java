package com.user.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.Teachers;
import com.entity.Users;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/map/ProfileServlet")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDao userDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
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
		HttpSession session = request.getSession(false);
			try {
				Users user_id = (Users) session.getAttribute("sessionProfile");
				int userid= user_id.getUser_id();
				Users use = UserDao.selectById(userid);
				request.setAttribute("profile", use);
				RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
				rd.forward(request, response);
			} catch (NumberFormatException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
