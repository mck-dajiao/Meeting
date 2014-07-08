package com.dajiao.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dajiao.model.Administrator;
import com.dajiao.model.User;
import com.dajiao.service.AdEmployeeService;
import com.dajiao.service.RegisterService;

/**
 * Servlet implementation class AdEmployeeServlet
 */
@WebServlet("/AdEmployeeServlet")
public class AdEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdEmployeeServlet() {
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
		Administrator admin = (Administrator)request.getSession().getAttribute("person");
		
		// test code
		admin = new Administrator();
		// end of test code
		
		if(admin != null){
			String delete = (String)request.getParameter("delete");
			if(delete!=null){
				String[] value = (String[])request.getParameterValues("userAccount");
				
				// test code 
				for(String str : value)
					System.out.println("delete :" + str);
				// end of test code
				
				AdEmployeeService.deleteUser(value);
				// @TODO 业务提示
			}
			
			String newEmployee = (String)request.getParameter("newEmployee");
			if(newEmployee!=null){
				String account = (String)request.getParameter("account");
				String name = (String)request.getParameter("name");
				String password = (String)request.getParameter("password");
				String anhao = (String)request.getParameter("anhao");
				String department = (String)request.getParameter("department");
				
				// test code
				System.out.println("account :" + account);
				System.out.println("name :" + name);
				System.out.println("password :" + password);
				System.out.println("department :" + department);
				System.out.println("anhao :" + anhao);
				// end of test code
				
				User user = new User();
				user.setaccount(account);
				user.setname(name);
				user.setAnhao(anhao);
				user.setDepartment(department);
				user.setStatus("approval");
				// RegisterService.register(user, password);
				// @TODO 添加用户提示
			}
			
			String search = (String)request.getParameter("search");
			if(search != null){
				String name = (String)request.getParameter("name");
				String department = (String)request.getParameter("department");
				String userId = (String)request.getParameter("userId");
				
				// test code
				System.out.println("name " + name);
				System.out.println("departmet " + department);
				System.out.println("userId " + userId);
				// end of test code
				
				// List<User> userList = (List<User>)AdEmployeeService.getUserList(name, userId, department);
				
				// test code
				List<User> userList = new ArrayList<User>();
				User user;
				user = new User();
				user.setaccount("jiao");
				user.setId(11);
				user.setDepartment("帅哥部");
				user.setName("伪");
				user.setSex("man");
				user.setAnhao("烤鸭");
				userList.add(user);
				user = new User();
				user.setaccount("dajiao");
				user.setId(10);
				user.setDepartment("帅哥部");
				user.setName("伪装成");
				user.setSex("man");
				user.setAnhao("北京烤鸭");
				userList.add(user);
				// end of test code
				request.setAttribute("userList", userList);
			}
			
			
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("./AdEmployee.jsp").forward(request, response);;
	}

}
