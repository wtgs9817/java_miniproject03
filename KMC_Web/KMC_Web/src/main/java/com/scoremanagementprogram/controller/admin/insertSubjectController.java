package com.scoremanagementprogram.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.subject.SubjectDAO;
import com.scoremanagementprogram.dbutil.subject.SubjectVO;

public class insertSubjectController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SubjectVO vo = new SubjectVO();
		SubjectDAO dao = new SubjectDAO();
		
		//insertSubjectController 클래스
		//jsp에서 입력한 정보 추출
		String id = request.getParameter("id");
		String year = request.getParameter("year");
		String semester = request.getParameter("semester");
		String course = request.getParameter("course");
		String subjectName = request.getParameter("subject_name");
		String credit = request.getParameter("credit");
		String professor = request.getParameter("professor");
		String score = request.getParameter("score");
		
		vo.setId(id);
		vo.setYear(year);
		vo.setSemester(semester);
		vo.setCourse(course);
		vo.setSubjectName(subjectName);
		vo.setCredit(credit);
		vo.setProfessor(professor);
		vo.setScore(score);
		
		SubjectVO vo2 = new SubjectVO();
		vo2.setId(id);
		vo2.setSubjectName(subjectName);
		vo2.setSemester(semester);
		vo2.setYear(year);
		
		int num = dao.getCountStdCredit(vo2); //추가하려는 학번의 학생이 수강하고 있는 학점
		int flag = dao.getSubjectName(vo2); //중복된 수업추가에 대한 예외처리 메소드		
		
		String num2 = credit.trim();
		
		int num3 = Integer.parseInt(num2);
		
		
		if((num + num3) <= 18 && flag == -1) {  //수강학점을 초과하지 않고 수업이 중복되지 않을 때
			dao.insertSubject(vo);
			System.out.println("성적정보 입력 성공");
			return "admin";
		}
		
		else if((num + num3) > 18){ //수강학점을 초과할 때
			request.setAttribute("insertError", vo.getId() +"학생의 수강학점이 18점을 초과했습니다.");
			return "insertSubjectView.do";
		}
		
		else { //중복될 때
			request.setAttribute("insertError", vo.getSubjectName() + "은 기존에 수강했거나 수강중인 수업입니다.");
			return "insertSubjectView.do";
		}
	}

}
