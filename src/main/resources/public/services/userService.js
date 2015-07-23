angular.module('userService', [])

.factory('User', function($http) {

  // create a new object
	var userFactory = {};

	// create a new user
	userFactory.create = function(userData) {
//		userData = {"name":"Eslam Foad", "email": "efoaf3d@hotma2il", "password":"dsdsd", "mobile":"01010212"}
		return $http.post('/api/users/', userData);
	};

  return userFactory;


});
