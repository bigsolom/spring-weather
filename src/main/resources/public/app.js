angular.module('weatherApp', ['appRoutes', 'authService', 'mainCtrl', 'userCtrl','weatherCtrl', 'weatherService', 'userService'])

// application configuration to integrate token into requests
.config(function($httpProvider) {

	// attach our auth interceptor to the http requests
	$httpProvider.interceptors.push('AuthInterceptor');

});
