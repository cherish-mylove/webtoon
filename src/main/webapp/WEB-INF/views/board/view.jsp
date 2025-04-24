<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/board.css">
</head>
<body>
	<div>
		<h3>게시판</h3>
	</div>
	
	<div>
		<div>
			<div>${item.title}</div>
		</div>
		
		<div>
			<div>${item.regId}<fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일"/></div>
		</div>
		
		<div>
			<div>${item.text}</div>
		</div>

		<div>
			<div>
				<label>제품 이미지:</label>
			</div>
			<c:if test="${item.photo == null || item.photo.size() < 1}">
				<div>제품이미지가 없습니다</div>
			</c:if>

			<c:forEach var="photo" items="${item.photo}">
				<div>
					<img alt="제품 이미지" width="150" height="150"
						src="${pageContext.request.contextPath}/project/${photo.uuid}_${photo.filename}">
				</div>
			</c:forEach>
		</div>

		 <div>
    		<a href="../list">목록</a>
    	</div>
	</div>
	
</body>
</html>