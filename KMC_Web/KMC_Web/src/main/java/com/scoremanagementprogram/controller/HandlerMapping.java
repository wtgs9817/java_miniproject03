package com.scoremanagementprogram.controller;

import java.util.HashMap;






import java.util.Map;

import com.scoremanagementprogram.controller.admin.adminViewController;
import com.scoremanagementprogram.controller.admin.deleteSubjectController;
import com.scoremanagementprogram.controller.admin.deleteUserController;
import com.scoremanagementprogram.controller.admin.getStdInformationController;
import com.scoremanagementprogram.controller.admin.getStdInformationListController;
import com.scoremanagementprogram.controller.admin.getSubjectController;
import com.scoremanagementprogram.controller.admin.getSubjectListController;
import com.scoremanagementprogram.controller.admin.insertUserController;
import com.scoremanagementprogram.controller.admin.insertUserViewController;
import com.scoremanagementprogram.controller.admin.updateStdController;
import com.scoremanagementprogram.controller.admin.updateSubjectController;
import com.scoremanagementprogram.controller.common.changePasswordController;
import com.scoremanagementprogram.controller.common.changePasswordViewController;
import com.scoremanagementprogram.controller.admin.insertSubjectController;
import com.scoremanagementprogram.controller.admin.insertSubjectViewController;
import com.scoremanagementprogram.controller.common.loginController;
import com.scoremanagementprogram.controller.common.logoutController;
import com.scoremanagementprogram.controller.prof.getProfStdController;
import com.scoremanagementprogram.controller.prof.getProfStdListController;
import com.scoremanagementprogram.controller.prof.profViewController;
import com.scoremanagementprogram.controller.prof.updateProfStdScoreController;
import com.scoremanagementprogram.controller.student.getStudentListController;
import com.scoremanagementprogram.controller.student.stdViewController;

public class HandlerMapping {

	private Map<String, Controller> mappings; // 요청,요청을 처리하는 컨트롤러
	
	public HandlerMapping() {
		
		mappings = new HashMap<String, Controller>();
		
		//요청과 요청에 맞는 컨트롤러를 맵에 추가
		
		//로그인
		mappings.put("/login.do", new loginController());
		
		//로그아웃
		mappings.put("/logout.do", new logoutController());
		
		//관리자 페이지
		mappings.put("/adminView.do", new adminViewController());
		
		//학생 페이지
		mappings.put("/stdView.do", new stdViewController());
		
		//관리자 전용 회원추가
		mappings.put("/insertUserView.do", new insertUserViewController());
		mappings.put("/insertUser.do", new insertUserController());
		
		//관리자 전용 학생조회
		mappings.put("/getSubjectList.do", new getSubjectListController());
		mappings.put("/getSubject.do", new getSubjectController());
		
		mappings.put("/getStdInformationList.do", new getStdInformationListController());
		mappings.put("/getStdInformation.do", new getStdInformationController());		
		
		//관리자 전용 성적정보 추가 
		mappings.put("/insertSubject.do", new insertSubjectController());
		mappings.put("/insertSubjectView.do", new insertSubjectViewController());
		
		//관리자 전용 회원정보 수정 + 삭제
		mappings.put("/updateStd.do", new updateStdController());
		mappings.put("/deleteUser.do", new deleteUserController());
		
		//관리자 전용 회원성적 삭제
		mappings.put("/deleteSubject.do", new deleteSubjectController());
		
		//관리자 전용 성적 정보 수정
		mappings.put("/updateSubject.do", new updateSubjectController());
		
		
		//교수 페이지 이동
		mappings.put("/profView.do", new profViewController());
		
		//교수전용 학생성적 조회
		mappings.put("/getProfStdList.do", new getProfStdListController());
		mappings.put("/getProfStd.do", new getProfStdController());
		
		//교수전용 학생성적 수정
		mappings.put("/updateProfStdScore.do" , new updateProfStdScoreController());
		
		
		//학생 성적 조회 페이지
		mappings.put("/getStudentList.do", new getStudentListController());
		
		
		//교수 + 학생 비밀번호 변경
		mappings.put("/changePasswordView.do", new changePasswordViewController());
		mappings.put("/changePassword.do", new changePasswordController());
				
	}

	public Controller getController(String path) {
		// TODO Auto-generated method stub
			return mappings.get(path);
	}
}
