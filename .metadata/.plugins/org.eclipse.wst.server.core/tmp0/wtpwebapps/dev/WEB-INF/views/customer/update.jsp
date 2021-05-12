<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>회원정보 수정</title>
 </head>
 <center>
 <body>
 <button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
  <h1>회원정보 수정</h1>
  <form method="POST">
   <p>이름 : <input type="text" name="name" value="${ data.name }" /></p>
   <p>나이 : <input type="text" name="age" value="${ data.age }" /></p>
   <p>주소 : <input type="text" name="adress" value="${ data.adress }" /></p>
   <p><input type="submit" value="저장" />
  </form>
 </body>
 <center>
</html>