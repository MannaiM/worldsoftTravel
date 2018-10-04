(function() {
	'use strict';

	angular.module('myApp')

	.constant("GLOBAL", {

		setConnectedUser : function(user) {

			// console.log("%cset: "+JSON.stringify(user),"color:green");

			sessionStorage.setItem('connectedUser', JSON.stringify(user));

		},
		getConnectedUser : function() {
			var user = JSON.parse(sessionStorage.getItem('connectedUser'));

			// console.log("%cget:"+JSON.stringify(user),"color:green");

			return user;

		}

	}).config([ '$routeProvider', 'GLOBAL', routeProvider ]).run(
			[ '$route', routeRunner ])

	function routeProvider($routeProvider, GLOBAL, $rootScope) {

		$routeProvider

		.when('/', {
			templateUrl : 'index12.html'

		})

		.when('/:tpl', {
			templateUrl : function(attr) {

				// var page = attr.tpl;
				// var folder = attr.folder;
				// var index = -1;
				//
				// for (var int = 0; int < GLOBAL
				// .getConnectedUser().authPages.length; int++) {
				// if (GLOBAL.getConnectedUser().authPages[int].folder ==
				// folder)
				// index = int;
				// }
				//
				// if (GLOBAL.getConnectedUser().authPages[index].pages
				// .indexOf(page) > -1) {
				// return ('tpl/blank/pages/' + attr.folder
				// + '/' + attr.tpl + '.html');
				// }

				return attr.tpl + ".html";

			}
		}).when('/404', {
			templateUrl : "pages-404-3.html"

		// })
		//    
		// .when('/register', {
		// templateUrl: 'tpl/blank/register.html'

		}).otherwise({
			redirectTo : '/404'
		});

		// .when('/:tpl', {
		// templateUrl: function(attr){
		// return 'tpl/blank/' + attr.tpl + '.html';
		// }
		// })

	}

	function routeRunner($route) {

	}

})();
