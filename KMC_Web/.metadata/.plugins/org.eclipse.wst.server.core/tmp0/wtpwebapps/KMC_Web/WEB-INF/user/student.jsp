<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>    
    

<link rel="stylesheet" href="../../../css/index.css" />

	<center>
		<h1> ${sessionScope.user.name} 학생 환영합니다. </h1>
		
	<table>
		    <tr>
		        
		        <th bgcolor="orange">수강내역조회</th>
		        <th bgcolor="orange">비밀번호변경</th>
		        
		        
		    </tr>
		    <tr>
		       
		        <td>
		            <a href="getStudentList.do">
		                <img src="../image/stdCourse.png" alt="학생성적조회">
		            </a>
		        </td>
		      	<td>
		      		<a href="changePasswordView.do"> <image src="../../../image/changePassword.png" alt="비밀번호 변경"> </image> </a>
		        </td>
		        
		        
		    </tr>
	</table>	
			
	
	</center>
