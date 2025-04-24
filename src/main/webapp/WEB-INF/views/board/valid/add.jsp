<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="${pageContext.request.contextPath}/resources/js/board/add.js"></script>
<link rel="stylesheet" href="/resources/css/bd_add.css">
</head>
<body>
    <div class="container">
        <div>
            <h3>게시판 등록</h3>
        </div>
        <div>
            <form method="post" enctype="multipart/form-data">
                <div>
                    <label>제목</label>
                    <div><form:input path="board.title" type="text" name="title" placeholder="제목을 입력하세요"></form:input></div>
					<div class="error"><form:errors path="board.title"></form:errors></div>
                </div>
                
                <div>
                    <label>내용</label>
                    <div><form:input path="board.text" type="text" name="text" placeholder="내용을 입력하세요"  cssStyle="height: 100px;"></form:input></div>
                    <div class="error"><form:errors path="board.text"></form:errors></div>
                </div>
                
                <div>
                    <label>제품 이미지</label>
                    <button type="button" id="add_photo">이미지 추가</button>
                    <ul id="list_photo">
                        <li>
                            <input type="file" name="uploadFile">
                        </li>
                    </ul>
                </div>
                <div style="text-align: center;">
                    <button type="submit">등록</button>
                    <a href="list"><button type="button">취소</button></a>
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