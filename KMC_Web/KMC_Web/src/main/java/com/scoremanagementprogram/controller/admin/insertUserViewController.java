package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;

public class insertUserViewController implements Controller {

	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("회원가입 페이지 이동");
		
		return "insertUser";
	}

	
}
