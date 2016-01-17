var controllers = angular.module('app.controller', [
    'angularUtils.directives.dirPagination',
    'ngMask'
]);
var services = angular.module('app.service', []);

var app = angular.module('myApp', [
    'app.controller',
    'app.service',
    'ngRoute'
]);

app.constant('backend', 'http://localhost:7001/desafio/rest');

app.config(function ($routeProvider) {

    $routeProvider
            .when("/home", {
                controller: "UserController",
                templateUrl: "app/User/template/home.html"
            })
            .when("/cadastrar", {
                controller: "UserController",
                templateUrl: "app/User/template/cadastrar.html"
            })
            .otherwise({redirectTo: "/home"});
});