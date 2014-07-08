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
import com.dajiao.service.AdApprovalService;

/**
 * Servlet implementation class AdApprovalServlet
 */
@WebServlet("/AdApprovalServlet")
public class AdApprovalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdApprovalServlet() {
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
		String submit = (String)request.getParameter("submit");
		if(admin != null){
			// request.setAttribute("userList", AdApprovalService.getUnapproval());
			
			// test code
			User user;
			List<User> userList = new ArrayList<User>();
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
			request.setAttribute("userList", userList);
			// end of test code
			
			if(submit != null){
				String[] agree = (String[])request.getParameterValues("agree");
				if(agree!=null){
					System.out.println("agree "+ agree[0]);
					AdApprovalService.agreeUserList(agree);
					// @TODO add response to result
				}
				String[] disagree = (String[])request.getParameterValues("disagress");
				if(disagree!=null){
					System.out.println("disagree " + disagree[0]);
					AdApprovalService.disagreeUserList(disagree);
					// @TODO add response to result
				}
			}
			
			request.getRequestDispatcher("./AdApproval.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
	}

}
