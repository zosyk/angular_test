var app = angular.module("myApp", ["ngRoute"]);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "home.html"
        })
        .when("/courses", {
            templateUrl : "courses.html"
        })
        .when("/green", {
            templateUrl : "students.html"
        })
        .when("/red", {
            templateUrl : "courses.html"
        })
        .when("/blue", {
            template : "blue"
        });
});