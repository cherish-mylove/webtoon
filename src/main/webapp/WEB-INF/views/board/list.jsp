<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/bd_admin.css">
</head>
<body>
	 <header>
			<div class="header-container">
				<div>
					<a href="/" class="logo"><img width="100" height="50" src="${pageContext.request.contextPath}/resources/img/never.png"></a>
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

				<div>
					<nav>
						<jsp:include page="../nav.jsp"></jsp:include>
					</nav>
				</div>

			</div>
		</header>
		
		<div class="search-container">
			<form class="search-form">
				<select name="search" class="form-select">
					<option value="1">제목</option>
					<option value="2">아이디</option>
				</select> 
				<input type="text" name="keyword" placeholder="검색어를 입력하세요" class="search-input">
				<button type="submit" class="search-btn">검색</button>
			</form>
		</div>

    <div>
        <table border="1">
            <thead>
                <tr>
                	<th>웹툰사진</th>
                	<th>웹툰번호</th>
                    <th>게시판번호</th>
                    <th>제목</th>
                    <th>아이디</th>
                    <th>작성일</th>
                    <th>조회수</th>
                    <th>⋮</th>
                </tr>
            </thead>

            <tbody>
                <c:if test="${list.size() < 1}">
                    <tr>
                        <td colspan="4">등록 된 게시물이 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach var="item" items="${list}">
                    <tr>
                    	<td><c:forEach var="photo" items="${item.photo}">
                    			<div class="image-container">
                        			<img src="${pageContext.request.contextPath}/project/${photo.uuid}_${photo.filename}"  style="width: 100px; height: 100px;"></div>
                    		</c:forEach>
                    	</td>
                    	<td>${item.webtoonId}</td>
                        <td>${item.id}</td>
                        <td><a href="view/${item.id}" class="title-link">${item.title}</a></td>
                        <td>${item.regId}</td>
                        <td><fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일"/></td>
                        <td>${item.views}</td>
                   		<td>
                   			<c:if test="${sessionScope.users.id == item.regId}">
                        		<a href="update/${item.id}" class="update-btn">수정</a>
                        		<a href="delete/${item.id}" class="delete-btn">삭제</a>
                        	</c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- pager 섹션 -->
    <div class="pager">
        <c:forEach var="page" items="${pager.list}">
            <a href="?page=${page}${pager.query}" 
               class="${pager.page == page ? 'active' : ''}">${page}</a>
        </c:forEach>
    </div>
    
    <a href="add" class="reg-btn">등록</a>
</body>
</html>