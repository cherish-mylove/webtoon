<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h3>이용자 변경</h3>
		</div>
		
		<div>
			<form method="post">
				<div>
					<div><label>아이디</label></div>
					<div><input type="text" name="id" value="${item.id}" readonly></div>
				</div>			
				
				<div>
					<div><label>비밀번호</label></div>
					<div><input type="text" name="passwd" value="${item.passwd}"></div>
				</div>
				
				<div>
					<div><label>이름</label></div>
					<div><input type="text" name="name" value="${item.name}"></div>
				</div>
				
				<div>
					<div><label>전화번호</label></div>
					<div><input type="text" name="tel" value="${item.tel}"></div>
				</div>
				
				<div>
					<div><label>역할</label></div>
					<div><input type="number" name="role" value="${item.role}"></div>
				</div>
				
				<div>
					<div><button>등록</button></div>
					<div><a href="../list"><button type="button">취소</button></a></div> <!-- @pv로 한뎁스 더 들어가 있어서 -->
				</div>
			</form>
		</div>
	</div>
</body>
</html>