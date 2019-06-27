<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/main/process" method="post">
	userId : <input type="text" name="userId" value="brown"/>
	userId : <input type="text" name="userId" value="sally"/>
	
	name : <input type="text" name="name" value="브라운"/>
	name : <input type="text" name="name" value="샐리"/>
	
	addr : <input type="text" name="addr[0].addr1" value="대전시 중구"/>
	addr : <input type="text" name="addr[0].addr2" value="중앙로76"/>
	
	addr : <input type="text" name="addr[1].addr1" value="대전시 중구"/>
	addr : <input type="text" name="addr[1].addr2" value="중구청"/>
	
	<input type="submit" value="전송"/>
</form>
</body>
</html>