package com.scoremanagementprogram.controller.common;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.scoremanagementprogram.controller.Controller;
import com.scoremanagementprogram.dbutil.account.AccountDAO;
import com.scoremanagementprogram.dbutil.account.AccountVO;

public class loginController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");  //아이디 입력값 가져오기
		String password = request.getParameter("password"); //비밀번호 입력값 가져오기
		
		AccountVO vo = new AccountVO();
		AccountDAO dao = new AccountDAO();
		HttpSession session = request.getSession();
		
		//로그인 창에서 입력받은 아이디를 vo 객체의 아이디 값에 넣음
		vo.setId(id);
		
		
		//db에서 입력받은 id가 있으면 user에 아이디 비밀번호 권한 값이 들어가고 아니면 user는 null
		AccountVO user = dao.getUser(vo);
		System.out.println(user.getPassword());
		
		
		//입력한 아이디가 db에 있고 입력한 아이디에 대한 비밀번호가 일치할 때
		if(user != null && user.getPassword() != null && user.getPassword().equals(password)) {
			session.setAttribute("user", user); //회원정보를 세션에 등록
			
			if(user.getRole().equals("ADMIN")) { // 회원의 권한이 관리자일 때
				return "/adminView.do"; //관리자 페이지로 이동
			}
			else if(user.getRole().equals("PROF")) { //회원의 권한이 교수일 때
				return "/profView.do"; //교수 페이지로 이동
			}
			else { //관리자 또는 교수가 아닐 때 (학생일 때)
				return "/stdView.do"; //학생 페이지로 이동
			}
			
		}
		else {
			return "index";
		}
	}

}
