package com.dajiao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dajiao.model.User;
import com.dajiao.service.RegisterService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String account = (String)request.getParameter("accountRe");
		String password = (String)request.getParameter("passwordRe");
		String userid = (String)request.getParameter("useridRe");
		String name = (String)request.getParameter("nameRe");
		String department = (String)request.getParameter("departmentRe");
		String anhao = (String)request.getParameter("anhaoRe");
		String sex = (String)request.getParameter("sexRe");
		
		System.out.println("account : " + account +
						"password : " + password +
						"name : " + name +
						"department : " + department +
						"anhao : " + anhao);
		
		User user  = new User(name, department, "unapproval");
		user.setAccount(account);
		user.setAnhao(anhao);
		user.setUserid(userid);
		user.setSex(sex);
		
		if(RegisterService.register(user, password)){
			response.sendRedirect("./meetingManager.jsp?register=1");
		}else{
			response.sendRedirect("./meetingManager.jsp?register=0");
		}

	}

}
