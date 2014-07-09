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
import com.dajiao.model.Department;
import com.dajiao.service.AdDepartmentService;

/**
 * Servlet implementation class AdDepartmentServlet
 */
@WebServlet("/AdDepartmentServlet")
public class AdDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdDepartmentServlet() {
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
		
//		// test code
//		admin = new Administrator();
//		// end of test code
		
		if(admin != null){
			String newDep = (String)request.getParameter("new");
			if(newDep!=null){
				String newId = (String)request.getParameter("departmentId");
				String newName = (String)request.getParameter("name");
				
				// test code
				System.out.println("new id :" + newId);
				System.out.println("new Name :" + newName);
				// end of test code
				
				if(AdDepartmentService.newDepartment(Integer.parseInt(newId), newName)==true)
					System.out.println("new Department :" + newName);
				// @TODO 添加用户通知
			}
			
			String delete = (String)request.getParameter("delete");
			if(delete!=null){
				String[] value = (String[])request.getParameterValues("departmentId");
				
				// test code
				for(String str : value)
					System.out.println("department id:" + str);
				// end of test code
				
				if(AdDepartmentService.deleteDepartment(value)==true)
					System.out.println("delete success");
			}
			
			
			
//			// test code 
//			List<Department> list = new ArrayList<Department>();
//			Department department = new Department();
//			department.setId(12);
//			department.setName("dada");
//			list.add(department);
//			department = new Department();
//			department.setId(13);
//			department.setName("daadsa");
//			list.add(department);
//			department = new Department();
//			department.setId(14);
//			department.setName("dads");
//			list.add(department);
//			request.setAttribute("departmentList", list);
//			// end of test code
			
			request.setAttribute("departmentList", AdDepartmentService.getDepartmentList());
			request.getRequestDispatcher("./AdDepartment.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("./meetingManager.jsp").forward(request, response);
		}
		
		
	}

}
