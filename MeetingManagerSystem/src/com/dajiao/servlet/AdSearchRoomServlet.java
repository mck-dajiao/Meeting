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
import com.dajiao.model.MeetingRoom;
import com.dajiao.service.AdSearchRoomService;

/**
 * Servlet implementation class AdSearchRoomServlet
 */
@WebServlet("/AdSearchRoomServlet")
public class AdSearchRoomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdSearchRoomServlet() {
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
			String search = (String)request.getParameter("search");
			if(search != null){
				String status = (String)request.getParameter("status");
				
				System.out.println("search meetingRoom by status : " + status);
				
				// test code
				List<MeetingRoom> list = new ArrayList<MeetingRoom>();
				MeetingRoom room = new MeetingRoom();
				room.setId(1);
				room.setName("nimei");
				room.setStatus("open");
				room.setTotal(300);
				room.setType("multimedia");
				list.add(room);
				room = new MeetingRoom();
				room.setId(3);
				room.setName("nia");
				room.setStatus("open");
				room.setTotal(300);
				room.setType("multimedia");
				list.add(room);
				room = new MeetingRoom();
				room.setId(4);
				room.setName("nimd");
				room.setStatus("close");
				room.setTotal(300);
				room.setType("normal");
				list.add(room);
				request.setAttribute("roomList", list);
				// end of test code
				
				// request.setAttribute("roomList", AdSearchRoomService.getRoomListByStatus(status));
			}else{
				// test code
				List<MeetingRoom> list = new ArrayList<MeetingRoom>();
				MeetingRoom room = new MeetingRoom();
				room.setId(2);
				room.setName("nimei");
				room.setStatus("open");
				room.setTotal(300);
				room.setType("multimedia");
				list.add(room);
				room = new MeetingRoom();
				room.setId(4);
				room.setName("nia");
				room.setStatus("open");
				room.setTotal(300);
				room.setType("multimedia");
				list.add(room);
				room = new MeetingRoom();
				room.setId(6);
				room.setName("nimd");
				room.setStatus("close");
				room.setTotal(300);
				room.setType("normal");
				list.add(room);
				request.setAttribute("roomList", list);
				// end of test code
				
				// request.setAttribute("roomList", AdSearchRoomService.getRoomList());
			}
			
			String modify = (String)request.getParameter("modify");
			if(modify != null){
				String roomId = (String)request.getParameter("roomId");
				String name = (String)request.getParameter("name");
				String capacity = (String)request.getParameter("capacity");
				String status = (String)request.getParameter("status");
				
				// test code
				System.out.println("roomId : " + roomId);
				System.out.println("name : " + name);
				System.out.println("capacity : " + capacity);
				System.out.println("status : " + status);
				// end of test code
				
				MeetingRoom room = new MeetingRoom();
				room.setId(Integer.parseInt(roomId));
				room.setName(name);
				room.setTotal(Integer.parseInt(capacity));
				room.setStatus(status);
				
				AdSearchRoomService.modifyRoom(room);
				// @TODO add response to user
			}
			
			String delete = (String)request.getParameter("delete");
			if(delete!=null){
				String[] value = (String[])request.getParameterValues("roomId");
				
				// test code
				for(String str : value)
					System.out.println("room id : " + str);
				// end of test code
				
				AdSearchRoomService.deleteRoom(value);
			}
			
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
		
		request.getRequestDispatcher("./AdSearchRoom.jsp").forward(request, response);
	}

}
