var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
mapOption = { 
    center: new kakao.maps.LatLng(37.53401162895581, 126.99421849699539), // 지도의 중심좌표
    level: 5 // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

var markers=[];			//마커 담는 변수

var infowindows=[];	//인포윈도우를 담는 변수

var block=0;				//페이지 나누기  12345/678910/1112131415

var lastPage;

var CenterMarker;
var Centerinfowindow;

//내 위치 검색하기
function MyLocation(){
	if (navigator.geolocation) {
	    
	    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
	    navigator.geolocation.getCurrentPosition(function(position) {
	        
	        var lat = position.coords.latitude, // 위도
	            lon = position.coords.longitude; // 경도
	        
	        var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
	            message = '<div style="padding:5px;">이곳을 중심으로 검색합니다.</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        
	        var MyMarker = new kakao.maps.Marker({  
	            map: map, 
	            position: locPosition
	        }); 
	        
	        var iwContent = message, // 인포윈도우에 표시할 내용
	            iwRemoveable = true;

	        // 인포윈도우를 생성합니다
	        var Myinfowindow = new kakao.maps.InfoWindow({
	            content : iwContent,
	            removable : iwRemoveable
	        });
	        
	        // 인포윈도우를 마커위에 표시합니다 
	        Myinfowindow.open(map, MyMarker);
	        
	        // 지도 중심좌표를 접속위치로 변경합니다
	        map.setCenter(locPosition); 
	        
	        //검색 위치 추가하기
	        $("#CenterLocation_y").val(lat);
	        $("#CenterLocation_x").val(lon);
	        
	        CenterMarker=MyMarker;
			Centerinfowindow=Myinfowindow;
	      });
	    
	} else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다    
	        message = '현재 위치를 알 수 없습니다..'
	}
}

//검색 중심 변경 후 마커 위치 변경을 위한 함수
function Test3(){
	CenterMarker.setMap(null);
	Centerinfowindow.setMap(null);
	
	var lat = $("#CenterLocation_y").val();
	var lon= $("#CenterLocation_x").val();
	
	var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치
	            message = '<div style="padding:5px;">이곳을 중심으로 검색합니다.</div>'; // 인포윈도우에 표시될 내용입니다
	        
	        // 마커와 인포윈도우를 표시합니다
	        
	        var MyMarker = new kakao.maps.Marker({  
	            map: map, 
	            position: locPosition
	        }); 
	        
	        var iwContent = message, // 인포윈도우에 표시할 내용
	            iwRemoveable = true;

	        // 인포윈도우를 생성합니다
	        var Myinfowindow = new kakao.maps.InfoWindow({
	            content : iwContent,
	            removable : iwRemoveable
	        });
	        
	        // 인포윈도우를 마커위에 표시합니다 
	        Myinfowindow.open(map, MyMarker);
	        
	        // 지도 중심좌표를 접속위치로 변경합니다
	        map.setCenter(locPosition); 
	        
	        //검색 위치 추가하기
	        $("#CenterLocation_y").val(lat);
	        $("#CenterLocation_x").val(lon);
	        
	        CenterMarker=MyMarker;
			Centerinfowindow=Myinfowindow;
};

function Test(){
	$.ajax({
		type:'get',
		url:'../getLocationList',
		data:$("form[name=search-form]").serialize(),
		async:false,
		dataType:'json',
		success:function(result){
			
			try{
				for ( var i = 0; i < markers.length; i++ ) {
		    	markers[i].setMap(null);
		    	infowindows[i].setMap(null);
				}
				
				markers=[];
				infowindows=[];
				}catch(error){
				}finally{} 
				var imageSrc ='https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png';
				
				for (var i = 0; i < result.length; i ++) {
				    
				    // 마커 이미지의 이미지 크기 입니다
				    var imageSize = new kakao.maps.Size(36, 37);
				    var imgOptions =  {
		            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
		            spriteOrigin : new kakao.maps.Point(0, (i*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
		            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
		        }
				    
				    // 마커 이미지를 생성합니다    
				    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions); 
				    
				    // 마커를 생성합니다
				    var marker = new kakao.maps.Marker({
				        map: map, // 마커를 표시할 지도
				        position: new kakao.maps.LatLng(result[i].location_y, result[i].location_x), // 마커를 표시할 위치
				        title : result[i].shopName, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
				        image : markerImage // 마커 이미지 
				    });
				    
				    var iwContent = '<div id="infomation" style="padding:5px;">'+ result[i].shopName+'<br><a>'+result[i].shop_phone_number+'</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
				        iwPosition = new kakao.maps.LatLng(result[i].location_y, result[i].location_x); //인포윈도우 표시 위치입니다

				    // 인포윈도우를 생성합니다
				    var infowindow = new kakao.maps.InfoWindow({
				        position : iwPosition, 
				        content : iwContent,
				        removable:true
				    });
				    markers.push(marker);
				    infowindows.push(infowindow);
				    
				    kakao.maps.event.addListener(markers[i], 'click', makeOverListener(map, markers[i], infowindows[i]));
				    
				    }

				for(var i=0;i<markers.length; i++){
			    	markers[i].setMap(map);
				}
				
				var searchPost=document.getElementById('searchPost'); //붙일 div
				
				console.log(searchPost);
				
				//searchPost.remove();
				
				$("#searchPost *").remove();
				
				for(var i=0;i<result.length; i++){
				
				var newDIV = document.createElement("div");	//새로 생성된 div
				newDIV.setAttribute("class","main_right");
				
				var newIMG = document.createElement("img");
				newIMG.src="../resources/upload/"+result[i].si_realname;
				
				var newDIV2 = document.createElement("div");	//새로 생성된 div
				newDIV2.innerHTML=result[i].shopName+"\r\n"+result[i].shoppay;
				
				var newDIV3 = document.createElement('a');
				var AText= document.createTextNode("자세히 보기");
				newDIV3.setAttribute('href', "userSupport.do?board_owner_seq="+result[i].board_owner_seq);
				newDIV3.appendChild(AText);
				
				searchPost.appendChild(newDIV);
				newDIV.appendChild(newIMG);
				newDIV.appendChild(newDIV2);
				newDIV.appendChild(newDIV3);
				}
		},
		 error:function(request,status,error){
             alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
	})
	
}  //function Test(){

function Test2(){
$.ajax({
		type:'get',
		url:'../getLocationListCount',
		data:$("form[name=search-form]").serialize(),
		async:false,
		dataType:'json',
		success:function(result){
		
		var searchPost=document.getElementById("divPagingMap");
		
		$("#divPagingMap *").remove();
		
		if(block!=0){
			var newDIV = document.createElement("div");
			newDIV.setAttribute("class","prevPage");
			newDIV.innerHTML="<a>◀</a>";
			searchPost.appendChild(newDIV);
			};
		
		for(var i=block*5; i<(block+1)*5; i++){
		if(i==result.maxPage) {break};
		    var newDIV = document.createElement("div");	//새로 생성된 div
			    newDIV.setAttribute("class","numberPage");
				var z=i+1;
				newDIV.innerHTML="<a>"+z+"<a>";
				searchPost.appendChild(newDIV);
		}
		
		if((block+1)*5<result.maxPage){
		var newDIV = document.createElement("div");
			newDIV.setAttribute("class","nextPage");
			newDIV.innerHTML="<a>▶</a>";
			searchPost.appendChild(newDIV);
		}
		
		lastPage=result.maxPage;
		
		},
		error:function(){
		alert("실패")}
	}) // $.ajax({
}

//인포윈도우를 표시하는 클로저를 만드는 함수입니다 
function makeOverListener(map, marker, infowindow) {
    return function() {
        infowindow.open(map, marker);
    };
}

//들어가자마자 내위치 검색


// dd를 누를 때 나옴

MyLocation();

$(function(){
	//맨처음 화면을 불러올 때 쓸 함수

	Test();
	Test2();
	
	
//검색 클릭 시
	$("#em").click(function(){
		Test();
		Test2();
})//전체 불러오기

// 페이지번호 클릭시 불러올때
	$("#divPagingMap").on("click", ".numberPage", function(){
	var z=$(this).text();
	console.log(z);
	
	Test2();
	if(lastPage<z) z=lastPage;
	
	$("#pageNum").val(z);
	Test();
	$("#pageNum").val(1);
	});

//이후 페이지단을 불러올때	
	$("#divPagingMap").on("click",".nextPage",function(){
	var z = (block+1)*5+1;
	block=block+1;
	
	$("#pageNum").val(z);
	Test2();
	
	Test();
	$("#pageNum").val(1);
	});
	
//이전 페이지 단을 불러올 때
	$("#divPagingMap").on("click",".prevPage",function(){
	var z = block*5;
	block=block-1;
	$("#pageNum").val(z);
	Test2();
	
	Test();
	
	$("#pageNum").val(1);
	});
	
//검색의 중심 좌표 이동 시 사용
	$("#mapPanTo").click(function(){
	var y= $("#CenterLocation_y").val();
	var x= $("#CenterLocation_x").val();
	
	var moveLatLon= new kakao.maps.LatLng(y,x);
	
	map.panTo(moveLatLon);
	});
	
	//검색 중심 위치 변경을 위한 함수
	$("#moveCenterLocation").click(function(){
	
	openWin=window.open("locationExchange.do","childForm","width=1300, height=700, resizable = no, scrollbars = no");
	
	});
	
})

// 마커 이미지의 이미지 주소입니다