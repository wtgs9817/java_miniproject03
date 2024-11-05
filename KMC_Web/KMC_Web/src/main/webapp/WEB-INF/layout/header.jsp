<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<c:if test="${sessionScope.user != null}"> 
	<a href="logout.do">로그아웃</a>&nbsp;&nbsp;&nbsp;
</c:if>
<hr>
<br>