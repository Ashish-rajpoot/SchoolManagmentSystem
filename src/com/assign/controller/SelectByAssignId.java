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
 * Servlet implementation class SelectByAssignId
 */
@WebServlet("/map/SelectByAssignId")
public class SelectByAssignId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Class_subjects_teachersDao class_subjects_teachersDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectByAssignId() {
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
		
		int assign_id = Integer.parseInt(request.getParameter("assign_id"));
		Class_subjects_teachers existingData;
		
		existingData = class_subjects_teachersDao.selectClass_subjects_teachersByClassId(assign_id);
		System.out.println(existingData);
		request.setAttribute("assign", existingData);
		RequestDispatcher rd = request.getRequestDispatcher("configclassform.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
