<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="../../../css/index.css" />
    <header>
        	<h2>비밀번호 변경</h2>    
       </header>
		
        <form action="changePassword.do" method="POST">			
			
            <div class="input-box">
                아이디  <input id="username" type="text" name="id" placeholder="아이디" value="${sessionScope.user.id}" readonly>               
            </div>
            
            <div class="input-box">
                비밀번호  <input id="password" type="password" name="password" placeholder="비밀번호" value="${sessionScope.user.password}">
            </div>
                        
            <input type="submit" value="비밀번호 변경">
	
        </form>
     
        <br>      
        <center>
        
        	<c:if test="${fn:trim(sessionScope.user.role) eq fn:trim('STD')}">  <!-- 권한이 학생일 때 -->
    			<a href="stdView.do"> 홈으로 </a>
			</c:if>
			
			<c:if test="${fn:trim(user.role) eq fn:trim('PROF')}">   <!-- 권한이 교수일 때 -->
    			<a href="profView.do"> 홈으로 </a>
			</c:if>
		</center>