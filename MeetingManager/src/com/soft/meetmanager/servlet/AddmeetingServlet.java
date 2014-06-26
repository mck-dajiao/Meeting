package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.model.Meeting;
import com.soft.meetmanager.service.AddmeetingService;

public class AddmeetingServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddmeetingServlet() {
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

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String selSelectedEmployees = request
				.getParameter("selSelectedEmployees");
		String meetingname = request.getParameter("meetingname");
		Integer numofattendents = Integer.parseInt(request
				.getParameter("numofattendents"));
		Date startdate = Date.valueOf(request.getParameter("startdate"));
 		Date enddate = Date.valueOf(request.getParameter("enddate"));
 		String description = request.getParameter("description");
 		String strRoomid = request.getParameter("roomid");
 		int empid = Integer.parseInt(request.getParameter("empid"));
 		int roomid = Integer.parseInt(strRoomid);
 		//获取当前日期存入数据库
 		Date sqldate = null;
 		SimpleDateFormat sf = new SimpleDateFormat("yyyy-mm-dd");
 		String dat = sf.format(new java.util.Date());
 		try {
			java.util.Date dt = sf.parse(dat);
			sqldate = new Date(dt.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
  		Meeting smellm = new Meeting(meetingname,roomid, numofattendents, startdate,
				enddate, description, selSelectedEmployees,empid,sqldate);
		AddmeetingService addservice = new AddmeetingService();
		int insFlag = 0;
		insFlag = addservice.addmeetig(smellm);
		if (insFlag != 0) {
			request.getRequestDispatcher("insertSuccess.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("insertFail.jsp").forward(request,
					response);
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
