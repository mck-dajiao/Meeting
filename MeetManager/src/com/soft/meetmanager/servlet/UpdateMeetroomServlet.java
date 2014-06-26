package com.soft.meetmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.model.MeetingRoom;
import com.soft.meetmanager.service.MeetingRoomService;

public class UpdateMeetroomServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UpdateMeetroomServlet() {
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
		//把获取到的参数封装成对象
		MeetingRoom mt = new MeetingRoom();
		mt.setRoomid(Integer.parseInt(request.getParameter("roomid")));
		mt.setRoomname(request.getParameter("roomname"));
		mt.setStatus(request.getParameter("status"));
		mt.setCapacity(Integer.parseInt(request.getParameter("roomcapacity")));
		mt.setDescription(request.getParameter("description"));
		mt.setRoomcode(Integer.parseInt(request.getParameter("roomcode")));
		MeetingRoomService mtservice = new MeetingRoomService();
		int updateFlag = mtservice.updateRoom(mt);
		//判断如果updatFlag=1,跳转修改成功页面，等于零跳转失败页面
		if(updateFlag != 0){
			request.getRequestDispatcher("/updateSuccess.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/updateFail.jsp").forward(request, response);
		}
	}

}
