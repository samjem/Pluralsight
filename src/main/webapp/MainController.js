 var app = angular.module("myApp");
 
 app.controller("MainController", function($scope, $http) {
 
 $scope.change = function change(username) {
       $http.get("https://api.github.com/users/" + username).then(function(response){
        $scope.user = response.data;
    });
       console.log(username);
   };
    app.controller("MainController",MainController);
 });
 
