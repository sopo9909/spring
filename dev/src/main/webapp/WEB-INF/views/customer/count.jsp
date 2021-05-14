<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>카운트 구현</title>
	</head>
	<center>
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
	  <h1>고객 카운트</h1>
	  <body>
	  	<table border="1">
	  	<th> </th>
	  	<th>상세정보</th>
	  	<tr>
	  		<td>전체</td>
	  		<td>${ tata.tot}</td>
	  	</tr>
	  <button type="button" onclick="location.href='http://localhost:8080/list' ">목록으로</button>
	  </p>
 </body>
 </center>
</html>