<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.List,com.dajiao.model.Borrow"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<%@include file="header.jsp" %>
<%@include file="adminNavbar.html" %>
<%@include file="header2.jsp" %>

<body onload="navload(5);">


	<div class="container jumbotron">
				
        <table class="table text-center">
            <thead>
                <tr>
                    <th class="text-center">编号</th>
					<th class="text-center">借出者</th>
					<th class="text-center">借出日期</th>
                    <th class="text-center">设备A</th>
					<th class="text-center">设备B</th>
					<th class="text-center">设备C</th>
                    <th class="text-center">操作</th>
                </tr>
            </thead>
            <tbody>
            <%
            	List<Borrow> borrowList = (List<Borrow>)request.getAttribute("borrowList");
            	if(borrowList != null){
            		for(int i = 0; i<borrowList.size(); i++){
            			Borrow borrow = borrowList.get(i);
            %>
                <tr>
                    <td><%=borrow.getId() %></td>
                    <td><%=borrow.getBorrower() %></td>
					<td><%=borrow.getDate().toString().split(" ")[0] %></td>
					<td><%=borrow.getaNum() %></td>
					<td><%=borrow.getbNum() %></td>
					<td><%=borrow.getcNum() %></td>
                    <td class="text-center">
                        <%
                        	if(borrow.getStatus().equals("borrowing")){
                        %>
                         <a href="AdEquitmentServlet?change=1&&id=<%=borrow.getId() %>" class="btn btn-default" >
                    	   	 同意</a>
                        <%		
                        	}else if(borrow.getStatus().equals("borrowed")){
                        %>
                         <a href="AdEquitmentServlet?change=1&&id=<%=borrow.getId() %>" href="#" class="btn btn-default" >
                        	归还  </a>
                        <%
                        	}
                        %>
                    </td>
                </tr>
             <%
            		}
            	}
            %>
            </tbody>
        </table>
	</div>
</main>

	
<%@include file="footer.html" %>
<script type="text/javascript">
titleLoad("设备管理");

</script>

</body>
</html>