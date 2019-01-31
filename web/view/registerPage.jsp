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

    <title>Register Page</title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/shop-item.css" rel="stylesheet" type="text/css">
  	
  	
  	<script>
		$( document ).ready(function() {
		    console.log('asdf');
		    //Ajax list group display
		    function idCheck(a_id){
		    	var url = "duplcheck.can?a_id="+a_id;
		    	$.ajax({
		    		
		    		url : url,
		    		success : function(data){
		    			alert(data);
		    			if(data == 0){
		    				$('#idcheckmsg').html('가능');	
		    			} else{
		    				$('#idcheckmsg').html('불가능');
		    				$('#a_id').val('');
		    				$('#a_id').focus();
		    				
		    			} 
		    		},
		    		error : function(){
		    			alert('error');
		    		}
		    	})
		    };
		    
		    
		    $('#chkbtn').click(function(){
		    	if(($('#a_id').val()).length > 4){
			     	idCheck($('#a_id').val());
		    	} else{
		    		alert('계정명이 너무 짧습니다.');
		    		$('#a_id').focus();
		    	}
		    })
		    
		    $('#pwchk').blur(function(){
		    	
		    	if($('#pw').val() != $('#pwchk').val()){
		    		$('#pwchkmsg').html('비밀번호가 일치하지 않습니다.');
		    		$('#pwchk').val('');
		    		
		    	}else{
		    		$('#pwchkmsg').html('비밀번호 일치');
		    	}
		    })
		    
		    
		});
		
	</script>
  	
  	
  	
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
              <label class="col-lg-2 card-title">계정명</label>
  			  <input class="col-lg-4 " type="text" name="a_id" id="a_id" placeholder="your id">
  			  <small class="col-lg-1" id="idcheckmsg"></small>
  			  <div class="col-lg-2">
  			  	<input type="button" id="chkbtn" value="중복체크"> 
  			  </div>
  			</div>
  			<div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">비밀번호</label>
              <input class="col-lg-4" type="password" name="a_pw" id="pw" placeholder="your password">
              <div class="col-lg-3"></div>
            </div>
            <div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">비밀번호 확인</label>
              <input class="col-lg-4" type="password" name="pwcheck" id="pwchk" placeholder="password check">
              <small class="col-lg-3" id="pwchkmsg"></small>
            </div>
            <div class="row">
  			  <div class="col-lg-3"></div>            	
              <label class="col-lg-2 card-title">이름</label>
              <input class="col-lg-4" type="text" name="a_name" placeholder="your name">
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
