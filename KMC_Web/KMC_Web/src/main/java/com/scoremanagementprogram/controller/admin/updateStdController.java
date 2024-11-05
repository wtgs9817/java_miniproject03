package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class updateStdController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");

		String stdid = request.getParameter("stdid");
		
		AccountVO vo = new AccountVO();
		
		vo.setId(id);
		vo.setName(name);
		vo.setPassword(password);
		vo.setRole(role);
		
		
		
		AccountDAO dao = new AccountDAO();
		
		dao.updateUser(vo, stdid);
		
		return "admin";
	}

}
