<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/resources/css/us_list.css">
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
            <table>
                <thead>
                    <tr>
                        <th>아이디</th>
                        <th>비밀번호</th>
                        <th>이름</th>
                        <th>전화번호</th>
                        <th>관리</th>
                    </tr>
                </thead>

                <tbody>
                    <c:if test="${list.size() < 1}">
                        <tr>
                            <td colspan="5" class="no-users">검색 된 이용자가 없습니다.</td>
                        </tr>
                    </c:if>

                    <c:forEach var="item" items="${list}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.passwd}</td>
                            <td>${item.name}</td>
                            <td>${item.tel}</td>
                            <td>
                                <a href="delete/${item.id}">삭제</a>
                                <a href="update/${item.id}">변경</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <div class="buttons">
            <a href="add">등록</a>
            <a href="..">이전</a>
        </div>
    </div>
</body>
</html>
