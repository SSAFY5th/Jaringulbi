<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${root}/css/boardResult.css" />
  <link rel="stylesheet" href="${root}/css/index.css">
</head>

<body>
  <!-- 상단 nav top -->
  <%@ include file="module/header.jsp" %>
  
  <div class="container">
	
    <!-- d-->
    <div style="height:170px;"></div>
    
    <div class="row mt-5">
      <div class="col-md-4"></div>
     

      <div class="col-md-4">
        <button class="btn btn-outline-success w-100 h-100" onclick="sample4_execDaumPostcode()">동 검색</button>
      </div>
    </div>

    <!-- 게시물 영역 start -->
    <div class="mt-3">
      <h2>실거래 정보</h2>
      <div class="mb-3" style="border-bottom: 2px solid rgb(233, 232, 232);"></div>
    </div>
    <c:if test="${aptDealList != null }">
    <c:forEach var="i" begin="${pageno}" end="${pageno}">
	    <div class="card-deck">
	    	<c:forEach var="j" begin="${i * 9}" end="${i * 9 + 2}">
	    		<c:if test="${j < aptDealList.size()}">
	    		<div class="card">
		     	<img src="${root}/img/home${j}.jpg" />
		     	<div class="card-body text-center">
		          <h5>${aptDealList.get(j).aptName}</h5>
		          <p class="card-text">실거래 금액 : ${aptDealList.get(j).dealAmount}</p>
		          <p class="card-text">건축년도 : ${aptDealList.get(j).buildYear}</p>
		          <p class="card-text">면적 : ${aptDealList.get(j).area}</p>
		        </div>
		      	</div>
		      	</c:if>
	    	</c:forEach>
	    </div>
	    <div class="card-deck">
	    	<c:forEach var="j" begin="${i * 9 + 3}" end="${i * 9 + 5}">
	    		<c:if test="${j < aptDealList.size()}">
	    		<div class="card">
		     	<img src="${root}/img/home${j}.jpg" />
		     	<div class="card-body text-center">
		          <h5>${aptDealList.get(j).aptName}</h5>
		          <p class="card-text">실거래 금액 : ${aptDealList.get(j).dealAmount}</p>
		          <p class="card-text">건축년도 : ${aptDealList.get(j).buildYear}</p>
		          <p class="card-text">면적 : ${aptDealList.get(j).area}</p>
		        </div>
		      	</div>
		      	</c:if>
	    	</c:forEach>
	    </div>
	    <div class="card-deck">
	    	<c:forEach var="j" begin="${i * 9 + 6}" end="${i * 9 + 8}">
	    		<c:if test="${j < aptDealList.size()}">
	    		<div class="card">
		     	<img src="${root}/img/home${j}.jpg" />
		     	<div class="card-body text-center">
		          <h5>${aptDealList.get(j).aptName}</h5>
		          <p class="card-text">실거래 금액 : ${aptDealList.get(j).dealAmount}</p>
		          <p class="card-text">건축년도 : ${aptDealList.get(j).buildYear}</p>
		          <p class="card-text">면적 : ${aptDealList.get(j).area}</p>
		        </div>
		      	</div>
		      	</c:if>
	    	</c:forEach>
	    </div>
     </c:forEach>
     </c:if>
   </div>
    

  <!-- pagenation -->
  <nav aria-label="...">
    <ul class="pagination justify-content-center mt-4">
      <li class="page-item disabled">
        <span class="page-link">Previous</span>
      </li>
	      <c:forEach var="i" begin="${beginPage}" end="${endPage}">
		      	<c:if test="${i != pageNo}">
		      		<li class="page-item"><a class="page-link" href="${root}/aptDeal/searchbylist?dongcode=${dongcode}&pageNo=${i}">${i}</a></li>
		      	</c:if>
		      	<c:if test="${i == pageNo}">
		      		<li class="page-item active">
				      	<span class="page-link">
				          ${i}
				          <span class="sr-only">(${i})</span>
				        </span>
			        </li>
		      	</c:if>
	      </c:forEach>
      
      <li class="page-item">
        <a class="page-link" href="#">Next</a>
      </li>
    </ul>
  </nav>
  
  <!-- pagenation -->
  
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
  <script src="${root}/js/index.js" type="text/javascript"></script>
  
  <!-- 동 코드 리턴하는 다음 팝업 -->
  <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
    function sample4_execDaumPostcode() {
    	let str = "${root}/aptDeal/searchbylist?dongcode=";
        new daum.Postcode({
            oncomplete: function(data) {
                location.href = str + data.bcode;
            }
        }).open();
    }
	</script>
</body>

</html>