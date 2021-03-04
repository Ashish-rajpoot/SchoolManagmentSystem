package com.teacher.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.entity.Students;
import com.entity.Teachers;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/map/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TeacherDao teacherDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeacher() {
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
				String teacher_name = request.getParameter("teacher_name");
				String email = request.getParameter("email_id");				
				String gender = request.getParameter("gender");	
				
				
				
				teacherDao.insertTeacher(new Teachers(teacher_id,age,teacher_name,gender,email));
				RequestDispatcher disp = request.getRequestDispatcher("Teachers");
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
