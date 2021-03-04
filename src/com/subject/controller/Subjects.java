package com.subject.controller;

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


import com.dao.SubjectDao;
import com.entity.Students;



/**
 * Servlet implementation class Subjects
 */
@WebServlet("/map/Subjects")
public class Subjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SubjectDao subjectDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Subjects() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		subjectDao = new SubjectDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			List<com.entity.Subjects> subjects = subjectDao.getAllSubjects();
			request.setAttribute("subject", subjects);		
			RequestDispatcher rd = request.getRequestDispatcher("subject.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		//Edit or update
//		try {			
//			int student_id = Integer.parseInt(request.getParameter("subject_id"));
//			String name = request.getParameter("name");
//			
//			subjectDao.addSubject(new com.entity.Subjects(student_id,name));
//			RequestDispatcher disp = request.getRequestDispatcher("subject.jsp");
//			   disp.forward(request, response);
//		} catch (NumberFormatException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
