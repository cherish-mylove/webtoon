<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/resources/js/board/update.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/board/add.js"></script>
<link rel="stylesheet" href="/resources/css/bd_add.css">
</head>
   <style>
    </style>
<body>
    <div class="container">
        <div>
            <h3>게시판 변경</h3>
        </div>
        
        <div>
            <form method="post" enctype="multipart/form-data">

				<div>
					<label>제목</label> <input type="text" name="title" value="${item.title}">
				</div>

				<div>
					<label>내용</label>
					<textarea name="text"></textarea>
				</div>

				<div>
					<label>제품 이미지</label>
					<button type="button" id="add_photo">이미지 추가</button>
					<ul id="list_photo">
						<li><input type="file" name="uploadFile"></li>
					</ul>
				</div>
				
				<c:if test="${item.photo == null || item.photo.size() < 1}">
						<div>제품이미지가 없습니다</div>
				</c:if>

					<c:forEach var="photo" items="${item.photo}">						
						<div class="photo">
							<div>
								<button type="button" class="delete_photo" data-photo="${photo.id}">삭제 ${photo.id}</button>
							</div>
							<div>
								<img alt="제품 이미지" width="150" height="150" src="${pageContext.request.contextPath}/project/${photo.uuid}_${photo.filename}">
							</div>
						</div>
					</c:forEach>

				<div class="actions">
					<button type="submit">등록</button>
					<a href="admin"><button type="button">취소</button></a>
				</div>
			</form>
            
            <div id="temp_photo" style="display: none">
                <div>
                    <input type="file" name="uploadFile">
                    <button type="button">삭제</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>