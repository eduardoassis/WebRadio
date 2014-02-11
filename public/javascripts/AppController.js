(function ($) {

	'use strict';

	/* Controllers */

	window.Application = window.Application || {};
	var Application = window.Application;

	var CONFIG = Application.CONFIG || {};

	CONFIG.URL_BASE = "http://localhost:9000/";
	
	var app = angular.module('app', ['ngResource']);
	
	app.controller('AppController', function($resource, $scope) {
		
		var musicsService = $resource(CONFIG.URL_BASE + "musics");		
		
		var data = musicsService.query({}, function(){
			$scope.musics= data;
		});
		
		var usersService = $resource(CONFIG.URL_BASE + "users/logged");			
		
		var user = usersService.get({}, function(){
			$scope.user = user;
		});
		
		$scope.selectedMusic = function(music) {
			
			$('.selectedMusic').removeClass('selectedMusic');
			$('#' + music.id).addClass('selectedMusic');
			
			var divAudio = document.getElementById('audio');
			
			var source = document.createElement('source');
			source.type = 'audio/mpeg';
			source.src = CONFIG.URL_BASE + 'musics/' + music.id + '/music.mp3';
			
			var audio = document.createElement('audio');
			audio.setAttribute('controls');
			
			audio.appendChild(source);
			
			divAudio.appendChild(audio);
		};		
	});

	
})($);