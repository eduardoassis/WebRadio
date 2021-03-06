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

			while (divAudio.hasChildNodes()){
			    divAudio.removeChild(divAudio.lastChild);
			}
			
			var source = document.createElement('source');
			source.type = 'audio/mpeg';
			source.src = CONFIG.URL_BASE + 'musics/' + music.id + '/music.mp3';
			
			var audio = document.createElement('audio');
			audio.setAttribute('controls');
			audio.setAttribute('autoplay');
			
			audio.appendChild(source);
			
			divAudio.appendChild(audio);
		};	
		
		$scope.getMusics = function(idInput){
			
			
			if($('#' + idInput).val() != "") {
				var musicService = $resource(CONFIG.URL_BASE + "musics/filter/" + $('#' + idInput).val());
			
				var data = musicService.query({}, function(){
					$scope.musics= data;
				});
			} else {
				var data = musicsService.query({}, function(){
					$scope.musics= data;
				});
			}
		}
	});

	
})($);