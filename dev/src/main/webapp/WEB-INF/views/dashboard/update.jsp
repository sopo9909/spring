<%@ page pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>글 수정</title>
 </head>
 <center>
 <body>
 <button type="button" onclick="location.href='http://localhost:8080/' ">홈으로 바로이동</button>
  <h1>글 수정</h1>
  <form method="POST">
   <p>제목 : <input type="text" name="title" value="${ data.title }" /></p>
   <p>저자 : <input type="text" name="author" value="${ data.author }" /></p>
   <p>내용 : <input type="textarea" cols="50"rows="5"placeholder="내용을 적어주세요" name="content" value="${ data.content }" /></p>
   <p><input type="submit" value="저장" />
  </form>
 </body>
 <center>
</html>