<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  


<script>//자바스크립트로 만든 부분
	function timeBefore(){
		 //현재시간
		 var now = new Date(); 
		 //시작시간 
		 var writeDay = new Date('Mon May 10 2021 16:01:17 GMT+0900');
		 var minus;
		 var time = '';
		 if(now.getFullYear() > writeDay.getFullYear()){
		    minus= now.getFullYear()-writeDay.getFullYear();
		    time += minus+"년 ";
		 }
		 if(now.getMonth() > writeDay.getMonth()){
		    minus= now.getMonth()-writeDay.getMonth();
		    time += minus+"달 ";
		 }
		 if(now.getDate() > writeDay.getDate()){
		    minus= now.getDate()-writeDay.getDate();
		    time +=  minus+"일 ";
		 }
		 if(now.getHours() > writeDay.getHours()){
		    minus = now.getHours() - writeDay.getHours();
		    time +=  minus+"시간 ";
		 }
		 if(now.getMinutes() > writeDay.getMinutes()){
		    minus = now.getMinutes() - writeDay.getMinutes();
		    time += minus+"분 ";
		 }
		 if(now.getSeconds() > writeDay.getSeconds()){
		    minus = now.getSeconds() - writeDay.getSeconds();
		 	time += minus+"초";
		 }
		  time += "후";
		  document.getElementsByClassName("sub")[0].innerHTML = time;      
		}
		setInterval(timeBefore,1000);
</script>


<!DOCTYPE html>
<html>  
	<head>  
		<title>날짜로 회원 검색</title>  
	</head> 
	<center> 
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>  
		<h1>날짜로 회원 검색</h1>
		<hr width = "100%">
		<p>이거 시작한 시간 => 2021년 5월 11일 16:01:17</p>
 		<p class="sub"></p>
		<p>  
			<form>  
				<input type="date" name="keyword2" value="${keyword2}" />  
				<input type="submit" value="검색" />  
			</form>  
		</p>    
		<p>  
			<form>  
				<select name="keyword2" onchange="this.form.submit();">
					<option value="none">=== 선택 ===</option>
					<option value="15s">15초 전</option>
					<option value="30s">30초 전</option>
					<option value="1m">1분 전</option>
					<option value="30m">30분 전</option>
					<option value="1h">1시간 전</option>
					<option value="1d">하루 전</option>
					<input type="submit" value="검색" /> 
				</select>  
			</form>  
		</p>  
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
		<tbody>  
			<c:forEach var="row" items="${data}">  
				<tr>  
					<td>${row.id }
					</td> 
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
	</body> 
	</center> 
</html>  