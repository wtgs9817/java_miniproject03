package com.scoremanagementprogram.controller.prof;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class getProfStdController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String subjectName = request.getParameter("subject_name");
		
		SubjectVO vo = new SubjectVO();
		SubjectDAO dao = new SubjectDAO();
		
		vo.setId(id);
		vo.setSubjectName(subjectName);
		
		SubjectVO subject = dao.getSubject(vo);
		
		request.setAttribute("subject", subject);
		
	
		return "getProfStdSubject";
	}

}
