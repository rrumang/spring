<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자등록</title>

<!-- css, js -->
<%@include file="/WEB-INF/views/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
	$(document).ready(function(){
		var msg = '${msg}';
		if(msg != '')
			alert(msg);
		
		
		//주소 찾기 버튼 클릭 이벤트 핸들러
	    $("#addrSearchBtn").on("click", function(){
	    	 new daum.Postcode({
	    	        oncomplete: function(data) {
	    	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	    	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	    	            
	    	            //주소 input value에 설정 data.roadAddress;
	    	            //우편번로  input value 설정 data.zoncode;
	    	            $("#addr1").val(data.roadAddress);
	    	            $("#zipcd").val(data.zonecode);
	    	        }
	    	    }).open();
	    });
	    
	    //사용자 등록 버튼 클릭 이벤트 핸들러
	    $("#modifyBtn").on("click", function(){
	    	
	    	console.log("userRegBtn click");
	    	//유효성 체크
	    	
	    	//여기까지 도달하면 유효성 검사 완요(submit)
	    	$("#frm").submit();
	    });
	    
	    
	    //개발용 데이터 초기화 함수 ***** 추후 지울것!!
	    //dataInit();
	});
	
	function dataInit(){
		$("#userId").val("userTest");
		$("#name").val("대덕쓰");
		$("#alias").val("중앙쓰");
		$("#addr1").val("영민쓰");
		$("#addr2").val("204");
		$("#zipcd").val("34940");
		$("#birth").val("2019-05-31");
		$("#pass").val("userTest1234");
	}
</script>
</head>

<body>
	<!-- header -->
	<%@include file="/WEB-INF/views/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left영역 -->
			<%@include file="/WEB-INF/views/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자수정</h2>
						
							
						
						<form id="frm" class="form-horizontal" role="form" action="${cp }/userModify" method="post"  enctype="multipart/form-data">
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자사진</label>
								<div class="col-sm-10">
									<input type="file" id="file" name="profile"/>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자아이디</label>
								<div class="col-sm-10">
									<label name="userId" placeholder="사용자 아이디">${vo.userId}</label>
									<input id="userId" type="hidden" id="userId" name="userId" value="${vo.userId}"/>
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">사용자
									이름</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name"
										name="name" placeholder="사용자 이름" value="${vo.name }">
								</div>
							</div>
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">별명</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="alias"
										name="alias" placeholder="사용자 별명" value="${vo.alias }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">주소</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="addr1"
										name="addr1" placeholder="사용자 주소" value="${vo.addr1 }" readonly>
								</div>
								<div class="col-sm-2">
									<button id="addrSearchBtn" type="button" class="btn btn-default pull-right">주소검색</button>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">상세주소</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="addr2"
										name="addr2" placeholder="상세주소" value="${vo.addr2 }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">우편번호</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="zipcd"
										name="zipcd" placeholder="사용자 우편번호" value="${vo.zipcd }" readonly>
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">생일</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="birth"
										name="birth" placeholder="사용자 생일" value="${birth }">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">비밀번호</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass"
										name="pass" placeholder="사용자 비번" value="${vo.pass }">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="modifyBtn" type="button" class="btn btn-default">사용자 수정</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>