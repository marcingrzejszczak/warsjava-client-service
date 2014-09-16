'use strict';

angular.module('BootstrapApplication.services')
    .factory('ClientService', ['$http', function($http) {
        var clientService = {};
        clientService.getClients = function (successFn) {
            $http({
                url: '/clients',
                dataType: 'json',
                method: 'GET',
                headers: {
                    'Content-Type': 'application/vnd.pl.warsjawa.client-service.v1+json'
                }
            }).success(function (data) {
                successFn(data);
            });
        };

        return clientService;
    }
]);
