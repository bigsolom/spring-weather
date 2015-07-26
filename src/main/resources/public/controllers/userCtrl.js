angular.module('userCtrl', ['userService', 'authService'])

  .controller('userController', function($rootScope, $location, User, Auth, AuthToken){
    var vm = this;
    $rootScope._ = _;
    vm.loginErrors = {};
    vm.registrationErrors = {};
    vm.login = function(){
      Auth.login(vm.loginData.email, vm.loginData.password).success(function(data){
        if (data.errors && typeof data.errors === 'object'){
          vm.loginErrors = data.errors	
//          vm.userData = {};
        }else{
        	$location.path('/');
        	vm.loginErrors = {};
        	
//          vm.error = data.message;
        }
      });
    }
    vm.disable = true;
    vm.isLoginEnabled = function(){
    	return vm.loginData.email.length > 0 && vm.loginData.password.length > 0
    };
    vm.register = function(){
      User.create(vm.userData).success(function(data){
//    	console.log(data);
        if (data.errors && typeof data.errors === 'object'){
        	vm.registrationErrors = data.errors;
        }else{
        	vm.registrationErrors = {};
        	AuthToken.setToken(data.token);
        	$location.path('/');
        	vm.userData = {};
        }
      });
    }
  });
