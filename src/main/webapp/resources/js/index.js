var app = angular.module("myApp", ["ngRoute"]);
app.config(function ($routeProvider, $locationProvider) {
    $routeProvider.caseInsensitiveMatch = true;

    $routeProvider
        .when("/home", {
            templateUrl: "/resources/templates/home.html",
            controller: "homeController as homeCtrl"
        })
        .when("/courses", {
            templateUrl: "/resources/templates/courses.html",
            controller: "coursesController",
        })
        .when("/students", {
            templateUrl: "/resources/templates/students.html",
            controller: "studentsController",
            resolve : {
                studentsList : function ($http) {
                    return $http({
                        url: "/students",
                        method: "get"
                    }).then(function (response) {
                        return response.data;
                    });
                }
            }
        })
        .when("/students/:id", {
            templateUrl: "/resources/templates/studentDetails.html",
            controller: "studentDetailsController"
        })
        .when("/studentsSearch/:name?", {
            templateUrl: "/resources/templates/studentsSearch.html",
            controller: "studentsSearchController"
        })
        .otherwise({
            redirectTo: "/home"
        })
    ;

//        $locationProvider.html5Mode(true);

});

app.controller("homeController", function () {
    this.message = "test message from HomeController";
})
    .controller("coursesController", function ($scope) {
        $scope.courses = ["Java", "C#", "SQL Sever"];

    })
    .controller("studentsController", function (studentsList, $scope, $route, $location) {

        $scope.studentsSearch = function () {

            if ($scope.name) {
                $location.url("/studentsSearch/" + $scope.name);
            } else {
                $location.url("/studentsSearch");
            }
        };


        $scope.$on("$locationChangeStart", function (event, next, current) {
            if (!confirm("Are you sure you want to navigate away from this page to " + next)) {
                event.preventDefault();
            }
        });


        $scope.reloadData = function () {
            $route.reload()
        };

        $scope.students = studentsList;

    })
    .controller("studentDetailsController", function ($scope, $http, $routeParams) {
        $http({
            url: "/student/" + $routeParams.id,
            method: "get",
        }).then(function (response) {
            $scope.student = response.data;
        })

    })
    .controller("studentsSearchController", function ($scope, $http, $routeParams, $log) {

        $log.info($routeParams.name);
        if ($routeParams.name) {

            $http({
                url: "/students/" + $routeParams.name,
                method: "get"
            }).then(function (response) {
                $scope.students = response.data;
            })
        } else {
            $http({
                url: "/students",
                method: "get"
            }).then(function (response) {
                $scope.students = response.data;
            });
        }

    });