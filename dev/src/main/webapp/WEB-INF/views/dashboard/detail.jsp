<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>글 보기</title>
	</head>
	<center>
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
	  <h1>글 보기</h1>
	  <body>
	  	<table border="1">
	  	<th> </th>
	  	<th>글 정보</th>
	  	<tr>
	  		<td>제목</td>
	  		<td>${ data.title }</td>
	  	</tr>
	  	<tr>
	  		<td>저자</td>
	  		<td>${ data.author }</td>
	  	</tr>
	  	<tr>
	  		<td>내용</td>
	  		<td>${ data.content }</td>
	  	</tr>
	  	<tr>
	  		<td>입력일</td>
	  		<td><fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss" /></td>
	  	</tr>
	  	</table>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/update_d?d_id=${d_id}' ">수정</button>
	  </p>
		<form method="POST" action="/delete_d">
			<input type="hidden" name="d_id" value="${d_id}" />
			<input type="submit" value="삭제" />
		</form>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/create_d' ">생성</button>
	  </p>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/list_d' ">목록으로</button>
	  </p>
 </body>
 </center>
</html>