var app = angular.module('popApp', ['ngRoute', 'helloModule']);

app.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
        when('/hello', {
            templateUrl: 'partials/hello.html',
            controller: 'helloCtrl'
        }).
        when('/home', {
            templateUrl: 'partials/home.html'
        }).
        otherwise({
            redirectTo: '/hello'
        });
}]);