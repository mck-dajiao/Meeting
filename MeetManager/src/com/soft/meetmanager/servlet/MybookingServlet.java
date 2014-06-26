package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.SelectMeetingDao;
import com.soft.meetmanager.service.MyBookingService;

public class MybookingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MybookingServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userid = Integer.parseInt(request.getParameter("empid"));
		MyBookingService mbs=new MyBookingService();
		List list =mbs.myBook(userid);
		//SelectMeetingDao mydao = new SelectMeetingDao();
		//List list = mydao.selectMymt(userid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/mybookings.jsp").forward(request,
				response);
	}

}
