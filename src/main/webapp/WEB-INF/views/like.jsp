<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/wt_admin.css">
<script src="/resources/js/like.js"></script>
</head>
<body>
	<div>
		<header>
			<div class="header-container">
				<div>
					<a href="/" class="logo"><img width="100" height="50"
						src="${pageContext.request.contextPath}/resources/img/never.png"></a>
				</div>

				<nav class="header-center">
					<ul class="header-menu">

						<c:choose>
							<c:when test="${sessionScope.users.role != 99}">
								<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
								<li><a
									href="${pageContext.request.contextPath}/webtoon/list">웹툰목록</a></li>
								<li><a href="${pageContext.request.contextPath}/like">관심웹툰</a></li>
							</c:when>

							<c:when test="${sessionScope.users.role == 99}">
								<li><a href="${pageContext.request.contextPath}/board/list">게시판</a></li>
								<li><a
									href="${pageContext.request.contextPath}/board/admin">게시판관리</a></li>
								<li><a
									href="${pageContext.request.contextPath}/webtoon/list">웹툰목록</a></li>
								<li><a
									href="${pageContext.request.contextPath}/webtoon/admin">웹툰관리</a></li>
								<li><a href="${pageContext.request.contextPath}/like">관심웹툰</a></li>
								<li><a href="${pageContext.request.contextPath}/users/list">이용자목록</a></li>
							</c:when>
						</c:choose>
					</ul>
				</nav>

			</div>
		</header>

		<div>
			<table border="1">
				<thead>
					<tr>
						<th>웹툰사진</th>
						<th>번호</th>
						<th>작가</th>
						<th>제목</th>
						<th>보러가기</th>
						<th>관리</th>
					</tr>
				</thead>

				<tbody>
					<c:if test="${list.size() < 1}">
						<tr>
							<td colspan="5">등록 된 관심웹툰이 없습니다.</td>
						</tr>
					</c:if>

					<c:forEach var="item" items="${list}">
						<tr>
							<td><c:forEach var="photo" items="${item.photo}">
                    			<div class="image-container">
                        			<img src="${pageContext.request.contextPath}/project/${photo.uuid}_${photo.filename}"  style="width: 100px; height: 100px;"></div>
                    			</c:forEach>
                    		</td>
							<td>${item.id}</td>
							<td>${item.author}</td>
							<td>${item.title}</td>
							<td><a href="${item.src}">${item.src}</a></td>
							<td>
                            	<a href="webtoon/delete/${item.id}" class="delete-btn">삭제</a>
                        	</td>
						</tr>
					</c:forEach>
				</tbody>	
			</table>
		</div>

	</div>
</body>
</html>