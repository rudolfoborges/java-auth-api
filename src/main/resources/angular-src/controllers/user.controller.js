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