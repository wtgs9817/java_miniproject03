<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../../WEB-INF/layout/header.jsp"%>

<link rel="stylesheet" href="../../../css/index.css" />

<center>
	<br>
	
	
	<form action="updateProfStdScore.do?stdid=${subject.id} " method="post">
	
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
			 	<!-- list 명 수정하고 getUser컨트롤러 request.setattribute 해야함. -->
			   <tr>
			       <td> <input type="text" name="year" value="${subject.year}" readonly> </input> </td> <!-- 년도 -->
			       <td> <input type="text" name="semester" value="${subject.semester}" readonly> </input> </td> <!-- 학기 -->		  
			       <td> <input type="text" name="id" value="${subject.id}" readonly>  </td> </a> <!-- 학번 -->
			       <td> <input type="text" name="course" value="${subject.course}" readonly > </td> <!-- 이수구분 -->
			       <td> <input type="text" name="subjectName" value="${subject.subjectName}" readonly > </td> <!-- 과목 -->
			       <td>  <input type="text" name="credit" value="${subject.credit}" readonly > </td> <!-- 학점 -->
			       <td>  <input type="text" name="professor" value=" ${subject.professor}" readonly></td> <!-- 담당교수 -->
			       <td> <input type="text" name="score" value=" ${subject.score}" > </td> <!-- 학점 -->
			   </tr>
		</table>
			
		<br>
		<input type="submit" value="수정"> </input>

		<br>
		<br>
		<a href="adminView.do"> 홈으로 </a>
	</form>
</center>