package myfilter;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AdminFilter
 */
@WebFilter("/AdminFilter")
public class AdminFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AdminFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
	        HttpServletResponse res = (HttpServletResponse) response;
	        HttpSession session = req.getSession(false);
		
		 String user = null;

	        if (session != null)
	            user = (String) session.getAttribute("user");

	        String servletPath = req.getServletPath();

	        if (session == null || user == null || user.equals(" ")) {

	            if (servletPath.equals("/home") || servletPath.equals("/login"))
	                chain.doFilter(req, res);
	            else
	                res.sendRedirect("login");

	        } else {

	            if (servletPath.equals("/login"))
	                res.sendRedirect("home?user-exists");
	            else
	                chain.doFilter(req, res);
	        }
		
//		if (session.getAttribute("username")==null && !req.getRequestURI().endsWith("admin/login"))
//			req.getRequestDispatcher("login.jsp").forward(request, response);	
//		else
//			chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
