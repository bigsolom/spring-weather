angular.module('mainCtrl', [])

.controller('mainController', function($rootScope, $location, Auth) {
  var vm = this;

  // check to see if a user is logged in on every request
	$rootScope.$on('$routeChangeStart', function() {
		vm.loggedIn = Auth.isLoggedIn();
//		console.log(vm.loggedIn);

		// get user information on page load
		Auth.getUser()
			.then(function(data) {
				vm.user = data.data;
			});
	});

  vm.logout = function(){
    Auth.logout();
		vm.user = '';

		$location.path('/start');
  }
});
