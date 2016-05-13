

	function initMuenu(menus,contant){
		
	var initChild=function(child,parent){
		for(var i=0;i<child.length;i++){
			var id=child[i].id;
			var childDidv=$("<div class='childdiv' id='"+id+"'><div><a href='"+child[i].url+"' target='_Blank'>"+id+"</a></div></div>");
			childDidv.appendTo(parent);
			if(child[i].child.length>1){
			(function(i){
			var id=child[i].id;
			$(childDidv).mouseover(function(){
				//alert(0);
				
					
				if(!$("#child_of_"+id).length>0){
				var childDiv=$("<div class='vdiv' id='child_of_"+id+"'></div>");
				initChild(child[i].child,childDiv);
				childDiv.width(divwidth);
				childDiv.height(30*child[i].child.length);
				childDiv.css("background-color","deeppink");
				
				childDiv.css("margin-left",divwidth);
				
				
				//childDiv.css("margin-top",30*i);
				childDiv.prependTo($("#"+id));
				}else{
					$("#child_of_"+id).css('display','block');
				}
				
			});
			$(childDidv).mouseleave(function(){
				if($("#child_of_"+id).length>0){
					/*$("#child_of_"+id).empty();
					$("#child_of_"+id).remove();*/
					$("#child_of_"+id).css('display','none');
				}
			});
			})(i);
			};
			
		}
	}	
		
	divwidth=parseInt(contant.width()/4);
	for(var i=0;i<menus.length;i++){
		var id=menus[i].id;
		var parent=contant;
		var newDiv=$("<div  class='childdivh' id='"+id+"'><div><a href='#'>"+id+"</a></div></div>");
		newDiv.appendTo(parent);
		newDiv.width(divwidth);
		(function(i){
			var id=menus[i].id;
			$("#"+menus[i].id).mouseover(function(){
					
				if(!$("#child_of_"+id).length>0){
				var childDiv=$("<div  id='child_of_"+id+"'></div>");
				initChild(menus[i].child,childDiv);
				childDiv.width(divwidth);
				childDiv.height(30*menus[i].child.length);
				childDiv.css("background-color","red");
				childDiv.appendTo($("#"+id));
				}else{
					$("#child_of_"+id).css('display','block');
				}
			});
			$("#"+menus[i].id).mouseleave(function(){
					if($("#child_of_"+id).length>0){
					/*$("#child_of_"+id).empty();
					$("#child_of_"+id).remove();*/
					$("#child_of_"+id).css('display','none');
				}
			});
		})(i);
		
		
	}
	
	}


