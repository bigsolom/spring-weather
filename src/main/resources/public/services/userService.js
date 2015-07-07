angular.module('userService', [])

.factory('User', function($http) {

  // create a new object
	var userFactory = {};

	// get a single user
	userFactory.create = function(userData) {
		return $http.post('/api/users/', userData);
	};

  return userFactory;


});
