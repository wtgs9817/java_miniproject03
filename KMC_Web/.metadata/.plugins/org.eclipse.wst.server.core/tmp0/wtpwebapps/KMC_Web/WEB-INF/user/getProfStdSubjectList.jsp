<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ include file="../../WEB-INF/layout/header.jsp"%>


<center>
		<h1>전체학생정보</h1>
		
		<form action ="/getSubjectList.do" method="post" >
			<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<td align="right">				
				<select name="searchCondition">
					<option value="stdId" <c:if test="${condition == '학번'}"> selected</c:if>>학번
					
				</select>						
					
					<input name="searchKeyword" type="text" value="${keyword}"/>
					<input type="submit" value="검색"/>
				</td>
			</tr>
			</table>
		</form>	

		
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
		    
		    
		<c:forEach var="list" items="${subjectList}">		
			<!-- fn:trim 으로 공백제거 하고 문자열 비교해야함. -->			
			<c:if test="${fn:trim(list.professor) eq fn:trim(sessionScope.user.name)}">
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
			</c:if>
		</c:forEach>

		</table>	
		
		<br>
		
		<a href="profView.do"> 홈으로 </a>
				
	</center>