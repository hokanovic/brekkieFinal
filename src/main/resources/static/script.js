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
            $scope.invoice = angular.copy($scope.delivery);
        }
         else {
             $scope.invoice = angular.clear;
         }
    }
     $scope.$watch('delivery', function(newAddress) {
         if (newAddress) {
             $scope.copyAddresses();
         }
     }, true);
});