<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="EUC-KR">
		<title>HOME</title>
	</head>
	
	<center>
		<body>
			<h1>이곳은 호영님이 처음 만든 SPRING HOME 입니다</h1>
			<hr width = "100%">
			
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/list' " style="width:150px;height:50px;color:#FFFFFF;font-size:40;">회원 총 목록</button>
			</p>
			
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/create' " style="width:150px;height:50px;color:#FFFFFF;font-size:40;">회원 정보 입력</button>
			</p>
			
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/search' " style="width:150px;height:50px;color:#FFFFFF;font-size:40;">회원 정보 검색</button>
			</p>
			
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/search2' "style="width:150px;height:50px;color:#FFFFFF;font-size:40;">날짜로 회원 검색</button>
			</p>
			
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/search3' "style="width:150px;height:50px;color:#FFFFFF;font-size:40;">날짜로 회원 검색2</button>
			</p>
			<p>
				<button type="button" onclick="location.href='http://localhost:8080/listPage' "style="width:150px;height:50px;color:#FFFFFF;font-size:40;">카운트 구현</button>
			</p>
		</body>
	</center>
</html>