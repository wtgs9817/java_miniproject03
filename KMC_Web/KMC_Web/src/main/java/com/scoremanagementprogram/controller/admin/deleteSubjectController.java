package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class deleteSubjectController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SubjectDAO dao = new SubjectDAO();
		SubjectVO vo = new SubjectVO();
		
		
		
		
		String id = request.getParameter("stdid");
		String subject_Name = request.getParameter("subjectName");
		vo.setId(id);
		vo.setSubjectName(subject_Name);
		
		dao.deleteSubject(vo);
		

		return "admin";
	}

}
