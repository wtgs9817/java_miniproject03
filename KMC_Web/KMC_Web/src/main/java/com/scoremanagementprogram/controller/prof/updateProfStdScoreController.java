package com.scoremanagementprogram.controller.prof;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class updateProfStdScoreController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("stdid");
		String score = request.getParameter("score");
		
		
		SubjectDAO dao = new SubjectDAO();
		SubjectVO vo = new SubjectVO();
		
		
		vo.setId(id);
		vo.setScore(score);
		
		dao.updateProfStdSubject(vo);
		
		return "prof";
	}

}
