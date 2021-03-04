package com.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TeacherDao;
import com.entity.Teachers;

/**
 * Servlet implementation class TeacherUpdateEdit
 */
@WebServlet("/map/TeacherUpdateEdit")
public class TeacherUpdateEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TeacherDao teacherDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdateEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		teacherDao = new TeacherDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	
			try {
				int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
				int age = Integer.parseInt(request.getParameter("age"));
				String teachername= request.getParameter("teacher_name");
				String gender = request.getParameter("gender");
				String emailid = request.getParameter("email_id");
				Teachers book = new Teachers(teacher_id,age,teachername,gender,emailid);
				teacherDao.updateTeacher(book);
				
				RequestDispatcher rd = request.getRequestDispatcher("Teachers");
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
