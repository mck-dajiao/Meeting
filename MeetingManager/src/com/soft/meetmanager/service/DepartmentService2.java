package com.soft.meetmanager.service;

import java.util.List;

import com.soft.meetmanager.dao.SelectDepartmentDAO;

public class DepartmentService2 {
    public List selectd(){
	 SelectDepartmentDAO room=new SelectDepartmentDAO();
     List list=room.lookingdepartment();
     return list;
}

}
