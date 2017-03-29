<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" ng-app="myApp">
<head>
    <title></title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.4.2/angular-ui-router.js"></script>
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
            <a ui-sref="home" ui-sref-active="activeState">Home</a>
            <a ui-sref="courses" ui-sref-active="activeState">Courses</a>
            <a ui-sref="studentParent.students" ui-sref-active="activeState">Students</a>
        </td>
        <td class="mainContent">
            <ui-view></ui-view>
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