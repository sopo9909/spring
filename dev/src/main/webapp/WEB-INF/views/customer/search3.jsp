<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<script language="JavaScript">
	function doBlink() {
		var blink = document.all.tags("BLINK")
		for (var i=0; i < blink.length; i++)
		blink[i].style.visibility = blink[i].style.visibility == "" ? "hidden" : ""
		}
	function startBlink() {
		if (document.all)
			setInterval("doBlink()",800)
		}
	window.onload = startBlink;
</script>
<script>
function timeBefore(){
	 //현재시간
	 var now = new Date(); 
	 //기준시간 
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
		<title>날짜로 회원 검색2</title> 
	<link rel="stylesheet" hrep="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css" /> 
	</head>  
	<center>
	<body>
		<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>  
		<h1 class="animate__animated animate__bounce">날짜로 회원 검색2</h1>
		<hr width = "100%">
		<blink><p ><b> 시작한 시간 => 2021년 5월 11일 16:01:17</b></p></blink>
 		<p class="sub"></p>
  
		<p>  
			<form>  
				<select name="keyword3">
					<option value="no">=== 선택 ===</option>
					<option value="1h">한시간 이내</option>
					<option value="1d">하루 이내</option>
					<option value="3d">3일 이내</option>
					<option value="7d">일주일 내</option>
					<option value="30d">한달 이내</option>
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
					<td>몇 시간전 입력</td>
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
					<td>${row.time} 시간 전</td>
				</tr>  
			</c:forEach>  
		</tbody>  
		</table>   
	</body> 
	</center> 
</html>  