angular.module('userCtrl', ['userService', 'authService'])

  .controller('userController', function($rootScope, $location, User, Auth, AuthToken){
    var vm = this;
//    vm.userData = {};
    vm.login = function(){
      Auth.login(vm.loginData.email, vm.loginData.password).success(function(data){
        if (data.erros && data.errors.length > 0){
          vm.errors = data.errors	
//          vm.userData = {};
        }else{
        	$location.path('/');
        	vm.errors = '';
        	
//          vm.error = data.message;
        }
      });
    }
    vm.register = function(){
      User.create(vm.userData).success(function(data){
    	console.log(data);
        if (data.errors && data.errors.length > 0){
        }else{
        	AuthToken.setToken(data.token);
        	$location.path('/');
        	vm.userData = {};
        }
      });
    }
  });
