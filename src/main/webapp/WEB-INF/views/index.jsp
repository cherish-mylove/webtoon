<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/index.css">
</head>
<body>

<header>
    <div class="header-container">
        <div>
            <a href="/" class="logo"><img width="100" height="50" src="${pageContext.request.contextPath}/resources/img/never.png"></a>
            <h1>REVIEW</h1> 
        </div>
        
        <!-- 네비게이션 메뉴가 헤더 중앙에 위치 -->
			<nav class="header-center">
				<ul class="header-menu">

					<c:choose>
						<c:when test="${sessionScope.users.role != 99}">
							<li><a href="board/list">게시판</a></li>
							<li><a href="webtoon/list">웹툰목록</a></li>
							<li><a href="/like">관심웹툰</a></li>
						</c:when>

						<c:when test="${sessionScope.users.role == 99}">
							<li><a href="board/list">게시판</a></li>
							<li><a href="board/admin">게시판관리</a></li>
							<li><a href="webtoon/list">웹툰목록</a></li>
							<li><a href="webtoon/admin">웹툰관리</a></li>
							<li><a href="/like">관심웹툰</a></li>
							<li><a href="users/list">이용자목록</a></li>
						</c:when>
					</c:choose>
				</ul>
			</nav>

			<!-- 로그인/회원가입 링크가 우측에 위치 -->
        <div>
            <nav>
				<jsp:include page="nav.jsp"></jsp:include>
			</nav>
        </div>
        
    </div>
</header>

	<main>
		<div>
			<h2>리뷰 바로가기</h2>
				<section class="webtoon-section">

					<div class="webtoon-container">
						<c:forEach var="item" items="${list}">
							<a href="/webtoon/view/${item.id}">
								<div class="webtoon-card">
									<img src="/project/${item.photo[0].uuid}_${item.photo[0].filename}">
									<h3><td>${item.title}</td></h3>
									<p><td>${item.author}</td></p>
								</div>
							</a>
						</c:forEach> 
					</div>
				</section>
		</div>
	</main>
</body>

</html>
