<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <% request.setCharacterEncoding("utf-8"); %>
    <%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
    <c:set var="con" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인 창</title>
	</head>
	<body>
		<form action='result.jsp'>
			아이디:<input type='text' size=20 ><br>
			비밀번호:<input type='password' size=20>
			<input type='submit' value='로그인'>
			<input type='reset' value='다시입력'>
		</form>
		<br><br>
		<a href="${con}/test01/memberForm.jsp">회원가입하기</a>
	</body>
</html>