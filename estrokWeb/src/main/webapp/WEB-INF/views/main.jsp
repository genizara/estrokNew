<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-159968766-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-159968766-1');
</script>
<title>estrok</title>
	<!-- 합쳐지고 최소화된 최신 CSS -->
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"> -->
	<!-- 부가적인 테마 -->
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css"> -->
	<link rel="stylesheet" type="text/css" href="../resources/css/main.css">

</head>
<body>
<div id="vue-app" >

	HEIL ESTROK!
	<img alt="진선생&와이프" src="../resources/images/mrjin.png" style="width: 100px;">
	<div id="d3_chart_area_estork"></div>
	<select v-model="selectedStockCodeByName" v-on:change="selectStockOnSelect">
		<option value="">선택</option>
		<option is="meta-item" v-for="item in codeList" v-bind:meta="item" v-bind:key="item.seq">
	</select>	
	<section>
		<form id="searchForm" action="/main" name="searchForm">
			<label> <input type="radio" name="search_type" value="C" <c:if test="${empty search_type or search_type eq 'C' }">checked</c:if>>코드 검색 </label>	
			<label>  <input type="radio" name="search_type" value="N" <c:if test="${search_type eq 'N'}">checked</c:if>>이름 검색</label>	
			<input type="text" placeholder="코드 및 이름 ( 일치검색만 가능 )" name="search_value" value="${search_value }" style="width=300px;"/>
			<input type="button" v-on:click="searchStocks" value="검색!" :disabled="buttonLockFlag==1"/>
		</form>
	
		<div>
			<p><span>코드 : </span><span v-cloak >{{stockMeta.stock_code }}</span></p>
			<p><span>상호 : </span><span v-cloak >{{stockMeta.stock_name }}</span></p>
		</div>
		<div>
			<table class="simple-table">
				<thead>
			        <tr>
<!-- 			            <th>코드</th> -->
			            <th>날짜</th>
			            <th>가격</th>
			            <th>거래량</th>
			            <th>종목 52주 평균</th>
			            <th>시장52주 평균</th>
			            <th>RS</th>
			            <th>장기RS</th>
			            <th>MRS</th>
			        </tr>
			    </thead>
			    <tbody>
			    	<tr is="stock-item"  
			    		v-for="item in stockList" 
		    			v-bind:stock="item" 
		    			v-bind:key="item.date" >
					</tr>
			    </tbody>
			</table>
		</div>
	</section>
</div>
	<input type="hidden" value='${codeList }' id="codeListRaw"/>
</body>
	<script src="../resources/js/jquery-3.4.1.min.js" type="text/javascript"></script>
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<!-- 	상용 vue -->
	<script src="https://cdn.jsdelivr.net/npm/vue"></script>
<!-- 	개발 vue -->	
<!-- 	<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script> -->
	
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="../resources/js/d3.min.js" type="text/javascript"></script>
	<script src="../resources/js/ajaxUtil.js" type="text/javascript"></script>
	<script src="../resources/js/vueFilter.js" type="text/javascript"></script>
	<script src="../resources/js/main.js" type="text/javascript"></script>
</html>
