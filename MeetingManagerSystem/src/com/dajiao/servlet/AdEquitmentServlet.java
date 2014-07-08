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

import com.dajiao.model.Administrator;
import com.dajiao.model.Borrow;
import com.dajiao.service.AdEquitmentService;

/**
 * Servlet implementation class AdEquitmentServlet
 */
@WebServlet("/AdEquitmentServlet")
public class AdEquitmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdEquitmentServlet() {
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
		
		if(admin != null){
			
			String change = (String)request.getParameter("change");
			if(change!=null){
				String id = (String)request.getParameter("id");
				
				System.out.println("id " + id);
				
				AdEquitmentService.changeStatus(id);
				// @TODO add some response
				
			}
			
			// test code
			List<Borrow> list = new ArrayList<Borrow>();
			Borrow borrow = new Borrow();
			borrow.setId(12);
			borrow.setStatus("borrowing");
			borrow.setaNum(21);
			borrow.setbNum(8);
			borrow.setcNum(3);
			borrow.setDate(Timestamp.valueOf("2014-04-30 23:12:31"));
			borrow.setBorrower("nimei");
			list.add(borrow);
			borrow = new Borrow();
			borrow.setId(12);
			borrow.setStatus("borrowed");
			borrow.setaNum(2);
			borrow.setbNum(6);
			borrow.setcNum(12);
			borrow.setDate(Timestamp.valueOf("2014-06-30 23:13:31"));
			borrow.setBorrower("nige");
			list.add(borrow);
			borrow = new Borrow();
			borrow.setId(12);
			borrow.setStatus("borrowing");
			borrow.setaNum(1);
			borrow.setbNum(8);
			borrow.setcNum(87);
			borrow.setDate(Timestamp.valueOf("2014-05-30 03:12:31"));
			borrow.setBorrower("tamei");
			list.add(borrow);
			request.setAttribute("borrowList", list);
			
			// request.setAttribute("borrowList", AdEquitmentService.getBorrowList());
			
			
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
		request.getRequestDispatcher("./AdEquitment.jsp").forward(request, response);
	}

}
