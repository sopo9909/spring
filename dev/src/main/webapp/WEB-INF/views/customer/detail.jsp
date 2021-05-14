<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>고객 상세</title>
	</head>
	<center>
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
	  <h1>고객 상세</h1>
	  <body>
	  	<table border="1">
	  	<th> </th>
	  	<th>상세정보</th>
	  	<tr>
	  		<td>이름</td>
	  		<td>${ data.name }</td>
	  	</tr>
	  	<tr>
	  		<td>나이</td>
	  		<td>${ data.age }</td>
	  	</tr>
	  	<tr>
	  		<td>주소</td>
	  		<td>${ data.adress }</td>
	  	</tr>
	  	<tr>
	  		<td>입력일</td>
	  		<td><fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss" /></td>
	  	</tr>
	  	</table>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/update?id=${id}' ">수정</button>
	  </p>
		<form method="POST" action="/delete">
			<input type="hidden" name="id" value="${id}" />
			<input type="submit" value="삭제" />
		</form>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/create' ">생성</button>
	  </p>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/list' ">목록으로</button>
	  </p>
 </body>
 </center>
</html>