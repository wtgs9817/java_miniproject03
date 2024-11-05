package com.scoremanagementprogram.controller.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;

public class changePasswordViewController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("비밀번호 변경 페이지로 이동");
		
		
		
		
		return "changePassword";
	}

}
