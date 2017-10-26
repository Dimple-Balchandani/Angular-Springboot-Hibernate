angular.module('myapp').service('userService',function($http)
{
	this.contactlist = [];
	this.getList=function(){
		return $http({
            method: 'GET',
            url: '/Crud/User',
        }).then(function(response) {
        	return response.data;
        });
	};
	
	
	this.addcontact=function(contact){
		$http.post('/Crud/User',contact).success(function(response){
			console.log("contact added");
		});
	};

	this.remove = function(id){
		$http.delete('/Crud/User/'+id).success(function(response){
			console.log("contact removed");
		});
	};

	this.edit = function(id){
		return $http({
	        method: 'GET',
	        url: '/Crud/User/'+id,
	    }).then(function(response) {
	    	console.log(response);
	    	return response.data;
	    });			
	};

	this.update = function(id, contact){
		return $http({
	        method: 'PUT',
	        url: '/Crud/User/'+id,
	        data: contact
	    }).then(function(data) {
	    	console.log("contact updated");
	       	return data;
	    });		
	};


});