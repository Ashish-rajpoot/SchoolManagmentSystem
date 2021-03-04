package com.teacher.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;

/**
 * Servlet implementation class Teachers
 */
@WebServlet("/map/Teachers")
public class Teachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TeacherDao teacherDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachers() {
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
	
		try {
			List<com.entity.Teachers> teacherss = TeacherDao.getAllTeachers();
			request.setAttribute("teacher",teacherss);		
			RequestDispatcher rd = request.getRequestDispatcher("teacher.jsp");
			rd.forward(request, response);
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
