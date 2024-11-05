package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class deleteUserController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		AccountVO vo = new AccountVO();
		AccountDAO dao = new AccountDAO();
		
		
		String id = request.getParameter("stdid");
		vo.setId(id);
		
		dao.deleteUser(vo);

		return "admin";
	}

}
