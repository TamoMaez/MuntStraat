package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Business;
import domain.BusinessSystem;

/**
 * Servlet implementation class CrudController
 */
@WebServlet("/Controller")
public class CrudController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BusinessSystem bss; 
	
    public CrudController() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
     super.init();
	     ServletContext context = getServletContext();
	     Properties properties = new Properties();
	     
	     Enumeration<String> parameterNames = context.getInitParameterNames();
	     while (parameterNames.hasMoreElements()){
	    	 String propertyName = parameterNames.nextElement();
	    	 properties.setProperty(propertyName, context.getInitParameter(propertyName));	 
	     }
	     bss = new BusinessSystem(properties);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action != null && action.equals("filter")){
			response.setContentType("application/json"); 
			PrintWriter out = response.getWriter();
			
			if(request.getParameterMap().containsKey("type")){
				out.print(bss.getFilteredByType(request.getParameter("type")));
			}else{
				out.print(bss.getBusinessesAsJson());
			}
		}else{
			String destination = processRequest(action , request, response);	
			RequestDispatcher view = request.getRequestDispatcher(destination);
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination = processRequest(request.getParameter("action"), request, response);	
		RequestDispatcher view = request.getRequestDispatcher(destination);
		view.forward(request, response);
	}
	
	private String processRequest(String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(action == null) return getOverview(request);
		switch(action){
		case "read"		: return getOverview(request);
		/*case "edit"		: return editUser(request, response);
		case "delete" 	: return deleteUser(request, response);	
		case "login" 	: return login(request, response);	
		case "logout" 	: return logout(request, response);*/
		default : return getOverview(request);
		}
	}
	
	private String getOverview(HttpServletRequest request) throws ServletException, IOException {
		request.setAttribute("bsJson", bss.getBusinessesAsJson().toString());
		return "overview.jsp";
	}

}
