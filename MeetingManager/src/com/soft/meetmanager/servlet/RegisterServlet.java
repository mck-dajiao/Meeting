package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.RegisterDAO;
import com.soft.meetmanager.model.Employee;
import com.soft.meetmanager.service.RegistService;

public class RegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RegisterServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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
        //employeename accountname password confirm phone email
		String employeename=request.getParameter("employeename");
		String accountname=request.getParameter("accountname");
		String password=request.getParameter("password");
		//String confirm=request.getParameter("confirm");
		String phone=(request.getParameter("phone"));
		String email=request.getParameter("email");
		//获取select的值
		Integer departmentid=1;
		Employee emplo=new Employee(employeename,accountname,  password, phone, email, departmentid);
		RegistService rservice=new RegistService();
		rservice.regist(emplo);
		//RegisterDAO registd=new RegisterDAO();
		//registd.insertuser(emplo);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
