package com.soft.meetmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.dao.MyMtDetailDao;
import com.soft.meetmanager.model.Meeting;

public class MyMtDetailServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MyMtDetailServlet() {
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
		String mid = request.getParameter("mtid");
		int mtid = Integer.parseInt(mid);
		MyMtDetailDao myDetailDao = new MyMtDetailDao();
		Meeting mt = myDetailDao.meetingDetail(mtid);
		request.setAttribute("mtdetail", mt);
		request.getRequestDispatcher("/meetingdetals.jsp").forward(request, response);
	}

}
