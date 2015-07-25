angular.module('weatherService', [])

.factory('Weather', function($http) {

  // create a new object
	var weatherFactory = {};

	// today's weather
	weatherFactory.getTemp = function() {
		return $http.get('/api/weather/');
	};

  weatherFactory.getNotes = function() {
    return $http.get('/api/weather/notes');
  }

  return weatherFactory;
});
