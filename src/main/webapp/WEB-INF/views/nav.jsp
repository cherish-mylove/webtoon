<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
	
</style>

<div class="nav">
	<c:if test="${sessionScope.users == null}">
		<div>
			<ul>
				<li><a href="${pageContext.request.contextPath}/login">로그인</a></li>
			</ul>
		</div>

		<div>
		 	<ul>
				<li><a href="/signup2">회원가입</a></li>
			</ul>
		</div>
	</c:if>
</div>

<div class="nav">
	<c:if test="${sessionScope.users != null}">
		<div>
			<div><a>${sessionScope.users.name}</a></div>
		</div>

		<div>
			<div>
				<a href="${pageContext.request.contextPath}/logout">로그아웃</a>
			</div>
		</div>
	</c:if>
</div>