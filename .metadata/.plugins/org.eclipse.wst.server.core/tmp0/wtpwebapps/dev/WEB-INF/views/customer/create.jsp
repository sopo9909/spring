<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>회원 생성하기</title>
 </head>
 <center>
 <body>
 	<button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
  <h1>회원 생성하기</h1>
  <form method="POST">
   <p>이름 : <input type="text" name="name" /></p>
   <p>나이 : <input type="text" name="age" /></p>
   <p>주소 : <input type="text" name="adress" /></p>
   <p><input type="submit" value="저장" />
  </form>
 </body>
 </center>
</html>