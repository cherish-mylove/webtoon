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
	
	<div>
        <table border="1">
            <thead>
                <tr>
                    <th>게시판번호</th>
                    <th>웹툰번호</th>
                    <th>제목</th>
                    <th>아이디</th>
                    <th>작성일</th>
                    <th>관리</th>
                </tr>
            </thead>

            <tbody>
                <c:if test="${list.size() < 1}">
                    <tr>
                        <td colspan="6">등록 된 게시물이 없습니다.</td>
                    </tr>
                </c:if>

                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.webtoonId}</td>
                        <td><a href="view/${item.id}" class="title-link">${item.title}</a></td>
                        <td>${item.regId}</td>
                        <td><fmt:formatDate value="${item.regDate}" pattern="yyyy년 MM월 dd일"/></td>
                        <td><a href="update/${item.id}" class="update-btn">변경</a> 
                        	<a href="delete/${item.id}" class="delete-btn">삭제</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="pager">
        <c:forEach var="page" items="${pager.list}">
            <a href="?page=${page}${pager.query}" 
               class="${pager.page == page ? 'active' : ''}">${page}</a>
        </c:forEach>
    </div>

    <a href="add" class="reg-btn">등록</a>
</body>
</html>
