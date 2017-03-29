<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="myApp">
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-route.js"></script>
    <script src="../../resources/js/index.js"></script>
    <link href="../../resources/css/style12.css" rel="stylesheet" />
</head>
<body>
<table style="font-family: Arial">
    <tr>
        <td colspan="2" class="header">
            <h1>
                WebSite Header
            </h1>
        </td>
    </tr>
    <tr>
        <td class="leftMenu">
            <a href="#home">Home</a>
            <a href="#courses">Courses</a>
            <a href="#students">Students</a>
        </td>
        <td class="mainContent">
            <ng-view></ng-view>
        </td>
    </tr>
    <tr>
        <td colspan="2" class="footer">
            <b>Website Footer</b>
        </td>
    </tr>
</table>

</body>
</html>