<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
	<head>
		<title>카운트 구현</title>
	</head>
	<center>
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
	  <h1>카운트 구현</h1>
	  <body>
	  		<table>  
			<thead>  
				<tr>  
					<td>순서</td>
					<td>이름</td>  
					<td>나이</td>  
					<td>주소</td>  
					<td>입력일</td>
				</tr>  
			</thead>  
		
		<div >
		<form>
		    <select id="pageUnit" name="pageUnit" onchange="this.form.submit();" >
		        <option value="10" selected="selected">== 선택 ==</option>
		        <option value="10">10개씩 보기</option>
		        <option value="20">20개씩 보기</option>
		        <option value="30">30개씩 보기</option>
		    </select>
		   </form>
		</div>
		
		<tbody>  
			<c:forEach var="row" items="${list}">  
				<tr>
					<td>${row.id }</td>  
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
	<div>
		<c:if test="${prev}">
			 <span>[ <a href="/listPage?num=${startPageNum - 1}">이전</a> ]</span>
		</c:if>
			
		<c:forEach begin="${startPageNum}" end="${endPageNum}" var="num">
			<span>
				 <c:if test="${select != num}">
   					<a href="/listPage?num=${num}">${num}</a>
  				 </c:if>  
			     <c:if test="${select == num}">
   					<b>${num}</b>
  				 </c:if>
			</span>
		</c:forEach>
		<c:if test="${next}">
			<span>[<a href="/listPage?num=${endPageNum + 1}">다음</a> ]</span>
		</c:if>
	</div>
	  <p>
	  <button type="button" onclick="location.href='http://localhost:8080/list' ">목록으로</button>
	  </p>
 </body>
 </center>
</html>