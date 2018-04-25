let app = angular.module('app', []);
app.controller('formController', function($scope) {
    $scope.hide = true;
    $scope.checkboxClick = function() {
        $scope.hide = !$scope.hide;
    };
    $scope.radioClick = function(value) {
        if (value==='hide'){
            $scope.show = false;
        }else{
            $scope.show = true;

        }
    };


});