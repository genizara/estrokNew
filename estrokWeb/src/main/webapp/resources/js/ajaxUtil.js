const AjaxUtil = {

		getStockJson : function getStockJson(url, params, callback){
			var xhr = new XMLHttpRequest();
			xhr.open('PUT', url);
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onload = function() {
			    if (xhr.status === 200) {
			        var result = JSON.parse(xhr.responseText);
			        callback(result);
			    }else {
			    	console.log('error : ' + xhr.status);
			    	
			    }
				Commons.unlockButtons();

			};
			xhr.send(JSON.stringify(params));
		}
		
}
