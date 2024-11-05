package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class insertUserController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		AccountVO vo = new AccountVO();
		AccountDAO dao = new AccountDAO();
		
		String id= request.getParameter("id");
		String password= request.getParameter("password");
		String role = request.getParameter("role");
		String name = request.getParameter("name");
		System.out.println(name);
		
		vo.setId(id);
		vo.setPassword(password);
		vo.setRole(role);
		vo.setName(name);
		
		dao.insertUser(vo);
		
		return "admin";
	}

}
