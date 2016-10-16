(function(){
    'user strict';

    angular
        .module('angular.app.controllers')
        .controller('UserController', ['$scope', 'Users', UserController]);

    function UserController($scope, Users){
        var ctrl = this;
        ctrl.users = [];

        function init(){
            ctrl.users = Users.data;

            var socket = new SockJS('/jaa-websocket');
            var stompClient = Stomp.over(socket);
            stompClient.connect({}, function (frame) {
                stompClient.subscribe('/topic/users', function (user) {
                    var body = JSON.parse(user.body)
                    ctrl.users.push({
                        name: body.name,
                        email: body.email,
                        created: body.created
                    });
                    $scope.$apply()
                });
            });
        }

        init();
    }

})();