<!DOCTYPE html>
<html ng-app="myApp">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
    <link href="../../resources/css/style12.css" rel="stylesheet"/>
    <base href="/">
</head>

<body >

<p><a href="#/">Main</a></p>

<a href="red">Red</a>
<a href="green">Green</a>
<a href="blue">Blue</a>

<ng-view></ng-view>


<p>Click on the links.sdf </p>

<p>This example uses the ng-view directive as an attribute to a DIV element.</p>


<script>
    var app = angular.module("myApp", ["ngRoute"]);
    app.config(function($routeProvider, $locationProvider) {
        $routeProvider
            .when("/", {
                templateUrl : "home.html"
            })
            .when("/red", {
                templateUrl : "/resources/templates/main.html"
            })
            .when("/green", {
                template : "students.html"
            })
            .when("/blue", {
                template : "blue.htm"
            }).otherwise({
                redirectTo: "/red"
        })
        ;

        $locationProvider.html5Mode(true);

    });
</script>
</body>
</html>