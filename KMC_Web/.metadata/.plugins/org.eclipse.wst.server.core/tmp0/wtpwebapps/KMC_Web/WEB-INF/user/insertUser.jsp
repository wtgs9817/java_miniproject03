<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../WEB-INF/layout/header.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../../css/index.css" />
</head>
<body>
	<header>
        	<h2>회원정보 입력</h2>    
        </header>
		
        <form action="insertUser.do" method="POST">

            <div class="input-box">
                아이디  <input id="username" type="text" name="id" placeholder="아이디">
                
            </div>

            <div class="input-box">
                비밀번호  <input id="password" type="password" name="password" placeholder="비밀번호">
            </div>
            
             <div class="input-box">
                이름  <input id="name" type="text" name="name" placeholder="이름">
            </div>
 
			<div > 권한
				<input type="radio" name="role" value="ADMIN">관리자
				<input type="radio" name="role" value="PROF">교수
				<input type="radio" name="role" value="STD">학생						
			</div>
			
			<input type="submit" value="회원등록">
        </form>
        
        <br>
        <center>
        	<a href="adminView.do"> 홈으로 </a>
		</center>
</body>
</html>