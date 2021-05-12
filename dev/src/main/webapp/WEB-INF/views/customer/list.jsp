<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>  
	<head>  
		<title>회원 목록</title>  
	</head>
	<center>  
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>  
		<h1>회원 목록</h1>  
		<table>  
			<thead>  
				<tr>  
					<td>이름</td>  
					<td>나이</td>  
					<td>주소</td>  
					<td>입력일</td>
				</tr>  
			</thead>  
		<tbody>  
			<c:forEach var="row" items="${data}">  
				<tr>  
					<td>  
						<a href="/detail?id=${row.id}">  
							${row.name}  
						</a>  
					</td>  
					<td>${row.age}</td>  
				    <td>${row.adress}</td>
				    <td><fmt:formatDate value="${row.insert_date}" pattern="yyyy.MM.dd HH:mm:ss"/> 
						</td>  
				</tr>  
			</c:forEach>  
		</tbody>  
		</table>  
	<p>  
		<a href="/create">생성</a>  
	</p>  
	</body>
	</center>  
</html>  