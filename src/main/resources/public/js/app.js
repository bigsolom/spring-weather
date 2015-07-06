// name our angular app
angular.module('weatherApp', [])

.controller('userController', function() {

	// bind this to vm (view-model)
  var vm = this;	


	// information that comes from our form
  vm.userData = {};
  
  vm.users = [
     {name: 'Eslam', password: 'sds', mobile: '05545454', email:'esd@f.com'}
  ];

  vm.register = function() {
      
      // add a computer to the list
      vm.users.push({
          name: vm.userData.name,
          email: vm.userData.email,
          password: vm.userData.password,
          mobile: vm.userData.mobile
      });

      // after our computer has been added, clear the form
      vm.userData = {};
  };

});