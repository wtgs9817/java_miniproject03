<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>
<link rel="stylesheet" href="../../../css/index.css" />

 <form action="insertSubject.do" method="POST">
			<h1>학생성적정보입력</h1>
			<br><br>
			<c:if test="${insertError != null}">
			<h3 style="color: red;"> ${insertError}</h3>
			<c:remove var ="insertError" scope="request"></c:remove>
			</c:if>
		
			
            <div class="input-box">
                아이디  <input id="id" type="text" name="id" placeholder="아이디(학번)">
            </div>

            <div class="input-box">
                년도  <input id="year" type="text" name="year" placeholder="년도">
            </div>
            
             <div class="input-box">
                학기  <input id="semester" type="text" name="semester" placeholder="학기">
            </div>
            
             <div class="input-box">
                이수구분  <input id="course" type="text" name="course" placeholder="이수구분">
            </div>
            
             <div class="input-box">
                과목  <input id="subject_name" type="text" name="subject_name" placeholder="과목">
            </div>
            
             <div class="input-box">
                학점  <input id="credit" type="text" name="credit" placeholder="학점">
            </div>
            
             <div class="input-box">
                담당교수  <input id="professor" type="text" name="professor" placeholder="담당교수">
            </div>
            
             <div class="input-box">
                성적  <input id="score" type="text" name="score" placeholder="학점">
            </div>
            
            
			<input type="submit" value="정보입력">
			
			<br><br>
			<center>
				<a href="adminView.do"> 홈으로 </a>
			</center>
			
            
</form>