package com.scoremanagementprogram.controller.prof;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountVO;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class getProfStdListController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		
		List<SubjectVO> subject = new ArrayList<SubjectVO>();
		
		SubjectDAO dao = new SubjectDAO();
		SubjectVO vo2 = new SubjectVO();
		
		AccountVO vo = new AccountVO();
		HttpSession session = request.getSession();
		
		String keyword = request.getParameter("searchKeyword");
		String condition = request.getParameter("searchCondition");
		
		//교수 이름 추출
		AccountVO user = (AccountVO) session.getAttribute("user");
		String name = user.getName();
		
		
		 
		if(keyword == null) { //사용자가 입력하지 않았을 때 기본값 처리
			keyword ="";
		}
		
		else if(!keyword.isEmpty()) {
			vo.setName(name);
			vo2.setId(keyword);
			
		}
		
		
		
		
		if(vo.getName() != null) {
			subject = dao.getProfStdIdSubject(vo2, user);
		}
		
		else {
			subject = dao.getAllSubject();
		}
		

		
		request.setAttribute("subjectList", subject);		
		
		return "getProfStdSubjectList";
	}

}
