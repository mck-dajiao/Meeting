package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.SelectDepartmentDAO;
import com.soft.meetmanager.dao.SelectMeetingroomDAO;
import com.soft.meetmanager.service.DepartmentService2;

public class DepartmentServlet2 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DepartmentServlet2() {
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
		String methodCode = request.getParameter("methodCode"); 
		if(methodCode.equals("selectdepartment")){
		// SelectDepartmentDAO room=new SelectDepartmentDAO();
	    //List list=room.lookingdepartment();
		 DepartmentService2 ds2=new DepartmentService2 ();
		 List list=ds2.selectd();
	     request.setAttribute("list",list);
	     request.getRequestDispatcher("/selectdepartment.jsp").forward(request, response);
	    
	}}

}
