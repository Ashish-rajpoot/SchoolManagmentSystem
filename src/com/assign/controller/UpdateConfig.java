package com.assign.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Class_subjects_teachersDao;
import com.entity.Class_subjects_teachers;

/**
 * Servlet implementation class UpdateConfig
 */
@WebServlet("/map/UpdateConfig")
public class UpdateConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Class_subjects_teachersDao class_subjects_teachersDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateConfig() {
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
				int assign_id = Integer.parseInt(request.getParameter("assign_id"));
				int class_id = Integer.parseInt(request.getParameter("class_id"));
				int teacher_id = Integer.parseInt(request.getParameter("teacher_id"));
				int subject_id = Integer.parseInt(request.getParameter("subject_id"));

				Class_subjects_teachers book = new Class_subjects_teachers(class_id,subject_id, teacher_id,assign_id );

				class_subjects_teachersDao.updateClass_subjects_teachers(book);
				RequestDispatcher disp = request.getRequestDispatcher("Class_subject_teacher");
				   disp.forward(request, response);
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
