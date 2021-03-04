package com.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.entity.Classes;
import com.entity.Students;

/**
 * Servlet implementation class TeacherEditUpdate
 */
@WebServlet("/map/StudentEditUpdate")
public class StudentEditUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDao studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEditUpdate() {
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
		
		try {
			int student_id = Integer.parseInt(request.getParameter("student_id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email_id");
			int age = Integer.parseInt(request.getParameter("age"));
			String gender = request.getParameter("gender");	
			int classid = Integer.parseInt(request.getParameter("class_id"));
			
			Students updateStudent = new Students(student_id,name,email,age,gender,classid);

			studentDao.updateStudents(updateStudent);
			RequestDispatcher disp = request.getRequestDispatcher("Students");
		       disp.forward(request, response);
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
