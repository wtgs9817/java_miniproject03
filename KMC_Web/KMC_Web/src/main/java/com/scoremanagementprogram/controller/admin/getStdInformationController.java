package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class getStdInformationController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		
		AccountVO vo = new AccountVO();
		AccountDAO dao = new AccountDAO();

		vo.setId(id);
		
		AccountVO account = new AccountVO();
		
		account = dao.getUser(vo);
		
		request.setAttribute("account", account);
		
		return "getStdInformation";
	}

}
