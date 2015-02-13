var app = angular.module('stimoApp', ['ngRoute','stimoModule']);


app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
        when('/home', {
            templateUrl: 'partials/home.html',
            controller: 'stimoController'
        }).
        otherwise({
            redirectTo: '/home'
        });
}]);

/*app.run(function($rootScope, $location, $window, AuthenticationService) {
    $rootScope.$on("$routeChangeStart", function(event, nextRoute, currentRoute) {
        //redirect only if both isAuthenticated is false and no token is set

    });
});*/

/*app.controller('menuCtrl', ['$rootScope','$http','$scope', '$window', '$location',
                function($rootScope,$http,$scope, $window, $location){
	console.log("Hello new application");
}]);*/
