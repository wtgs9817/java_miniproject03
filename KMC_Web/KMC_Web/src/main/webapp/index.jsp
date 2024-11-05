<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../WEB-INF/layout/header.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, height=device-height, minimum-scale=1.0, maximum-scale=1.0, initial-scale=1.0">
        <link rel="stylesheet" href="../../css/index.css" />
    </head>
    <body>
        

<c:if test="${sessionScope.user == null}"> 	 	
        <header>
        	<h2>성적관리프로그램</h2>    
        </header>
		
        <form action="login.do" method="POST">
			<h2>로그인</h2>
			
            <div class="input-box">
                <input id="username" type="text" name="id" placeholder="아이디">    
            </div>
			
            <div class="input-box">
                <input id="password" type="password" name="password" placeholder="비밀번호">
            </div>
            
            <input type="submit" value="로그인">
        </form>
</c:if>

<c:if test="${sessionScope.user != null}">
	

</c:if> 	 	
<!--  
<script>
	var loginError = ${sessionScope.loginError};
	<c:remove var ="loginError"/>
</script>
<script src="../../js/loginCheck.js"></script>

예외처리 일단 보류 자바스크립트 공부 해야할듯
	-->
</body>
</html>