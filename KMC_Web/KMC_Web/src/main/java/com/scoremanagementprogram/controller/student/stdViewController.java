package com.scoremanagementprogram.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;

public class stdViewController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("학생 화면으로 이동");
		
		
		
		return "student";
	}

}
