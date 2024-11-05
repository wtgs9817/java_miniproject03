package com.scoremanagementprogram.controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class getSubjectListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		SubjectVO vo = new SubjectVO();
		SubjectDAO dao = new SubjectDAO();
		
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
					
		// Null Check
			
		if (searchKeyword == null) {  //사용자가 입력하지 않았을 때 기본값 처리
			searchKeyword = "";
			}
		
		else if(!searchKeyword.isEmpty() ) {
			vo.setId(searchKeyword);
		}
		
		
		
		HttpSession session = request.getSession();
		session.setAttribute("condition", searchCondition);
		session.setAttribute("keyword", searchKeyword);
		
		List<SubjectVO> subjectList = null;
		
		if(vo.getId() != null) {
			subjectList = dao.getStdIdSubject(vo);
		}
		
		else {
			subjectList = dao.getAllSubject();
		}
		
		request.setAttribute("subjectList", subjectList);
		
		
		return "getSubjectList";
		
	}

}
