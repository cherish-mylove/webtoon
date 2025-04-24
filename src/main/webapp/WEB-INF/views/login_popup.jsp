<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<c:if test="${sessionScope.users != null}">
	<script>
		// window.opener.location.reload();
		window.opener.postLogin("${type}");		
		
		self.close();
	</script>
</c:if>
</head>
<body>
	<div>
		<div>
			<h3>로그인</h3>
		</div>
		
		<div>
			<form method="post">
				<div>
					<div><label>아이디:</label></div>
					<div><input type="text" name="id"></div>
				</div>	
				
				<div>
					<div><label>비밀번호:</label></div>
					<div><input type="password" name="passwd"></div>
				</div>
				
				<div>
					<div><button>로그인</button></div>
					<div><a href="javascript:self.close()"><button type="button">취소</button></a></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>