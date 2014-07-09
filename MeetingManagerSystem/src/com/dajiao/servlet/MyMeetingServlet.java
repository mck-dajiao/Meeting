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

import com.dajiao.model.Meeting;
import com.dajiao.model.User;
import com.dajiao.service.MyMeetingService;

/**
 * Servlet implementation class MyMeetingServlet
 */
@WebServlet("/MyMeetingServlet")
public class MyMeetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyMeetingServlet() {
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
		if(user != null){
			request.setAttribute("meetingList", MyMeetingService.getMyMeeting(user.getaccount()));
			
			
			// test code
			List<Meeting> meetingList = new ArrayList<Meeting>();
			Meeting meeting = new Meeting();
			meeting.setTopic("topic");
			meeting.setDetail("hahah");
			meeting.setRoomname("wobuzhidao");
			meeting.setStarttime(Timestamp.valueOf("2014-07-12 21:30:00"));
			meeting.setEndtime(Timestamp.valueOf("2014-07-13 22:00:00"));
			meetingList.add(meeting);
			request.setAttribute("meetingList", meetingList);
			// end of test code
			
			request.getRequestDispatcher("./myMeeting.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
	}

}
