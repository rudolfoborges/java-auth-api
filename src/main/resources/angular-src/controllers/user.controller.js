(function(){
    'user strict';

    angular
        .module('angular.app.controllers')
        .controller('UserController', ['$scope', UserController]);

    function UserController($scope){
        var ctrl = this;
        ctrl.users = [];

        function init(){
            ctrl.users = Users.data;
        }

        init();
    }

})();