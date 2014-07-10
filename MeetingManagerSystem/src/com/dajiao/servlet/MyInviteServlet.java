package com.dajiao.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dajiao.dao.MyBookingDAO;
import com.dajiao.model.Department;
import com.dajiao.model.Meeting;
import com.dajiao.model.User;
import com.dajiao.service.AdDepartmentService;
import com.dajiao.service.MyBookingService;
import com.dajiao.service.MyInviteService;

/**
 * Servlet implementation class MyInviteServlet
 */
@WebServlet("/MyInviteServlet")
public class MyInviteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInviteServlet() {
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
		
		User user = (User)request.getSession().getAttribute("person");

		if(user != null ){
			String page = (String)request.getParameter("page");
			String search = (String)request.getParameter("search");
			String invite = (String)request.getParameter("invite");
			String delete = (String)request.getParameter("delete");
			
			if(page==null || (page != null && page.equals("2") && invite != null)){
				// jump to page 1
			
				request.setAttribute("bookingList", MyBookingService.getMyBooking(user.getAccount()));
				page = "1";
				
			}else if (page.equals("1") || page.equals("3") || (page.equals("2") && delete != null)){
				// jump to page 2
				
				request.setCharacterEncoding("utf-8");
				String str = (String)request.getParameter("meetingId");
				String topic = (String)request.getParameter("topic");
				int meetingId = Integer.parseInt(str);
				
				// invite user
				if(page.equals("3") == true){
					String[] account = (String[])request.getParameterValues("inviteUser");
					if(account != null && MyInviteService.inviteUser(account, meetingId)==true){
						for(String value : account )
							System.out.println("invite user " + account);
					}
				}
				
				// delete user
				if(delete != null){
					String account = (String)request.getParameter("account");
					if(MyInviteService.deleteUser(account, meetingId) == true)
						System.out.println("delete user " + account);
				}
				
				// test code
				System.out.println("meeting id " + meetingId);
				System.out.println("meeting topic " + MyInviteService.getTopic(meetingId));
				
				request.setAttribute("topic", MyInviteService.getTopic(meetingId));
				request.setAttribute("meetingId", String.valueOf(meetingId));
				request.setAttribute("departmentList", AdDepartmentService.getDepartmentList());
				request.setAttribute("inviteList", MyInviteService.getInviteList(meetingId));
				
				page = "2";
			}else if (page.equals("2") && search != null){
				// jump to page 3
				String meetingId = (String)request.getParameter("meetingId");
				
				String name = (String)request.getParameter("name");
				// String sex = (String)request.getParameter("sex");
				String department = (String)request.getParameter("department");
				
				// test code
				if(name != null) System.out.println("name :" + name);
				// if(sex != null) System.out.println("sex :" + sex);
				if(department != null) System.out.println("department :" + department);
				// end of test code
				
				request.setAttribute("meetingId", meetingId);
				request.setAttribute("userList", MyInviteService.getUserList(name, department, Integer.parseInt(meetingId)));
				
				page = "3";
			}
			
			request.getRequestDispatcher("./myInvite.jsp?page=" + page).forward(request, response);
			
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
		
		
//		String page = (String)request.getParameter("page");
//		String meetingId = (String)request.getParameter("meetingId");
//		request.setAttribute("meetingId", meetingId);
//		
//		if(page != null && page.equals("2")){
//			
//			if(meetingId != null){
//				
//				// test code
//				List<User> userList = new ArrayList<User>();
//				user = new User();
//				user.setaccount("jiao");
//				user.setUserid("12");
//				user.setDepartment("帅哥部");
//				user.setName("伪");
//				user.setSex("man");
//				user.setAnhao("烤鸭");
//				userList.add(user);
//				user = new User();
//				user.setaccount("dajiao");
//				user.setUserid("121");
//				user.setDepartment("帅哥部");
//				user.setName("伪装成");
//				user.setSex("man");
//				user.setAnhao("北京烤鸭");
//				userList.add(user);
//				request.setAttribute("userList", userList);
//				// test code end
//				
//				String[] inviteUser = (String[])request.getParameterValues("inviteUser");
//				// test code
//				if(inviteUser != null){
//					for(String value: inviteUser){
//						System.out.println("invite User:" + value);
//					}
//				}
//				// test code end
//				
////				// test code
////				List<Department> departmentList = new ArrayList<Department>();
////				Department department = new Department();
////				department.setName("帅哥部");
////				departmentList.add(department);
////				department = new Department();
////				department.setName("lala部");
////				departmentList.add(department);
////				department = new Department();
////				department.setName("kaka部");
////				departmentList.add(department);
////				request.setAttribute("departmentList", departmentList);
//				// end of test code
//				
//				if(MyInviteService.inviteUser(inviteUser)==true){
//					System.out.println("invite success ");
//				}
//				request.setAttribute("departmentList", AdDepartmentService.getDepartmentList());
//				request.setAttribute("inviteList", MyInviteService.getInviteList(Integer.parseInt(meetingId)));
//			}  
//			
//			
//			
//		}else if(page != null && page.equals("3")){
//			String name = (String)request.getParameter("name");
//			String sex = (String)request.getParameter("sex");
//			String department = (String)request.getParameter("department");
//			
//			
//			// test code
//			if(name != null) System.out.println("name :" + name);
//			if(sex != null) System.out.println("sex :" + sex);
//			if(department != null) System.out.println("department :" + department);
//			// end of test code
//			
////			// test code
////			List<User> userList = new ArrayList<User>();
////			user = new User();
////			user.setaccount("searchjiao");
////			user.setUserid("2");
////			user.setDepartment("帅哥部");
////			user.setName("伪");
////			user.setSex("man");
////			user.setAnhao("烤鸭");
////			userList.add(user);
////			user = new User();
////			user.setaccount("searchDajiao");
////			user.setUserid("92");
////			user.setDepartment("帅哥部");
////			user.setName("伪装成");
////			user.setSex("man");
////			user.setAnhao("北京烤鸭");
////			userList.add(user);
////			request.setAttribute("userList", userList);
////			// test code end
//			
//			request.setAttribute("meetingId", meetingId);
//			// request.setAttribute("userList", MyInviteService.getUserList(name, sex, department));
//			request.getRequestDispatcher("./myInvite.jsp?page=3").forward(request, response);
//			
//		}else{
//			// get the the bookingList
//			
//			if(meetingId != null){
//				String[] deleteUser = (String[])request.getParameterValues("deleteUser");
//				MyInviteService.deleteUser(deleteUser);
//				// @TODO add some prompt message
//			}
//			
////			// test code
////			List<Meeting> meetingList = new ArrayList<Meeting>();
////			Meeting meeting = new Meeting();
////			meeting.setId(12);
////			meeting.setTopic("topic");
////			meeting.setDetail("hahah");
////			meeting.setRoomname("wobuzhidao");
////			meeting.setStarttime(Timestamp.valueOf("2014-07-12 21:30:00"));
////			meeting.setEndtime(Timestamp.valueOf("2014-07-13 22:00:00"));
////			meetingList.add(meeting);
////			request.setAttribute("bookingList", meetingList);
////			// end of test code
//
//			request.setAttribute("bookingList", MyBookingService.getMyBooking(user.getaccount()));
//			
//		}	
//		
//		request.getRequestDispatcher("./myInvite.jsp?page=" + page).forward(request, response);
	}

}
