package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.SearchmeetingroomDAO;

public class SearchmeetingroomServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchmeetingroomServlet() {
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
		request.setCharacterEncoding("utf-8");
		String meetingname=request.getParameter("meetingname");
		String roomname=request.getParameter("roomname");
		Date reservefromdate=Date.valueOf(request.getParameter("reservefromdate"));
		Date reservetodate=Date.valueOf(request.getParameter("reservetodate"));
		//Date meetingfromdate=Date.valueOf(request.getParameter("meetingfromdate"));
		//Date meetingtodate=Date.valueOf(request.getParameter("meetingtodate"));
		SearchmeetingroomDAO sdo=new SearchmeetingroomDAO();
		//, meetingfromdate, meetingtodate
		List list=sdo.lookingMeeting(meetingname, roomname, reservefromdate, reservetodate);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/searchmeeting.jsp").forward(request, response);
	}

}
