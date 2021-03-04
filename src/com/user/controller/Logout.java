package com.user.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "logout", urlPatterns = {"/map/Logout"})
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
    	ArrayList<String> success = new ArrayList<>();
        HttpSession session = request.getSession(false);
        session.setAttribute("user", "");
        session.removeAttribute("user");
        session.invalidate();
        success.add("SuccessFully LogOut...");
		request.setAttribute("success",success);
        response.sendRedirect("/SchoolManagmentSystem/login");
    }
}
