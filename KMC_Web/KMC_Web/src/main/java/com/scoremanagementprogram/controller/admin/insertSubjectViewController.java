package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;

public class insertSubjectViewController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("성적정보 추가 화면으로 이동");
		
		
		return "insertSubject";
	}

}
