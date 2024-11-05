package com.scoremanagementprogram.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class getStdInformationListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		List<AccountVO> list = new ArrayList<AccountVO>();
		AccountDAO dao = new AccountDAO();
		
		list = dao.getAllUser();
		
		
		request.setAttribute("list", list );
		System.out.println("학생 정보 페이지 이동");
		
		
		return "getStdInformationList";
		
	}

}
