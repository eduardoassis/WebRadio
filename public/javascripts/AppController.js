(function ($) {

	'use strict';

	/* Controllers */

	window.Application = window.Application || {};
	var Application = window.Application;

	var CONFIG = Application.CONFIG || {};

	CONFIG.URL_BASE = "http://localhost:9000/";
	
	var app = angular.module('app', ['ngResource','audioPlayer']);
	
	app.controller('AppController', function($resource, $scope) {
		
		var musicsService = $resource(CONFIG.URL_BASE + "musics");			
		
		var data = musicsService.query({}, function(){
			$scope.musics= data;
		});
		
		var usersService = $resource(CONFIG.URL_BASE + "users/logged");			
		
		var user = usersService.get({}, function(){
			$scope.user = user;
		});
	});

	
})();