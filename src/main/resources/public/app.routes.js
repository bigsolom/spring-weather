angular.module('appRoutes', ['ngRoute']).config(function($routeProvider, $locationProvider){
	$routeProvider

	// route for the home page
	.when('/', {
		templateUrl : 'views/home.html',
		controller: 'weatherController',
		controllerAs: 'weather'
	})

	// login/ register page
	.when('/start', {
		templateUrl : 'views/start.html',
			controller  : 'userController',
			controllerAs: 'start'
	})


	$locationProvider.html5Mode(true);

});
