var model=angular.module('myModel', ['restangular']);
model.config(['$httpProvider', function($httpProvider) {
	$httpProvider.defaults.headers.put['Content-Type'] = 'application/json';
	$httpProvider.defaults.headers.post['Content-Type'] = 'application/json';
	//$httpProvider.defaults.headers.post['Accept'] = 'application/json';
	}]);
model.factory("myService1", ['Restangular', function(Restangular) {
	 var UserList=Restangular.all("GientPanda/restfulapi/userinfoctrl");
	 return UserList;
}]);
model.controller('TestController',['$scope','$timeout',"myService1","$http", function($scope,$timeout,myService1,$http){
	//var user=myService1.customGET("u1");
	/*user.then(function(data){
		data.post();
	});*/
	
	/*$http({
         method:"POST",
         headers : { 'Content-Type': 'application/x-www-form-urlencoded' },
         url:"http://localhost:8080/SSSdemo/restfulapi/mytest/", 
         params:{"userName":"www","password":"234dd"}
     }).success(function(data) {
         console.log(data);
     }).error(function() {
         alert("fail...");
     });*/
	//myService1.post({'userId':'u3','userName':'as'});
	var user={userName:'as',userRoleList:[{userRoleId:'ur1'}]};
	/*myService1.post(user).then(
			function(){
				
			}
	);*/
	$scope.post=function(){myService1.customPOST(user,"",{}).then(
			function(){
				
			}
	);}
	$scope.list=function(){
		myService1.customGET().then(function(data){
			console.log(data);
		});
	}
	
	$scope.export=function() {
		$('#tbtoexp').tableExport({type:'excel',escape:'false'});
    }
  }]);
