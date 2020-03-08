// 순서가 중요하다 ㄷㄷㄷ
var stockTemaplate1 = "<tr>" 
//				        +"<td>{{stock.code }}</td>"
				        +"<td>{{stock.date }}</td>"
				        +"<td>{{stock.close | decipoint(2) }}</td>"
				        +"<td>{{stock.amount }}</td>"
				        +"<td>{{stock.each_rs_52w | decipoint(2) }}</td>"
				        +"<td>{{stock.all_rs_52w | decipoint(2) }}</td>"
				        +"<td>{{stock.rs | decipoint(2) }}</td>"
				        +"<td>{{stock.long_rs | decipoint(2) }}</td>"
				        +"<td v-bind:class='{\"red\": stock.mrs<0 }'>{{stock.mrs | decipoint(2) }}</td>"
				    +"</tr>";
var stockTemaplate2 = "<option v-bind:value='meta.stock_code'>{{meta.stock_name}}</option>";

var stockOptions = {
	props:['meta'],
	template : stockTemaplate2	
}
var stockItem = {
	props:['stock'],
	template : stockTemaplate1
};

var vueApp = new Vue({
	el : '#vue-app',
	data : {
		stockList : []
		, buttonLockFlag : 0
		, stockMeta : {}
		, codeList : []
		, selectedStockCodeByName : ''
			
	},
	
	computed : {
		mrsPlMi : function mrsPlMi(param1,param2){
			console.log('testset');
			return {'test':'test1'};
		}
	},
	created : function(){
		console.log("created!!");
		this.codeList = JSON.parse(document.getElementById('codeListRaw').value);
		
	},
	
	components : {
		'stock-item' : stockItem
		, 'meta-item' : stockOptions
	},
	
	methods : {
		searchStocks : function() {
			console.log('searchStocks');
			Commons.lockButtons();
			var params = {};
			params['search_type'] = document.searchForm.search_type.value;
			params['search_value'] = document.searchForm.search_value.value;
			
			if( ! validationSearch(params['search_type'], params['search_value']) ) {
				return false;
			}
			AjaxUtil.getStockJson('/getStockJsonData', params, SetVueData.stockDataCallback );
		},
		
		selectStockOnSelect : function(){
			console.log('selectStockOnSelect');
			document.searchForm.search_type.value = 'C';
			document.searchForm.search_value.value = this.selectedStockCodeByName;
			
			
			
		}
	}
});
var validationSearch = function(search_type, search_value){
	if( search_value === undefined || search_value === null || search_value.trim() === '' ){
		
		alert("검색어를 입력해주십시오");
		return false;
		
	}
	
	if(search_type==='C' && search_value.trim().length!==6){
		//TODO 숫자인거 체크하는 로직 필요
		alert("코드는 6자리 숫자입니다.");
		return false;
	}
	
	return true;
}
var SetVueData = {
	stockDataCallback : function (obj){
		vueApp.stockList = obj.dataList;
		vueApp.stockMeta = obj.stockMeta;
		Commons.unlockButtons();
	}
}

const Commons = {
		
		lockButtons : function (){
			vueApp.buttonLockFlag=1;

		},
		unlockButtons : function(){
			vueApp.buttonLockFlag=0;

		}
	
		
}
