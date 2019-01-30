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

    <title>Login Page</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/shop-item.css" rel="stylesheet" type="text/css">
  	
  </head>

  <body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      <div class="container">
        <a class="navbar-brand" href="#">Register Page</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="loginpage.can">돌아가기
                <!-- <span class="sr-only">(current)</span> -->
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container loginpage bg-dark">

      <div class="row">
		<div class="col-lg-3"></div>
        <div class="col-lg-6">
          <div class="card mt-4">
            <!-- <img class="card-img-top img-fluid" src="http://placehold.it/900x400" alt=""> -->
            <div class="card-body">
            
            <!-- Register Form -->
            <form action="register.can">
            <div class="row">
              <div class="col-lg-3"></div>	
              <label class="col-lg-2 card-title">ID</label>
  			  <input class="col-lg-4 " type="text" name="id" placeholder="your id">
  			  <div class="col-lg-3">
  			  	<input type="button" value="중복체크"> 
  			  </div>
  			</div>
  			<div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">PW</label>
              <input class="col-lg-4" type="password" name="pw" placeholder="your password">
              <div class="col-lg-3"></div>
            </div>
            <div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">PW check</label>
              <input class="col-lg-4" type="password" name="pwcheck" placeholder="password check">
              <div class="col-lg-3"></div>
            </div>
            <div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">NAME</label>
              <input class="col-lg-4" type="text" name="name" placeholder="your name">
              <div class="col-lg-3"></div>
            </div>
            <div class="row">
              <div class="col-lg-3"></div>
              <input class="col-lg-6" type="submit" value="등록하기">
              <div class="col-lg-3"></div>
            </div>
              <p class="card-text"></p>
            </form>
            <!-- /Login Form -->
            
            </div>
          </div>
          <!-- /.card -->
        </div>
        <div class="col-lg-3"></div>
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
