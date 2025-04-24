<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
	let id_check = false;
</script>
<script src="resources/js/signup.js"></script>
<script src="resources/js/signup2.js"></script>
<style></style>
<link rel="stylesheet" href="/resources/css/signup.css">
</head>
<body>
	<div class="signup-container">
		<h3>회원가입</h3>
		<form id="signup" method="post" action="signup">
			<div class="form-group">
				<label for="id">아이디:</label> <input type="text" id="id" name="id">
				<button type="button" id="id_check_async">중복 확인</button>
			</div>
			<div class="form-group passwd">
				<label for="passwd">비밀번호:</label> <input type="password" id="passwd"
					name="passwd">
				<button type="button" class="view">보기</button>
			</div>
			<div class="form-group passwd">
				<label for="passwd_check">비밀번호 확인:</label> <input type="password"
					id="passwd_check" name="passwd_check">
				<button type="button" class="view">보기</button>
			</div>
			<div class="form-group">
				<label for="name">성명:</label> <input type="text" id="name"
					name="name">
			</div>
			<div class="form-group">
				<label for="tel">전화번호:</label> <input type="text" id="tel"
					name="tel">
			</div>

			<div class="form-actions">
				<a href="login"><button type="button" id="signup_button">확인</button></a>
				<a href="."><button type="button">취소</button></a>
			</div>

		</form>
		<div class="text-center">
			<p>
				이미 계정이 있으신가요? <a href="/login">로그인</a>
			</p>
		</div>
	</div>