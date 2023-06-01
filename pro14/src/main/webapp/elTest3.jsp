<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>비교 연산자 </title>
	</head>
	<body>
		<h1>여러가지 비교연산자</h1>
		<h1>
			\${10==10}:${10==10}<br>
			\${'hello'=='hello'}:${"hello"=='hello'}<br>
			\${20!=10}:${20!=10}<br>
			\${'hello'!='apple'}:${'hello'!='apple'}<br>
			\${10<10}:${10<10}<br>
			\${100>10}:${100>10}<br>
			\${100<=10}:${100<=10}<br>
			\${100>=10}:${100>=10}<br>
		</h1>
	</body>
</html>