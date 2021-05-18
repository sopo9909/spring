<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>  
	<head>  
		<title>글 목록</title>  
	</head>
	<center>  
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>  
		<h1>글 목록</h1>  
		<hr width = "100%">
		<table>  
			<thead>  
				<tr>  
					<td>순서</td>
					<td>제목</td>  
					<td>저자</td>  
					<td>내용</td>  
					<td>입력일</td>
				</tr>  
			</thead>  
		<tbody>  
			<c:forEach var="row" items="${data}">  
				<tr>
					<td>${row.d_id }</td>  
					<td>  
						<a href="/detail_d?d_id=${row.d_id}">  
							${row.title}  
						</a>  
					</td>  
					<td>${row.author}</td>  
				    <td>${row.content}</td>
				    <td><fmt:formatDate value="${row.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/> 
						</td>  
				</tr>  
			</c:forEach>  
		</tbody>  
		</table>  
	<p>  
	<button type="button" onclick="location.href='http://localhost:8080/create_d' ">생성</button>  
	</p>  
	</body>
	</center>  
</html>  