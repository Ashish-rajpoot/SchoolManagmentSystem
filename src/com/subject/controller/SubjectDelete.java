package com.subject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet("/map/SubjectDelete")
public class SubjectDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SubjectDao subjectDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectDelete() {
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
		List<String>success_msg = new ArrayList<>();		
		//Delete Subjects
		try {
			int id = Integer.parseInt(request.getParameter("subject_id"));
			subjectDao.deleteSubject(id);
			success_msg.add("Subject Deleted SuccessFully...");
			request.setAttribute("success", success_msg);
			RequestDispatcher disp = request.getRequestDispatcher("Subjects");
		       disp.forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
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
