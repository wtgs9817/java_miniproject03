<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>
<link rel="stylesheet" href="../../../css/index.css" />
<title>Insert title here</title>


<center>
	
		<h1>전체학생정보</h1>
		<table border="1" cellpadding="0" cellspacing="0" width="700">
		    <tr>
		        <th bgcolor="orange" width="200">아이디(학번)</th>	
		        <th bgcolor="orange" width="200">비밀번호</th>		      
		        <th bgcolor="orange" width="100">이름</th>	        
		        <th bgcolor="orange" width="100">권한</th>
		        
		    </tr>

		<c:forEach var="list" items="${list}">
		   <tr>
		       <td><a href="getStdInformation.do?id=${list.id} ">${list.id} </a> </td> <!-- 아이디(학번) -->
		       <td>${list.password}</td> <!-- 비밀번호 -->
		       <td> ${list.name} </td> <!-- 이름 -->		  		       
		       <td>${list.role}</td> <!-- 권한 -->
		   </tr>
		</c:forEach>

		</table>	
		
		<br>
		
		<a href="adminView.do"> 홈으로 </a>
				
	</center>
