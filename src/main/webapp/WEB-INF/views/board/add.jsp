<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<script src="${pageContext.request.contextPath}/resources/js/board/add.js"></script>
<link rel="stylesheet" href="/resources/css/bd_add.css">
</head>
   <style>
    </style>
<body>
    <div class="container">
        <div>
            <h3>게시판 등록</h3>
        </div>
        
        <div>
            <form method="post" enctype="multipart/form-data">

				<div>
					<label>제목</label> <input type="text" name="title" placeholder="제목을 입력하세요">
				</div>

				<div>
					<label>내용</label>
					<textarea name="text" placeholder="내용을 입력하세요"></textarea>
				</div>

				<div>
					<label>제품 이미지</label>
					<button type="button" id="add_photo">이미지 추가</button>
					<ul id="list_photo">
						<li><input type="file" name="uploadFile"></li>
					</ul>
				</div>

				<div class="actions">
					<a><button type="submit">등록</button></a>
					<a href="${pageContext.request.contextPath}/board/list"><button type="button">취소</button></a>
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