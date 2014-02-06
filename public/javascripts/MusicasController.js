(function ($) {

	'use strict';

	/* Controllers */

	window.Application = window.Application || {};
	var Application = window.Application;

	var CONFIG = Application.CONFIG || {};

	CONFIG.URL_BASE = "http://localhost:9000/";
	
	var musicasApp = angular.module('musicasApp', ['ngResource']);
	
	musicasApp.controller('MusicasController', function($resource, $scope) {
		
		var musicsService = $resource(CONFIG.URL_BASE + "musics");			
		
		var data = musicsService.query({}, function(){
			$scope.musics= data;
		});
	});

})();