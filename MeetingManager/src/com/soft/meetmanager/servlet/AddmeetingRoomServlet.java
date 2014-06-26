package com.soft.meetmanager.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.MeetingRoomDao;
import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.service.MeetingRoomService;

public class AddmeetingRoomServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddmeetingRoomServlet() {
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

		Integer roomnumber=Integer.parseInt(request.getParameter("roomnumber"));
		String roomname=request.getParameter("roomname");
		Integer capacity=Integer.parseInt(request.getParameter("capacity"));
		String status=request.getParameter("status");
		String description=request.getParameter("description");
		MeetingRoom mr=new MeetingRoom();
		mr.setRoomcode(roomnumber);
		mr.setRoomname(roomname);
		mr.setCapacity(capacity);
		mr.setStatus(status);
		mr.setDescription(description);
		MeetingRoomService mrs=new MeetingRoomService();
		mrs.insert(mr);
		
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
