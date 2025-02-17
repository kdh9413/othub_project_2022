<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>ShowRoom | OtHub</title>
	<!-- css, javascript -->
	<link href="css/showroom/common.css" rel="stylesheet">
	<script src="js/jquery-3.6.0.min.js"></script>
	<script>
		function resign(){
			if(confirm("정말 삭제하시겠습니까?")== true){
				$.ajax({
					url: "deletePost"
					success(){
						location.href = "showroom";
						alert("게시물이 정상적으로 삭제되었습니다");
					}
				})//ajax
			}//if
		}//function
	</script>
</head>
<body>
	<!-- navbar include -->
	<%@include file="../include/navbar.jsp"%>
	<!-- 이달의 추천 쇼룸 -->
	<%@include file="sr_today.jsp"%>

	<!-- main container -->
	<main>
		<section>
			<div class="sub_sr_menu">
				<ul class="lookup">
					<li><a href="showroom">전체</a></li>
					<li><a href="showroomlist?cate=1" class="s">스튜디오</a></li>
					<li><a href="showroomlist?cate=2" class="s">사진관</a></li>
					<li><a href="showroomlist?cate=3" class="s">사진작가</a></li> 
				</ul>
				<c:if test="${role1.equals('admin') }">
					<a href="sr_writing"><div class="writeBtn">게시글 등록하기</div></a>
				</c:if>
			</div>
		</section>
		<section class="showroom">
			<hr class="hr">
			<article class="sr_card_box">
				<c:forEach items="${cateList }" var="showroom">
					<div class="sr_card">
						<div class="sr_card_img">
							<a href="/showroompost?no=${showroom.sr_num }">
								<img src="images/showroom/user_img/${showroom.sr_imgname1 }">
							</a> 
						</div>
						<div class="sr_card_info">
							<h3><a href="/showroompost?no=${showroom.sr_num }">${showroom.sr_title }</a></h3>
							<div class="location">
								<i class="fa-solid fa-location-dot"></i>
								<span>${showroom.sr_region }</span>
							</div>
							<div class="price">
								<span class="price_val">${showroom.sr_price } </span>
								<span class="price_unit">원/시간</span>
								<c:if test="${role1.equals('admin') }">
									<span class="editBtn"><a href="/sr_update?no=${showroom.sr_num }">수정</a></span>
									<span class="editBtn"><a href="/deletePost?no=${showroom.sr_num }" onclick="resign(); return false;">삭제</a></span>
								</c:if>
							</div>
						</div>
					</div>
				</c:forEach>
			</article>
		</section>
		<section class="showroom">
			<div class="sr_paging">
				<% int totalPage = (Integer)request.getAttribute("sr_totalPage");
					for(int i = 1; i<= totalPage; i++){ %>
						<a href="showroomlist?cate=${sr_kind }&page=<%=i%>"><%=i%></a> 
				<%}%>
			</div>
		</section>
	</main>

	<!-- footer include -->
	<%@include file="../include/footer.jsp"%>
</body>
</html>
