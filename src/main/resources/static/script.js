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
    }
    $scope.$watch('delivery', function(newValue) {
        if (newValue) {
            $scope.copyAddresses();
        }
    }, true);


});