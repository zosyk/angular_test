var app = angular.module("myApp", ["ui.router"]);
app.config(function ($stateProvider, $urlMatcherFactoryProvider, $urlRouterProvider) {
    // $routeProvider.caseInsensitiveMatch = true;
    $urlRouterProvider.otherwise("home");
    $urlMatcherFactoryProvider.caseInsensitive(true);
    $stateProvider
        .state("studentParent", {
            abstract: true,
            url : "/students",
            controller: "studentParentController",
            templateUrl: "/resources/templates/studentParent.html",
            resolve: {
                studentsTotals: function ($http) {
                    return $http({
                        url: "/studentsTotals",
                        method: "get"
                    }).then(function (response) {
                        return response.data;
                    });
                }
            }
        })
        .state("home", {
            url: "/home",
            templateUrl: "/resources/templates/home.html",
            controller: "homeController as homeCtrl",
            data : {
                customTitle : "CustomTitle from Me"
            }
        })
        .state("courses", {
            url : "/courses",
            templateUrl: "/resources/templates/courses.html",
            controller: "coursesController",
        })
        .state("studentParent.students", {
            url: "/",
            views: {
                "studentData" : {
                    templateUrl: "/resources/templates/students.html",
                    controller: "studentsController",
                    resolve: {
                        studentsList: function ($http) {
                            return $http({
                                url: "/students",
                                method: "get"
                            }).then(function (response) {
                                return response.data;
                            });
                        }
                    }
                },
                "totalData" : {
                    templateUrl: "/resources/templates/studentsTotal.html",
                    controller: "studentsTotalController"
                }
            }

        })
    .state("studentParent.studentDetails", {
        url : "/:id",
        views: {
            "studentData" : {
                templateUrl: "/resources/templates/studentDetails.html",
                controller: "studentDetailsController"
            }
        }
    })
    .state("studentsSearch", {
        url: "/studentsSearch/:name?",
        templateUrl: "/resources/templates/studentsSearch.html",
        controller: "studentsSearchController"
    })

    // .otherwise({
    //     redirectTo: "/home"
    // })
    ;

//        $locationProvider.html5Mode(true);

});

app.controller("homeController", function ($state) {
    this.message = "test message from HomeController";
    this.message = $state.get("courses").url;
})
    .controller("studentsTotalController", function ($scope, studentsTotals) {
        $scope.total = studentsTotals.total;

    })
    .controller("studentParentController", function ($scope, studentsTotals) {
        $scope.males = studentsTotals.males;
        $scope.females = studentsTotals.females;
        $scope.total = studentsTotals.total;

    })
    .controller("coursesController", function ($scope) {
        $scope.courses = ["Java", "C#", "SQL Sever"];

    })
    .controller("studentsController", function (studentsList, $scope, $state, studentsTotals) {

        $scope.studentsTotals = studentsTotals;

        $scope.studentsSearch = function () {

            $state.go("studentsSearch", {name: $scope.name});
        };


        // $scope.$on("$locationChangeStart", function (event, next, current) {
        //     if (!confirm("Are you sure you want to navigate away from this page to " + next)) {
        //         event.preventDefault();
        //     }
        // });


        $scope.reloadData = function () {
            $state.reload();
        };

        $scope.students = studentsList;

    })
.controller("studentDetailsController", function ($scope, $http, $stateParams) {
    $http({
        url: "/student/" + $stateParams.id,
        method: "get",
    }).then(function (response) {
        $scope.student = response.data;
    })

})
.controller("studentsSearchController", function ($scope, $http, $stateParams, $log) {

    if ($stateParams.name) {

        $http({
            url: "/students/" + $stateParams.name,
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

})
;