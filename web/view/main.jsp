<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

  <head>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<!-- GoogleMap script -->
	<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
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
        //map markers from db
        function carMarker(map){
	    	var url = "carMarker.can";
	    	$.ajax({
	    		url : url,
	    		success : function(data){
	    			var markers = data;
	    			
	    			$(markers).each(function(i,item){
		                var mcenter = new google.maps.LatLng(
		                    item.cur_location_x,item.cur_location_y
		                );
		                var marker = new google.maps.Marker({
		                    position:mcenter,
		                    map:map,
		                    animation:google.maps.Animation.DROP,
		                    label:String(item.car_id)
		                });
		                /* marker.setMap(map); */
		                var infowindow = new google.maps.InfoWindow({
		                    content:item.car_name //html����ó�� ���� ���� ������ ����
		                    //�̺�Ʈ ��Ŀ �߰��ϰ� �ش� �̺�Ʈ�� Ŭ�������� ������ ��Ŀ���
		                    //resultmap ����� �ʿ伺�� ������
		                });
		                marker.addListener('click',function(){
		                    infowindow.open(map,marker);
		                    getStatus(item.car_id);
		                });
		            });
	    			
	    		},
	    		error : function(){
	    			alert('error');
	    		}
	    	})
	    };	
		
	    //car status
	    function getStatus(car_id){
		    	var url = "carStatus.can?car_id="+car_id;
		    	$.ajax({
		    		url : url,
		    		success : function(data){
		    			$('#carstatus').html(data); 
		    			/* carMarker(); */
		    		},
		    		error : function(){
		    			alert('error');
		    		}
		    	})
		    };
		//search history			
	    function searchHistory(){
			var car_id = $('#search-form [name="car_id"]').val();
			var start_date = $('#search-form [name="start_date"]').val();
			var end_date = $('#search-form [name="end_date"]').val();
			
			var url = "searchHistory.can?car_id="+car_id+"&start_date="+start_date+"&end_date="+end_date;
			$.ajax({
				url: url,
				success: function(data){
					$('#history').html(data);
				},
				error: function(){
					alert('error');
				}
			})
		};
		
		//event marker 	
		function eventMarker(plan_num){
			var url = "getPlan.can?plan_num="+plan_num;
			$.ajax({
				url : url,
				success : function(data){
					var eventMarkers = data;
					
					$(eventMarkers).each(function(i,item){
		                var mcenter = new google.maps.LatLng(
		                    item.p_location_x,item.p_location_y
		                );
		                var marker = new google.maps.Marker({
		                    position:mcenter,
		                    map:map,
		                    animation:google.maps.Animation.DROP,
		                    /* label:String(item.car_id), */
		                    icon:'resources/icon_img/event-icon.png'
		                });
		                /* marker.setMap(map); */
		                var infowindow = new google.maps.InfoWindow({
		                    content:item.a_id 
		                    //html����ó�� ���� ���� ������ ����
		                   
		                });
		                marker.addListener('click',function(){
		                    infowindow.open(map,marker);
		                    getStatus(item.car_id);
		                });
		            });
					
				},
				error : function(){
					alert('error');
				}
			})
		};
			
	    
	    function map(){
	        var lat = 37.546890;
	        var lng = 127.133881;
	        var center = new google.maps.LatLng(lat,lng);
	        map = new google.maps.Map(
	            document.querySelector('.card-map'),
	            {
	                mapType: google.maps.MapTypeId.ROADMAP,
	                zoom:20,
	                center:center
	            });
	        carMarker(map);
	    };
	    //ready function
		$( document ).ready(function() {
		    console.log( "ready!" );
		    
		    //list-group-item active ����
		    var lBtn = $(".list-group-item");    //  ul > li �̸� sBtn���� Ī�Ѵ�. (Ŭ���̺�Ʈ�� li�� ���� �ȴ�.)
		    lBtn.click(function(){   			// sBtn�� ���� �ִ�  a ã�� Ŭ�� �ϸ�.
		     	lBtn.removeClass("active");     // sBtn �ӿ� (active) Ŭ������ ���� �Ѵ�.
		     	$(this).addClass("active"); 	// Ŭ���� a�� (active)Ŭ������ �ִ´�.
		     	console.log($(this).val());
		     	getListGroup($(this).val());
		    })
		    
		    
		    //Ajax list group display
		    function getListGroup(item){
		    	var url = "listgroup.can?item="+item;
		    	$.ajax({
		    		url : url,
		    		success : function(data){
		    			$('#listgroupitem').html(data); 
		    		},
		    		error : function(){
		    			alert('error');
		    		}
		    	})
		    };
		    
	        
		    getListGroup('carList');
		    map();
		    
		}); // end of ready function
		
		
	
		
		   
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
            <!-- <li class="nav-item active">
              <a class="nav-link" href="#">Home
                <span class="sr-only">(current)</span>
              </a>
            </li> -->
            <li class="nav-item active">
              <a class="nav-link" href="#">${login_admin.a_name } �� ������
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="logout.can">�α׾ƿ�</a>
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
          <!-- <h1 class="my-4">Shop Name</h1> -->
          <!--  -->
          <div class="list-group mt-4">
            <button class="col-lg-4 list-group-item active" value="carList">Car</button>
            <button class="col-lg-4 list-group-item" value="carEvents">Event</button>
            <button class="col-lg-4 list-group-item" value="carHistory">History</button>
          </div>
          
    <!-- ����Ʈ ��� -->
    		<div id="listgroupitem"></div>
	<!-- ����Ʈ ��� -->
          
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

         <div class="card mt-4">
            <div class="card-body card-map">
              <!-- <h3 class="card-title">MAP</h3>
              <h4></h4>
              <p class="card-text">�̰��� ������ ��ġ�մϴ�.</p> -->
            </div>
         </div>
          <!-- /.card -->
		 
		 	<div class="card card-outline-secondary my-4">
				<div class="card-header">���� �� ����</div>
				<div class="card-body card-status" id="carstatus">
					
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
	
	<script>
	//map display

	</script>
	
  </body>

</html>
