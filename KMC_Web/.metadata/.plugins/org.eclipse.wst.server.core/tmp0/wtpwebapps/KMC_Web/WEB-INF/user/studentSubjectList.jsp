<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>


    
<center>
		<h1>수강내역</h1>
		
		
		
		
		<table border="1" cellpadding="0" cellspacing="0" width="700">
		    <tr>
		        <th bgcolor="orange" width="100">년도</th>
		        <th bgcolor="orange" width="100">학기</th>		      
		        <th bgcolor="orange" width="200">학번</th>
		        <th bgcolor="orange" width="150">이수구분</th>
		        <th bgcolor="orange" width="200">과목</th>
		        <th bgcolor="orange" width="100">학점</th>
		        <th bgcolor="orange" width="100">담당교수</th>
		        <th bgcolor="orange" width="100">학점</th>
		    </tr>
		    
		    
<!-- 리스트 불러오는 도중에 에러가 생김 확인 해야할듯 -->
		<c:forEach var="list" items="${subject}">		
			<tr>
			    <td>${list.year}</td> <!-- 년도 -->
			    <td> ${list.semester} </td> <!-- 학기 -->		  
			    <td> <a href="getProfStd.do?id=${list.id}&subject_name=${list.subjectName}"> ${list.id} </td> </a> <!-- 학번 -->
			    <td>${list.course}</td> <!-- 이수구분 -->
			    <td>${list.subjectName}</td> <!-- 과목 -->
			    <td>${list.credit}</td> <!-- 학점 -->
			    <td>${list.professor}</td> <!-- 담당교수 -->
			    <td>${list.score}</td> <!-- 학점 -->
			</tr>			
			
			  
			
		</c:forEach>

		</table>	
		
		<br>
		
		<a href="stdView.do"> 홈으로 </a>
				
	</center>