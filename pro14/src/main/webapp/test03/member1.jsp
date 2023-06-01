<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("utf-8"); %>
    <%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
	<c:set var="id" value="hong" scope="page"/>
	<c:set var="pwd" value="1234" scope="page"/>
	<c:set var="name" value="홍길동" scope="page"/>
	<c:set var="age" value="${22}" scope="page"/>
	<c:set var="height" value="${177}" scope="page"/>
	
<html>
	<head>
		<style>
		.as{
		margin:auto;
		text-align: center;
		}
		</style>
		<meta charset="UTF-8">
		<title>회원 정보 출력창</title>
	</head>
	<body>
		<table class='as' border='1'>
			<tr style='margin: auto' bgcolor='lightgreen'>
				<td width=7%><B>아아디</B></td>
				<td width=7%><B>비밀번호</B></td>
				<td width=7%><B>이름</B></td>
				<td width=7%><B>나이</B></td>
				<td width=7%><B>키</B></td>
			</tr>
			<tr class='as'>
				<td>${id}</td>
				<td>${pwd}</td>
				<td>${name}</td>
				<td>${age}</td>
				<td>${height}</td>
			</tr>
		</table>
	</body>
</html>