package com.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.entity.Students;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/map/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDao studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<String>success_msg = new ArrayList<>();
		
			try {
				String name = request.getParameter("name");
				String email = request.getParameter("email_id");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");	
				int classid = Integer.parseInt(request.getParameter("class_id"));
				
				
				
				studentDao.insertStudent(new Students(name,email,age,gender,classid));
				success_msg.add("Student Added SuccessFully...");
				request.setAttribute("success", success_msg);
				RequestDispatcher disp = request.getRequestDispatcher("studentform.jsp");
				   disp.forward(request, response);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
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
