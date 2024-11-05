package com.scoremanagementprogram.controller.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountVO;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class getStudentListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<SubjectVO> subject = new ArrayList<SubjectVO>();
		SubjectDAO dao = new SubjectDAO();
		
		HttpSession session = request.getSession();
		AccountVO user = (AccountVO) session.getAttribute("user");
		
		subject = dao.getStudentSubject(user);
		
		 
		
		request.setAttribute("subject", subject);	
		
		
		return "studentSubjectList";
	}

}
