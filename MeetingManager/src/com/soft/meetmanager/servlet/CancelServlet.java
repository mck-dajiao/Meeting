package com.soft.meetmanager.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soft.meetmanager.model.CancelDao;

public class CancelServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CancelServlet() {
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
		int mtid = Integer.parseInt(request.getParameter("mtid"));
		CancelDao canDao = new CancelDao();
		int delFlag = canDao.cancelMeeting(mtid);
		if(delFlag != 0){
			request.setAttribute("delflg", "取消预约成功！");
		}else{
			request.setAttribute("delflg", "取消预约失败！");
		}
		request.getRequestDispatcher("/delflag.jsp").forward(request, response);
	}

}
