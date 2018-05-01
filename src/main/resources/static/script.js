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

    var date = new Date();
    if (date.getHours() > 14) {
        date.setDate(date.getDate() + 2);
    }
    var dd = date.getDate();
    var mm = date.getMonth()+1; //January is 0!
    var yyyy = date.getFullYear();
    if(dd<10){
        dd='0'+dd;
    }
    if(mm<10){
        mm='0'+mm;
    }
    var date =''+yyyy+'-'+mm+'-'+dd+'';
    $(document).ready(function() {
        $("#deliveryDate").attr("min", date);
    });
});