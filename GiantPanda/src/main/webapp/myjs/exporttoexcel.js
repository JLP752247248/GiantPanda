		
		
		//导入excel
		var exportToExcel=function(){
			/* 
			$.ajax({ 
				url: "product-stat/service/stat/twodimenform/excels", 
				data:{modelName:queryName},
				type:'POST',
				success: function(){
		       		
				}
			});
			
			TwodimenForm.one("").customPOST(null,"excels",$.extend({},getQueryParms(),$scope.page,{target:'',modelName:queryName})).then(function(data1){
				
				window.open(data1);
			}) */
		   //TODO:这边不知道除了用form还有没有什么更好的办法实现后台推送一个下载到页面接受
		   var form = $("<form>");
		   form.attr('action', "/product-stat/service/stat/twodimenform/excels");
		   form.attr('style', 'display:none');
		   form.attr('target', '');
		   form.attr('method', 'post');
		   
		   /*------------------所有参数 --------------------------*/
		   var input=$("<input type=text />");
		   input.attr("name","modelName");
		   input.attr("value",queryName);
		   form.append(input);
		   //查询参数
		   var qms=getQueryParms();
		   for(var key in qms){
			   var input=$("<input type=text />");
			   input.attr("name",key);
			   input.attr("value",qms[key]);
			   form.append(input);
		   }
		   //分页
		   for(var key in $scope.page){
			   var input=$("<input type=text />");
			   input.attr("name",key);
			   input.attr("value",$scope.page[key]);
			   form.append(input);
		   }
		   /*---------------------- --------------------------*/
		   
		   
		   $('body').append(form);
		   form.submit();
		   form.empty();
		   form.remove();
		} 
		
		
		//打印表格
		var printTable=function(){
			var style="table{width:100%;font-family:verdana,arial,sans-serif;font-size:11px;color:#333;border-width:1px;border-color:#666;border-collapse:collapse;text-align:center}.tableHead{background-color:lightgrey}.tableTitle{text-align:center;font-size:x-large}table th{border-width:1px;padding:8px;border-style:solid;border-color:#666;background-color:#dedede}table td{border-width:1px;padding:8px;border-style:solid;border-color:#666;background-color:#fff}";
            var head="<html><head><style>"+style+"</style></style></head>";
            var tail="</body></html>"
            var newWindow=window.open("","_blank");
            var docStr = head+$("#normalTableBody")[0].innerHTML+tail;
            newWindow.document.write(docStr);
            newWindow.document.close();
            newWindow.print();
            newWindow.close();
            return false;
		}