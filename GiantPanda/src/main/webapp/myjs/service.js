$(document).ready(function(){
	var menu=[{content:"前端",id:"01",children:[{content:"1",id:"011",children:[]}]},
	          {content:"后台",id:"02",children:[{content:"1",id:"021",children:[{content:"11",id:"0211",children:[]}]},{content:"12",id:"0212",children:[]},{content:"12",id:"0213",children:[]}]},
	          {content:"数据库",id:"03",children:[{content:"1",id:"031",children:[]}]}];
		
	
	
		var attachMenu=function(_menu,parent,dire){
			var divclass=(dire)?"tooldivH":"tooldivV";
			for(var i=0;i<_menu.length;i++){
				var _div =$("<div class='"+divclass+"' id='di"+_menu[i].id+"'><label>"+_menu[i].content+"</label></div>").appendTo(parent);
				var _label=_div.find('label');
				if(_menu[i].children&&_menu[i].children.length>0){
					
					(function(i){
						
						_label.mouseenter(function(){
							attachMenu(_menu[i].children,$("#di"+_menu[i].id),!dire);
						})
						$("#di"+_menu[i].id).mouseleave(function(){
							for(var j=0;j<_menu[i].children.length;j++){
								if($("#di"+_menu[i].children[j].id))
									$("#di"+_menu[i].children[j].id).remove();
							}
						})
					})(i);
					}else{
					}
			}
		}
		attachMenu(menu,$("#mf_menu"),true);
		
		
	
	
	
  /*$.ajax({
	  url:"http://localhost:8080/GientPanda/restfulapi/mytest/",
	  type:"POST",
	  contentType:'application/x-www-form-urlencoded',
	  async:false,
	  data:{userName:'as',userRoleList:[{userRoleId:'ur1'}]}
  });*/
		
  
		
});