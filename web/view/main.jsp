<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

  <head>
	<script src="http://code.jquery.com/jquery.min.js"></script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Main Page</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/shop-item.css" rel="stylesheet" type="text/css">
	
	
	<script>
		$( document ).ready(function() {
		    console.log( "ready!" );
		    var sBtn = $(".list-group-item");    //  ul > li 이를 sBtn으로 칭한다. (클릭이벤트는 li에 적용 된다.)
		     sBtn.click(function(){   // sBtn에 속해 있는  a 찾아 클릭 하면.
		     sBtn.removeClass("active");     // sBtn 속에 (active) 클래스를 삭제 한다.
		     $(this).addClass("active"); // 클릭한 a에 (active)클래스를 넣는다.
		    })
		});
		
		
	 
	</script>
	
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Main Page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">
		
        <div class="col-lg-3">
          <h1 class="my-4">Shop Name</h1>
          <!--  -->
          <div class="list-group">
            <a href="#" class="col-lg-4 list-group-item active">Car</a>
            <a href="#" class="col-lg-4 list-group-item">Event</a>
            <a href="#" class="col-lg-4 list-group-item">History</a>
          </div>
          
    <!-- 리스트 출력 -->
				<c:choose>
					<c:when test="${center !=null }">
						<jsp:include page="${center }.jsp"/>
					</c:when>
					<c:otherwise>
						<jsp:include page="carList.jsp"/>
					</c:otherwise>
				</c:choose>
	<!-- 리스트 출력 -->
          
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div class="card mt-4">
            <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt="">
            <div class="card-body">
              <h3 class="card-title">Product Name</h3>
              <h4>$24.99</h4>
              <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente dicta fugit fugiat hic aliquam itaque facere, soluta. Totam id dolores, sint aperiam sequi pariatur praesentium animi perspiciatis molestias iure, ducimus!</p>
              <span class="text-warning">&#9733; &#9733; &#9733; &#9733; &#9734;</span>
              4.0 stars
            </div>
          </div>
          <!-- /.card -->

          

        </div>
        <!-- /.col-lg-9 -->

      </div>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <!-- <script src="/fleet/resources/vendor/jquery/jquery.min.js"></script> -->
    <script src="<c:url value="/resources/vendor/jquery/jquery.min.js"/>"></script>
    <!-- <script src="/fleet/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script> -->
    <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

  </body>

</html>
