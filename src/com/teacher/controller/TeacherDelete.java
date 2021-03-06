package com.teacher.controller;

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

import com.dao.StudentDao;
import com.dao.TeacherDao;

/**
 * Servlet implementation class TeacherDelete
 */
@WebServlet("/map/TeacherDelete")
public class TeacherDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static TeacherDao teacherDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherDelete() {
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
		List<String>success_msg = new ArrayList<>();
		
		try {
			int id = Integer.parseInt(request.getParameter("teacher_id"));
			teacherDao.deleteTeacher(id);
			success_msg.add("Teacher Deleted SuccessFully...");
			request.setAttribute("success", success_msg);
			RequestDispatcher disp = request.getRequestDispatcher("Teachers");
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
