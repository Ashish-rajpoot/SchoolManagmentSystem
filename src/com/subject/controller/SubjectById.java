package com.subject.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.SubjectDao;
import com.entity.Subjects;



/**
 * Servlet implementation class Subjects
 */
@WebServlet("/map/SubjectById")
public class SubjectById extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private static SubjectDao subjectDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectById() {
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
		
		
		
		//Select Subject By Id
		try {
			int subject_id = Integer.parseInt(request.getParameter("subject_id"));
			Subjects exitstingClass;
			exitstingClass = SubjectDao.selectSubjectById(subject_id);	
			request.setAttribute("subject", exitstingClass);
			RequestDispatcher dispatcher = request.getRequestDispatcher("subjectform.jsp");
			dispatcher.forward(request, response);
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
