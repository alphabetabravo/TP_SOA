var helloModule = angular.module('helloModule');


helloModule.factory('Hello', ['$http', function ($http) {
    var cors_headers = {
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, PUT'
    };
    return {
        get: function () {
            //Return ALL documents for User_ID
            return $http.get('/hello');
        }
    }
}]);

// use Controller on HTML template
helloModule.controller('helloCtrl', ['$scope','$http','Hello',
	function($scope, $http,Hello) {

		$scope.valueReturn = {};
		Hello.get.success(function (data) {
			console.log(data);
			$scope.valueReturn.Hello = data;
		});

	}]);