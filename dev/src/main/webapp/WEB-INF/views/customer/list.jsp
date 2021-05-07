<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>  
	<head>  
		<title>회원 목록</title>  
	</head>  
	<body>  
		<h1>회원 목록</h1>  
		<table>  
			<thead>  
				<tr>  
					<td>이름</td>  
					<td>나이</td>  
					<td>주소</td>  
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
				    <td>${row.insert_date}</td>  
				</tr>  
			</c:forEach>  
		</tbody>  
		</table>  
	<p>  
		<a href="/create">생성</a>  
	</p>  
	</body>  
</html>  