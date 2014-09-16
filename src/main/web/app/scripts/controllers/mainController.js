'use strict';

/**
 * @ngdoc function
 * # MainCtrl
 */
angular.module('BootstrapApplication.controllers')
        .controller('MainCtrl', ['$scope', 'ClientService', function ($scope, ClientService) {
            $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
            ];
            $scope.alerts = [];

            $scope.getClients = function() {
                ClientService.getClients(function(data) {
                        $scope.clients = data;
                    });
            };

            $scope.getClients();

            $scope.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };
        }]);
