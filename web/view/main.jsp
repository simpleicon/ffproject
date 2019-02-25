<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

  <head>
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<!-- GoogleMap script -->
	
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
		var googleMap;
		var googleMarkers = [];
		var eventMarkers = [];
		//map 그리기
		function map(){
	        var lat = 37.368856;
	        var lng = 127.324209;
	        var center = new google.maps.LatLng(lat,lng);
	        googleMap = new google.maps.Map(
	            document.querySelector('.card-map'),
	            {
	                mapType: google.maps.MapTypeId.ROADMAP,
	                zoom:18,
	                center:center
	            });
	        carMarker(googleMap);
	        stationMarker(googleMap);
	    };
	    
	    //street view panorama
	    function initPano(locx,locy) {
	        // Note: constructed panorama objects have visible: true
	        // set by default.
	         
	        var panorama = new google.maps.StreetViewPanorama(
	            document.getElementById('streetMap'), {
	              position: {lat: locx, lng: locy},
	              addressControlOptions: {
	                position: google.maps.ControlPosition.BOTTOM_CENTER
	              },
	              linksControl: false,
	              panControl: false,
	              enableCloseButton: false
	        });
	    };
	    
	    //simulation data 실행
	    function simulation(){
	    	var url = "simulation.can";
	    	$.ajax({
	    		url : url,
	    		success : function(data){
	    			
	    		},
	    		error : function(){
	    			alert('error simulation');
	    		}
	    	})
	    }
		
        //map markers from db
        function carMarker(googleMap){
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
		                    map:googleMap,
		                    /* animation:google.maps.Animation.DROP, */
		                    label:String(item.car_id)
		                });
		                googleMarkers.push(marker);
		                /* marker.setMap(map); */
		                var infowindow = new google.maps.InfoWindow({
		                    content:item.car_name //html문서처럼 만든 것을 변수로 넣자
		                    
		                });
		                marker.addListener('click',function(){
		                    /* infowindow.open(googleMap,marker); */
		                    getStatus(item.car_id);
		                    initPano(Number(item.cur_location_x),Number(item.cur_location_y));
		                });
		            });
	    			
	    		},
	    		error : function(){
	    			alert('error');
	    		}
	    	})
	    };
	    
	    //Charge Station Marker
	    function stationMarker(googleMap){
	    	var mcenter = new google.maps.LatLng(
	    			37.368305, 127.323782		
	    	);
	    	var marker = new google.maps.Marker({
	    		position : mcenter,
	    		map:googleMap,
	    		label:"station",	
	    		icon:'resources/icon_img/charge.png'
	    	});
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
					var Markers = data;
					
					$(Markers).each(function(i,item){
		                var mcenter = new google.maps.LatLng(
		                    item.p_location_x,item.p_location_y
		                );
		                var marker = new google.maps.Marker({
		                    position:mcenter,
		                    map:googleMap,
		                    animation:google.maps.Animation.DROP,
		                    /* label:String(item.car_id), */
		                    icon:'resources/icon_img/event-icon.png'
		                });
		                eventMarkers.push(marker);
		                var arrnum = eventMarkers.length-1;
		                /* marker.setMap(map); */
		                if(item.p_load == null){
		                	item.p_load = '-';
		                }
		                var infowindow = new google.maps.InfoWindow({
		                    content:'<div>관리자: '+item.a_id+
		                    '<br>위치정보: '+item.p_location_x+'&nbsp;'+item.p_location_y+
		                    '<br>'+item.p_load+'<br><button onclick="removeEventMarker('+arrnum+')">지우기</button></div>' 
		                    //html문서처럼 만든 것을 변수로 넣자
		                   
		                });
		                
		                marker.addListener('click',function(){
		                    infowindow.open(googleMap,marker);
		                    getStatus(item.car_id);
		                    initPano(Number(item.p_location_x),Number(item.p_location_y));
		                });
		            });
					
				},
				error : function(){
					alert('error');
				}
			})
		};
		
		//event Marker delete
		function removeEventMarker(arrnum){
		    eventMarkers[arrnum].setMap(null);
		}
		
		//googlemap에 마커 표시, null 인자는 marker hide
		function setMapOnAll(googlemap) {
			  for (var i = 0; i < googleMarkers.length; i++) {
			    googleMarkers[i].setMap(googlemap);
			  }
		};
		
		//차량 마커 다시 그리기
		function moving(){
			setMapOnAll(null);
			googleMarkers = [];
			carMarker(googleMap);
		};	
	    
	    
	    //ready function
		$( document ).ready(function() {
		    console.log( "ready!" );
		    
		    //list-group-item active 설정
		    var lBtn = $(".list-group-item");    //  ul > li 이를 sBtn으로 칭한다. (클릭이벤트는 li에 적용 된다.)
		    lBtn.click(function(){   			// sBtn에 속해 있는  a 찾아 클릭 하면.
		     	lBtn.removeClass("active");     // sBtn 속에 (active) 클래스를 삭제 한다.
		     	$(this).addClass("active"); 	// 클릭한 a에 (active)클래스를 넣는다.
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
		    
		    
	        setInterval(() => {
				moving();
			}, 10000);
		    getListGroup('carList');
		    map();
		    initPano(37.368856,127.324209);
		    
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
              <a class="nav-link" href="#">${login_admin.a_name } 님 접속중
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="logout.can">로그아웃</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#" onclick="simulation()">Simulation</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Reset</a>
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
          
    <!-- 리스트 출력 -->
    		<div id="listgroupitem"></div>
	<!-- 리스트 출력 -->
          
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

         <div class="card mt-4">
            <div class="card-body card-map">
              <!-- <h3 class="card-title">MAP</h3>
              <p class="card-text">이곳에 지도가 위치합니다.</p> -->
            </div>
         </div>
          <!-- /.card -->
		 	<div class="row">
		 	<div class="card card-outline-secondary my-4 col-lg-8">
				<div class="card-header">차량 상세 정보</div>
				<div class="card-body card-status " id="carstatus">
					<!-- 이곳에 상세정보가 위치합니다 -->
				</div>
			</div>
			<div class="card-body col-lg-4" id="streetMap">
					<!-- 이곳에 스트리트 맵이 위치합니다. -->
				</div>
			<!-- /.card -->	
			</div>
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
	<script src="http://maps.google.com/maps/api/js?sensor=false&key=AIzaSyD4gVzisCa3cQKKe62jpjGYAl8E6UytmQA&callback=initPano"></script>
  </body>

</html>
