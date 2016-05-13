$(function(){
	var menus = [{
	id: "1",
	url: "",
	isdir: 1,
	child: [{
		id: "1_1",
		url: "#",
		isdir: 1,
		child: []
	}, {
		id: "1_2",
		url: "#",
		isdir: 1,
		child: [{
				id: "1_2_1",
				url: "http://www.baidu.com",
				isdir: 0,
				child: [{
						id: "1_2_1_1",
						url: "http://www.baidu.com",
						isdir: 0,
						child: []
					}, {
						id: "1_2_1_2",
						url: "http://www.souhu.com",
						isdir: 0,
						child: []
					}

				]
			}, {
				id: "1_2_2",
				url: "http://www.souhu.com",
				isdir: 0,
				child: []
			}

		]
	}]
}, {
	id: "2",
	url: "#",
	isdir: 1,
	child: []
}, {
	id: "3",
	url: "#",
	isdir: 1,
	child: []
}, {
	id: "4",
	url: "#",
	isdir: 1,
	child: [{
		id: "4_1",
		url: "#",
		isdir: 1,
		child: []
	}, {
		id: "4_2",
		url: "#",
		isdir: 1,
		child: [{
				id: "4_2_1",
				url: "http://www.baidu.com",
				isdir: 0,
				child: []
			}, {
				id: "4_2_2",
				url: "http://www.souhu.com",
				isdir: 0,
				child: []
			}

		]
	}]
}];
	
	
	initMuenu(menus,$("#menubox"));
	$(window).resize(function(){
		$("#menubox").empty();
		initMuenu(menus,$("#menubox"));
	});
	
})
