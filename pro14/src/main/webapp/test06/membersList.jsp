<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.*"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%@ taglib prefix="fmt" uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@ taglib prefix="c" uri='http://java.sun.com/jsp/jstl/core'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.as {
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<table style='text-align: center; margin: auto'>
		<tr style='margin: auto' bgcolor='lightgreen'>
			<td width=7%><B>아아디</B></td>
			<td width=7%><B>비밀번호</B></td>
			<td width=7%><B>이름</B></td>
			<td width=7%><B>이메일</B></td>
			<td width=7%><B>가입일</B></td>
		</tr>
		<c:choose>
			<c:when test='${membersList==null}'>
				<tr>
					<td colspan=5><b>등록된 회원이 없습니다</b></td>
				</tr>
			</c:when>
			<c:when test='${membersList!=null}'>
				<c:forEach var="mem" items="${membersList}">
					<tr class='as'>
						<td>${mem.id}</td>
						<td>${mem.pwd}</td>
						<td>${mem.name}</td>
						<td>${mem.email}</td>
						<td>${mem.joinDate}</td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
</body>
</html>