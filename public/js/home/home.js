var stimoModule = angular.module('stimoModule',['ui.select']);

stimoModule.factory('Stimo', ['$http', function ($http) {
    return {
        getTwitt: function () {
            return $http.get('/stimo/importTwitter');
        },
        getMortGage: function(parameters){
            return $http.put('/mortgage',parameters)
        },
        sortTwitt: function(sortType){
            return $http.get('/sort/'+sortType)
        },
        letsGoGoogle: function(){
            return $http.get('/googleEngine')
        }
    };
}]);

stimoModule.controller('stimoController', ['$scope', '$routeParams', 'Stimo',
    function ($scope, $routeParams, Stimo) {
	    $scope.offreTwitters = [];
	    $scope.offreSelection = false;
	    $scope.formData = {};
	    $scope.resultatSimu = false;
	    $scope.valeurSimu = {};

	    $scope.transformTwitt = function(data){
			var myString = '';
			$scope.myResult = [];
			var tab= new RegExp('\r\n|\r|\n');
	        data.forEach(function (entry) {
	            myString = entry.text;
	            console.log(myString);
	            //Test On String
	            if (myString.indexOf('http://') != -1) {
					myString = myString.substring(0,myString.indexOf('http://'));
	            }
	            if (myString.indexOf('€') != -1){
	                var elmt = myString.split(tab);
	                var elmt = elmt.filter( function(val){return val !== ''} );
	                if(elmt.length > 2){
						$scope.offreTwitters.push(elmt);
						console.log(elmt);
	                }
	            }
	        });

	    };

		$scope.getMortGage = function(){
			//console.log($scope.formData);
			Stimo.getMortGage($scope.formData)
                .success(function (data) {

                //console.log(data);
                $scope.valeurSimu = data.GetMortgagePaymentResult;
                console.log( $scope.valeurSimu);
                $scope.resultatSimu = true;
                });
		};

	    $scope.searchOnTwitter = function () {
			$scope.offreSelection = false;
	        Stimo.getTwitt()
                .success(function (data) {
                    $scope.myTwitterS = data;
                    //console.log($scope.myTwitterS);
                    $scope.transformTwitt(data);


                });

	    };

	    $scope.orderByLieux = function(){
		    console.log("OK trie selon le lieux");
	        Stimo.sortTwitt("lieux")
                .success(function (data) {
                    //$scope.myTwitterS = data;
                    //console.log($scope.myTwitterS);
                    //$scope.transformTwitt(data);


                });

	    };
	    $scope.onGoogleEngine = function(){
	        console.log("Use Database Google Engine Cloud");
			Stimo.letsGoGoogle().success(function (data) {
                });
	    }

    }]);