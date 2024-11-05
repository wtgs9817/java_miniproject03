<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>
<link rel="stylesheet" href="../../../css/index.css" />

<center>
		<h1>${sessionScope.user.name} 교수님 환영합니다.</h1>
	
	<table>
		    <tr>
		        
		        <th bgcolor="orange">학생성적조회</th>
		        <th bgcolor="orange">비밀번호변경</th>		        
		        
		    </tr>
		    <tr>		       
		        <td>
		            <a href="getProfStdList.do">
		                <img src="../image/member_lookup.png" alt="학생성적조회">
		            </a>
		        </td>
		      	<td>
		      		<a href="changePasswordView.do"> <image src="../../../image/changePassword.png"> </image> </a>
		        </td>		       		        
		    </tr>
	</table>

	</center>

   