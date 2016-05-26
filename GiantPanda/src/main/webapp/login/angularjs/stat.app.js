(function (){
			"use strict";
			var ChartModel=angular.module('myModel', ['chart.js']);
			ChartModel.controller('ChartController',['$scope', function($scope){
				  $scope.labels = ["January", "February", "March", "April", "May", "June", "July"];
				  $scope.series = ['Series A', 'Series B'];
				  $scope.chartdata = [
				    [65, 59, 80, 81, 56, 55, 40],
				    [28, 48, 40, 19, 86, 27, 90]
				  ];
				  $scope.onClick = function (points, evt) {
				    console.log(points, evt);
				  };
				  /*var spans=$("#line");
		          for(var i=0;i<spans.length;i++){
		        	  if("line-legend-icon"==spans[i].className){
		        		  $(spans[i]).bind('click',function(index){
		        			 return  function(){
		        				 $scope.data=[[4,5,4,4,3,2,3]];
		        			  }
		        		  }(i));
		        	  }
		          }*/
				  
				  
				  
				 
			  }]);
})();
