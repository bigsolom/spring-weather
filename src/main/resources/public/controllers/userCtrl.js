angular.module('userCtrl', ['userService', 'authService'])

  .controller('userController', function($rootScope, $location, User){
    var vm = this;
//    vm.userData = {};
    vm.login = function(){
      Auth.login(vm.loginData.username, vm.loginData.password).success(function(data){
        if (data.success){
          $location.path('/');
          vm.error = '';
          vm.userData = {};
        }else{
          vm.error = data.message;
        }
      });
    }
    vm.register = function(){
      User.create(vm.userData).success(function(data){
    	console.log(data);
        if (data.success){
          $location.path('/');
          vm.userData = {};
        }else{
          vm.error = data.message;
        }
      });
    }
  });
