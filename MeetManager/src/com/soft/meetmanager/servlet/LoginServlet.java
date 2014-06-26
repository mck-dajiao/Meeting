package com.soft.meetmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.soft.meetmanager.dao.LoginDAO;
import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.service.LoginService;

public class LoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	 doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usename=request.getParameter("usename");
	    String pwd=request.getParameter("pwd");
	    Employee emp=new Employee(usename,pwd);
	   HttpSession session=request.getSession();
	   LoginService lgservice = new LoginService();
	  // LoginDAO LA=new LoginDAO();
	  // int i=LA.believe(emp);
	      int i=lgservice.getDet(emp);
         if(i==1){
	    	//LoginService lgservice = new LoginService();
	    	Employee empdetail = lgservice.getDetail(usename);
	    	session.setAttribute("empdetail", empdetail);
	    	request.getRequestDispatcher("/index.jsp").forward(request, response);
	    }
	    else{
	    	request.getRequestDispatcher("/Fail.html").forward(request, response);
	    }
	}

}
