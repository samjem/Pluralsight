var app = angular.module("myApp");

app.controller("MainController", function($scope, $http) {
    $scope.message = "hello world";
    
    console.log($scope.username);
    
   $scope.change = function change(username) {
       $http.get("https://api.github.com/users/" + username).then(function(response){
        $scope.user = response.data;
    });
       console.log(username);
   };

    $http.get("https://api.github.com/users/robconery").then(function(response){
        $scope.user = response.data;
    });
});

app.controller("TestController", function($scope) {
    $scope.message = "hello Stratford";
});

app.controller("ApiController", function($scope, $http) {
    $http.get("http://localhost:9090/exercise-service/webapi/activities").then(function(response){
        $scope.response = response.data;
        console.log($scope.response);
    });
});

