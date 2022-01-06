<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>동동이를 이용하여 로드뷰와 지도 연동하기</title>
    <style>
    .map_wrap {overflow:hidden;height:500px}
    /* 지도위에 로드뷰의 위치와 각도를 표시하기 위한 map walker 아이콘의 스타일 */
    .MapWalker {position:absolute;margin:-26px 0 0 -51px}
    .MapWalker .figure {position:absolute;width:25px;left:38px;top:-2px;
        height:39px;background:url(https://t1.daumcdn.net/localimg/localimages/07/2018/pc/roadview_minimap_wk_2018.png) -298px -114px no-repeat}
    .MapWalker .angleBack {width:102px;height:52px;background: url(https://t1.daumcdn.net/localimg/localimages/07/2018/pc/roadview_minimap_wk_2018.png) -834px -2px no-repeat;}
    .MapWalker.m0 .figure {background-position: -298px -114px;}
    .MapWalker.m1 .figure {background-position: -335px -114px;}
    .MapWalker.m2 .figure {background-position: -372px -114px;}
    .MapWalker.m3 .figure {background-position: -409px -114px;}
    .MapWalker.m4 .figure {background-position: -446px -114px;}
    .MapWalker.m5 .figure {background-position: -483px -114px;}
    .MapWalker.m6 .figure {background-position: -520px -114px;}
    .MapWalker.m7 .figure {background-position: -557px -114px;}
    .MapWalker.m8 .figure {background-position: -2px -114px;}
    .MapWalker.m9 .figure {background-position: -39px -114px;}
    .MapWalker.m10 .figure {background-position: -76px -114px;}
    .MapWalker.m11 .figure {background-position: -113px -114px;}
    .MapWalker.m12 .figure {background-position: -150px -114px;}
    .MapWalker.m13 .figure {background-position: -187px -114px;}
    .MapWalker.m14 .figure {background-position: -224px -114px;}
    .MapWalker.m15 .figure {background-position: -261px -114px;}
    .MapWalker.m0 .angleBack {background-position: -834px -2px;}
    .MapWalker.m1 .angleBack {background-position: -938px -2px;}
    .MapWalker.m2 .angleBack {background-position: -1042px -2px;}
    .MapWalker.m3 .angleBack {background-position: -1146px -2px;}
    .MapWalker.m4 .angleBack {background-position: -1250px -2px;}
    .MapWalker.m5 .angleBack {background-position: -1354px -2px;}
    .MapWalker.m6 .angleBack {background-position: -1458px -2px;}
    .MapWalker.m7 .angleBack {background-position: -1562px -2px;}
    .MapWalker.m8 .angleBack {background-position: -2px -2px;}
    .MapWalker.m9 .angleBack {background-position: -106px -2px;}
    .MapWalker.m10 .angleBack {background-position: -210px -2px;}
    .MapWalker.m11 .angleBack {background-position: -314px -2px;}
    .MapWalker.m12 .angleBack {background-position: -418px -2px;}
    .MapWalker.m13 .angleBack {background-position: -522px -2px;}
    .MapWalker.m14 .angleBack {background-position: -626px -2px;}
    .MapWalker.m15 .angleBack {background-position: -730px -2px;}
</style>
</head>
<body>
<div class="map_wrap">
    <div id="mapWrapper" style="width:50%;height:500px;float:left">
        <div id="map" style="width:100%;height:100%"></div> <!-- 지도를 표시할 div 입니다 -->
    </div>
    <div id="rvWrapper" style="width:50%;height:500px;float:left">
        <div id="roadview" style="width:100%;height:100%"></div> <!-- 로드뷰를 표시할 div 입니다 -->
    </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=eb66f18ab68f4698ad06cb4444bfc896&libraries=services"></script>
<script>
//지도위에 현재 로드뷰의 위치와, 각도를 표시하기 위한 map walker 아이콘 생성 클래스

var forlocation_y=opener.forlocation_y;
var forlocation_x=opener.forlocation_x;
var forshopname=opener.forshopname;
var walker;
var centerloc_x=opener.centerloc_x;
var centerloc_y=opener.centerloc_y;

function MapWalker(position){

    //커스텀 오버레이에 사용할 map walker 엘리먼트
    var content = document.createElement('div');
    var figure = document.createElement('div');
    var angleBack = document.createElement('div');

    //map walker를 구성하는 각 노드들의 class명을 지정 - style셋팅을 위해 필요
    content.className = 'MapWalker';
    figure.className = 'figure';
    angleBack.className = 'angleBack';

    content.appendChild(angleBack);
    content.appendChild(figure);

    //커스텀 오버레이 객체를 사용하여, map walker 아이콘을 생성
    walker = new kakao.maps.CustomOverlay({
        position: position,
        content: content,
        yAnchor: 1,
    });

    this.walker = walker;
    this.content = content;
    
}



//로드뷰의 pan(좌우 각도)값에 따라 map walker의 백그라운드 이미지를 변경 시키는 함수
//background로 사용할 sprite 이미지에 따라 계산 식은 달라 질 수 있음
MapWalker.prototype.setAngle = function(angle){

    var threshold = 22.5; //이미지가 변화되어야 되는(각도가 변해야되는) 임계 값
    for(var i=0; i<16; i++){ //각도에 따라 변화되는 앵글 이미지의 수가 16개
        if(angle > (threshold * i) && angle < (threshold * (i + 1))){
            //각도(pan)에 따라 아이콘의 class명을 변경
            var className = 'm' + i;
            this.content.className = this.content.className.split(' ')[0];
            this.content.className += (' ' + className);
            break;
        }
    }
};

//map walker의 위치를 변경시키는 함수
MapWalker.prototype.setPosition = function(position){
    this.walker.setPosition(position);
};

//map walker를 지도위에 올리는 함수
MapWalker.prototype.setMap = function(map){
    this.walker.setMap(map);
};

/*
 * 아래부터 실제 지도와 로드뷰 map walker를 생성 및 제어하는 로직
 */
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapCenter = new kakao.maps.LatLng(forlocation_y, forlocation_x), // 지도의 가운데 좌표
    mapCenter2 = new kakao.maps.LatLng(centerloc_y, centerloc_x),
    mapOption = {
        center: mapCenter, // 지도의 중심좌표
        level: 5 // 지도의 확대 레벨
    };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 로드뷰 도로를 지도위에 올린다.
map.addOverlayMapTypeId(kakao.maps.MapTypeId.ROADVIEW);

var roadviewContainer = document.getElementById('roadview'); // 로드뷰를 표시할 div
var roadview = new kakao.maps.Roadview(roadviewContainer); // 로드뷰 객체
var roadviewClient = new kakao.maps.RoadviewClient(); // 좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

// 지도의 중심좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
roadviewClient.getNearestPanoId(mapCenter, 100, function(panoId) {
    roadview.setPanoId(panoId, mapCenter); // panoId와 중심좌표를 통해 로드뷰 실행
});

var mapWalker = null;

// 로드뷰의 초기화 되었을때 map walker를 생성한다.
kakao.maps.event.addListener(roadview, 'init', function() {

    // map walker를 생성한다. 생성시 지도의 중심좌표를 넘긴다.
    mapWalker = new MapWalker(mapCenter);
    mapWalker.setMap(map); // map walker를 지도에 설정한다.

    // 로드뷰가 초기화 된 후, 추가 이벤트를 등록한다.
    // 로드뷰를 상,하,좌,우,줌인,줌아웃을 할 경우 발생한다.
    // 로드뷰를 조작할때 발생하는 값을 받아 map walker의 상태를 변경해 준다.
    kakao.maps.event.addListener(roadview, 'viewpoint_changed', function(){

        // 이벤트가 발생할 때마다 로드뷰의 viewpoint값을 읽어, map walker에 반영
        var viewpoint = roadview.getViewpoint();
        mapWalker.setAngle(viewpoint.pan);

    });

    // 로드뷰내의 화살표나 점프를 하였을 경우 발생한다.
    // position값이 바뀔 때마다 map walker의 상태를 변경해 준다.
    kakao.maps.event.addListener(roadview, 'position_changed', function(){

        // 이벤트가 발생할 때마다 로드뷰의 position값을 읽어, map walker에 반영 
        var position = roadview.getPosition();
        mapWalker.setPosition(position);
        map.setCenter(position);

    });
    
 // 로드뷰에 올릴 마커를 생성합니다.
    var rMarker = new kakao.maps.Marker({
        position: mapCenter,
        map: roadview //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라갑니다.
    });

    // 로드뷰에 올릴 장소명 인포윈도우를 생성합니다.
    var rLabel = new kakao.maps.InfoWindow({
        position: mapCenter,
        content: forshopname
    });
    rLabel.open(roadview, rMarker);
    
    
    var Marker= new kakao.maps.Marker({
        position: mapCenter,
        map: map //map 업체
    });

    // 맵에 올릴 장소명 인포윈도우를 생성합니다.
    var Label = new kakao.maps.InfoWindow({
        position: mapCenter,
        content: forshopname
    });
    Label.open(map, Marker);
    
    
    var Marker2= new kakao.maps.Marker({
        position: mapCenter2,
        map: map //map 대신 rv(로드뷰 객체)로 설정하면 로드뷰에 올라갑니다.
    });
    var Label2 = new kakao.maps.InfoWindow({
        position: mapCenter2,
        content: "현재 위치"
    });
    Label2.open(map,Marker2);
});



</script>
</body>
</html>