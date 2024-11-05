<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>
<title>admin page</title>
<link rel="stylesheet" href="../../../css/index.css" />

	
	<center>
		<h1>${sessionScope.user.name} 님 환영합니다.</h1>
	
	<table>
		    <tr>
		        <th bgcolor="orange">회원등록</th>
		        <th bgcolor="orange">학생성적조회</th>
		        <th bgcolor="orange">회원정보조회</th>
		        <th bgcolor="orange">학생성적정보추가</th>
		        
		    </tr>
		    <tr>
		        <td>
		            <a href="insertUserView.do">
		                <img src="../image/member_registration.png" alt="회원등록">
		            </a>
		        </td>
		        <td>
		            <a href="getSubjectList.do">
		                <img src="../image/member_lookup.png" alt="회원성적조회">
		            </a>
		        </td>
		        <td>
		            <a href="getStdInformationList.do">
		                <img src="../image/stdInformationSearch.png" alt="회원정보조회">
		            </a>
		        </td>
		        
		        <td>
		            <a href="insertSubjectView.do">
		                <img src="../image/addSubject.png" alt="회원정보조회">
		            </a>
		        </td>
		        
		    </tr>
	</table>

	</center>
	
	
	
	


