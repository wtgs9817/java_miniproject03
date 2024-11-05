package com.scoremanagementprogram.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class changePasswordController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
				AccountVO vo = new AccountVO();
				AccountDAO dao = new AccountDAO();
				HttpSession session = request.getSession();
				
				AccountVO user = (AccountVO) session.getAttribute("user");
				
				String id = request.getParameter("id");
				String password = request.getParameter("password");
				
				vo.setId(id);
				vo.setPassword(password);
				
				dao.changePassword(vo);
				
				if(user.getRole().equals("PROF")) {
					return "profView.do";
				}
				else {
					return "stdView.do";
				}
	}

}
