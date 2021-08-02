<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="${root}/css/index.css">
    <link rel="stylesheet" type="text/css" href="${root}/css/noticeList.css" />
    <script src="board_main.js" type="text/javascript"></script>
    <title>게시판 메인 화면</title>
    <script type="text/javascript">
		function movenoticewrite() {
			location.href="${root}/notice/mvnoticewrite";
		}
		
	</script>
</head>

<body>
    <%@ include file="module/header.jsp" %>
    <div style="height:170px;"></div>
    <div class="container">
        <h2> Haapy House 서비스의 <span>신규</span> 및 <span>업데이트</span> 소식을 알려드립니다!</h2>
        <c:if test="${userinfo ne null }">
	        <div class="container" align="right">
	        	<button class="btn btn-primary" onclick="javascript:movenoticewrite();">등록</button>
	        </div>
        </c:if>
        <table class="table table-hover mt-4 ">
            <thead>
                <tr>
                    <th class="text-center" style="width: 60%;">제목</th>
                    <th style="width: 15%;">작성자</th>
                    <th style="width: 15%;">날짜</th>
                    <th style="width: 10%;">조회수</th>
                </tr>
            </thead>
            <tbody>
            	<c:if test="${noticeList.size() ne 0 }">
            	<c:forEach var="notice" items="${noticeList}">
            	<tr>
                    <td id="title"><a href="${root}/notice/mvnoticewatch?articleno=${notice.articleno}">${notice.subject}</a></td>
                    <td>${notice.userid}</td>
                    <td>${notice.regtime}</td>
                    <td>${notice.viewcnt}</td>
                </tr>
                </c:forEach>
            	</c:if>
            <!-- 
                <tr>
                    <td id="title">주거 실거래 정보 사이트 Happy House 오픈!!!</td>
                    <td>운영자</td>
                    <td>2021-03-12</td>
                    <td>299</td>
                </tr>
                -->
            </tbody>
        </table>
    </div>
    
    <!-- footer -->
    <%@ include file="module/footer.jsp" %>
    <!-- 로그인 모달창 -->
    <%@ include file="module/login.jsp" %>

    <!-- 회원가입 모달창-->
    <%@ include file="module/signUp.jsp" %>

    <!-- 회원 정보 확인 모달창-->
  	<%@ include file="module/checkMemberInfo.jsp" %>

  	<!-- 비밀번호 찾기 -->
  	<%@ include file="module/findPassword.jsp" %>
    <script src="js/index.js" type="text/javascript"></script>
</body>

</html>
