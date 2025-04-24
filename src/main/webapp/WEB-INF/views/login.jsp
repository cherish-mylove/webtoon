<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="/resources/css/login.css">
<style>
</style>
</head>
<body>
	<div class="login-container">
		<h3>로그인</h3>
		<form method="post">
			
			<div>
				<label>아이디</label> <input type="text" name="id" required>
			</div>
			<div>
				<label>비밀번호</label> <input type="password" name="passwd" required>
			</div>
			
			<div class="button-container">
				<button type="submit">로그인</button>
				<a href="."><button type="button">취소</button></a>
			</div>
		</form>
	</div>
</body>
</html>
