package com.soft.meetmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.service.MeetingRoomService;

public class MeetingDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MeetingDetailServlet() {
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
		request.setCharacterEncoding("utf-8");
		String flag = request.getParameter("flag");
		String roomcode = request.getParameter("roomcode");
		MeetingRoomService service = new MeetingRoomService();
		MeetingRoom mtroom = new MeetingRoom();
		mtroom = service.roomDetail(roomcode);
		request.setAttribute("roomdetail", mtroom);
		request.getRequestDispatcher("roomdetails.jsp").forward(request, response);
	}

}
