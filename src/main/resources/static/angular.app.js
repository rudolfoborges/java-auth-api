(function(){
    'use strict';

    angular
    		.module('angular.app', ['angular.app.views', 'angular.app.controllers', 'ui.router'])
    		.config(['$locationProvider', '$stateProvider', '$urlRouterProvider', '$httpProvider', config])
            .run(['$rootScope', '$http', '$httpParamSerializer', '$anchorScroll', run])

    angular.module('angular.app.controllers', []);

    function config($locationProvider, $stateProvider, $urlRouterProvider, $httpProvider){
        $locationProvider.html5Mode(false).hashPrefix('!');

        $stateProvider
            .state('users', {
                url: '/users',
                cache: false,
                templateUrl: 'users.html',
                controller: 'UserController as ctrl',
                resolve: {
                    Users: function($http, $rootScope){
                        return $http.get($rootScope.apiURL('api/v1/user'));
                    }
                }
            })

            .state('rudolfoborges', {
                url: '/rudolfoborges',
                cache: true,
                templateUrl: 'rudolfoborges.html'
            });


        $urlRouterProvider.otherwise('/users');
    }

    function run($rootScope, $http, $httpParamSerializer, $anchorScroll){
        $rootScope.$on("$locationChangeSuccess", function() {
            $anchorScroll();
        });
    }

})();
(function(){
    'user strict';

    angular
        .module('angular.app.controllers')
        .controller('UserController', ['Users', UserController]);

    function UserController(Users){
        var ctrl = this;
        ctrl.users = [];

        function init(){
            ctrl.users = Users.data;
        }

        init();
    }

})();