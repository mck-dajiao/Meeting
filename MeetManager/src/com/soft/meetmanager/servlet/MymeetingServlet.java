package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.SelectMeetingDao;
import com.soft.meetmanager.dao.SelectmymeetingDAO;
import com.soft.meetmanager.service.MymeetingService;

public class MymeetingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MymeetingServlet() {
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
		doPost(request, response);
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
		int userid = Integer.parseInt(request.getParameter("empid"));
		// SelectmymeetingDAO  mydao = new SelectmymeetingDAO();
		//List list = mydao.selectMymeet(userid);
		MymeetingService mms=new MymeetingService();
		List list=mms.myMeet(userid);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/mymeetingdetails.jsp").forward(request,
				response);
	}

}
