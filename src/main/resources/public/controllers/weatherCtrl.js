angular.module('weatherCtrl', ['weatherService'])

  .controller('weatherController', function($rootScope, Weather){
	  var vm = this;
	  
	  vm.weather = {}
	  vm.getWeather = function(){
		  Weather.getTemp().success(function(data){
			  vm.weather = data;
		  });
	  }
	  vm.getWeather();
  });
  