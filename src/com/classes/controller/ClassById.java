package com.classes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ClassDao;
import com.entity.Classes;

/**
 * Servlet implementation class ClassById
 */
@WebServlet("/map/ClassById")
public class ClassById extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private static ClassDao classDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassById() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		classDao = new ClassDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//edit

			try {
				int id = Integer.parseInt(request.getParameter("class_id"));
				Classes exitstingClass;

				exitstingClass = classDao.selectClassById(id);	
				request.setAttribute("cls", exitstingClass);
				RequestDispatcher dispatcher = request.getRequestDispatcher("classform.jsp");
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
