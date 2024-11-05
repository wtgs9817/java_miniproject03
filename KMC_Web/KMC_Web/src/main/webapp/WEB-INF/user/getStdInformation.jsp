<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>

<link rel="stylesheet" href="../../../css/index.css" />


 <header>
        	<h2>회원 수정</h2>    
        </header>
		
        <form action="updateStd.do?stdid=${account.id}" method="POST">
			
			
            <div class="input-box">
                <input id="username" type="text" name="id" placeholder="아이디" value="${account.id}">
                
            </div>

            <div class="input-box">
                <input id="password" type="text" name="password" placeholder="비밀번호" value="${account.password}">
            </div>
            
            <div class="input-box">
                <input id="name" type="text" name="name" placeholder="이름" value="${account.name}">
            </div>
            
            <div class="input-box">
                <input id="password" type="text" name="role" placeholder="권한" value="${account.role}">
            </div>
            
            <input type="submit" value="수정">
        </form>
        <center>
	        <br>
	        <a href="deleteUser.do?stdid=${account.id} ">삭제</a>
        </center>
        
        <br>
	<center>
		<a href="adminView.do"> 홈으로 </a>
	</center>			