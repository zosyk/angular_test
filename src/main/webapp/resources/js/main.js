/**
 * Created by alex on 25.03.17.
 */
var myApp = angular
    .module('myModule', [])
    .controller("countryController", function ($scope,$http, $location, $anchorScroll) {
       // $scope.scrollTo = function (scrollLocation) {
       //     $location.hash(scrollLocation);
       //     $anchorScroll.yOffset = 20;
       //     $anchorScroll();
       //
       //
       //
       // }

        $http.get("http://localhost:8080/countries")
            .then(function (response) {
                $scope.countries = response.data;
            });

        $scope.scrollTo = function (countryName) {
            $location.hash(countryName);
            $anchorScroll();
        }
    });





















    // .controller('myController', function ($scope, $http, $log, stringService) {
    //
    //
    //
    //     $scope.transformString = function (input) {
    //         $scope.output = stringService.processString(input);
    //     }
    //
    //
    //     // var employees = [
    //     //     {name: 'Ben', dataOfBirth : new Date('November 23, 1980'), gender: 1, salary : 4000.340},
    //     //     {name: 'Sara', dataOfBirth : new Date('May 24, 1920'), gender: 2, salary : 900},
    //     //     {name: 'Mark', dataOfBirth : new Date('August 3, 1983'), gender: 1, salary : 54222.340},
    //     //     {name: 'Pam', dataOfBirth : new Date('December 13, 1985'), gender: 3, salary : 800.340}
    //     // ];
    //
    //     // $http.get('http://localhost:8080/employees')
    //     //     .then(function (response) {
    //     //         $scope.employees = response.data;
    //     //
    //     //     });
    //
    //     // $http({
    //     //     method: 'GET',
    //     //     url: 'http://localhost:8080/employees'
    //     // }).then(function successCallback(response) {
    //     //     $scope.employees = response.data;
    //     //     $log.info(response);
    //     // }, function errorCallback(response) {
    //     //     $log.info(response);
    //     // });
    //     //
    //     // $scope.employeesView = 'employees_table.html';
    //
    //
    // });