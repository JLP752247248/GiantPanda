		
		
		
		
		
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