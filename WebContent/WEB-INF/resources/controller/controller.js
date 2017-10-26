var myapp= angular.module('myapp',[]);
myapp.controller('appctrl',['$scope','$http','userService',function($scope,$http,userService){

	$scope.contactlist = [];
	$scope.getList=function(){
		console.log("in get");
		var list = userService.getList();
		list.then(function(data){
	          $scope.contactlist = data;
	     });
		$scope.contact="";
	};

	$scope.addcontact=function(contact){
		console.log("in add");
		userService.addcontact(contact);
		$scope.contact = $scope.getList();
		var list = userService.getList();
		list.then(function(data){
	          $scope.contactlist = data;
	     });
	};

	$scope.remove = function(contact){
		console.log("in delete");
		var id = contact.id;
		userService.remove(id);
		var list = userService.getList();
		list.then(function(data){
	          $scope.contactlist = data;
	     });
	};

	$scope.edit = function(contact){
		console.log("in edit");
		var id = contact.id;
		var contact = userService.edit(id);
		contact.then(function(data){
			console.log(data);
	          $scope.contact = data;
	     });
	};

	$scope.update = function(contact){
		console.log("in update");
		if ($scope.contact){
			var id = contact.id;
			var contact = userService.update(id,$scope.contact);
			contact.then(function(data){
				console.log(data);
				$scope.getList();	
		     });
		}
		else{
		alert("click on edit for the contact that u want to update");
		}
	};

	$scope.clear = function(){
		$scope.contact="";
	};

}]);
