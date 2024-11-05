package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class updateSubjectController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		
		
		SubjectVO vo = new SubjectVO();
		SubjectDAO dao = new SubjectDAO();
		
		String stdid = request.getParameter("stdid");
		
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String id = request.getParameter("id");
		String course = request.getParameter("course");
		String subjectName = request.getParameter("subjectName");
		String credit = request.getParameter("credit");
		String professor = request.getParameter("professor");
		String score = request.getParameter("score");
		
		
		
		
		vo.setYear(year);
		vo.setSemester(semester);
		vo.setId(id);
		vo.setCourse(course);
		vo.setSubjectName(subjectName);
		vo.setCredit(credit);
		vo.setProfessor(professor);
		vo.setScore(score);
		
		dao.updateSubject(vo, stdid);

		
		return "admin";
	}

}
