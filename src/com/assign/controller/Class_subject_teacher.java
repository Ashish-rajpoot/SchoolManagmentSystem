package com.assign.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Class_subjects_teachersDao;

/**
 * Servlet implementation class Class_subject_teacher
 */
@WebServlet("/map/Class_subject_teacher")
public class Class_subject_teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Class_subjects_teachersDao class_subjects_teachersDao;

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Class_subject_teacher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		class_subjects_teachersDao = new Class_subjects_teachersDao();
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			List<com.entity.Class_subjects_teachers> class_subjects_teachers= class_subjects_teachersDao.getAllClassesSubjectsTeachers();
			request.setAttribute("data", class_subjects_teachers);		
			RequestDispatcher rd = request.getRequestDispatcher("configclass.jsp");
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
