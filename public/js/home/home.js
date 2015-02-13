var stimoModule = angular.module('stimoModule',['ui.select']);

stimoModule.factory('Stimo', ['$http', function ($http) {
    return {
        getTwitt: function () {
            return $http.get('/Twitter');
        },
        create: function (deckData) {
            return $http.put('/deck', deckData);
        },
        delete: function (id) {
            return $http.delete('/deck/' + id);
        }
    };
}]);

stimoModule.controller('stimoController', ['$scope', '$routeParams', 'Stimo',
    function ($scope, $routeParams, Stimo) {

    }]);