let app = angular.module('app', []);
app.controller('formController', function($scope) {

    $scope.radioClick = function(value) {
        if (value==='hide'){
            $scope.show = false;
        }else{
            $scope.show = true;

        }
    };
    $scope.invoice = {};
    $scope.delivery = {};

    $scope.copyAddresses = function() {
        if ($scope.copyAddress) {
            console.log("Copy");
            $scope.invoice = angular.copy($scope.delivery);
        }
        else {
            console.log("Clear");
            $scope.invoice = angular.clear;
        }
    }
    $scope.$watch('delivery', function(newValue) {
        if (newValue) {
            console.log("callingCopyAdress");
            $scope.copyAddresses();
        }
    }, true);
});