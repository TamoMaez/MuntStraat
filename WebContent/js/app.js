	
	// init app
	var app = angular.module('bsSearch', ['ngAnimate', 'ngRoute']);
	
	// info op http://www.w3schools.com/angular/default.asp
	app.controller('bsController', ['$scope', '$http',
	                                function bsController($scope, $http) {
		// init vars
			$scope.filters = [];
			$scope.grid = true; //(nut?)
			$scope.list = [];
			
		// vraag JSON op zonder filter
			
			$http.get('Controller?action=filter').success(function(response) {
				$scope.list = response; 
				$scope.map = {};
				$scope.rows = [];
				$scope.totalBs = response.length;
				
				for (var i = 0; i < $scope.list.length; i++) {
					var j = $scope.list[i].type;
					if(j in $scope.map){
						$scope.map[j] = parseInt($scope.map[j]) +1;
					}else{
						$scope.map[j] = 1;
					}; 
				  }
				
				// aantal items in row
				/*var j = 0;
				for (var i = 0; i < $scope.list.length; i++) {
					if(i % 4 == 0){
						j ++;
						$scope.rows[j] = new Array();
					}
					$scope.rows[j].push($scope.list[i]);
				  }
				console.log($scope.rows);*/
				
				ajaxStop();
				});
			
			$scope.addFilter = function($filter) {
				$scope.filters.push($filter);
			}
			$scope.setFilter = function($filter) {
				if($filter != null) $scope.filters = [$filter];
				else $scope.filters = [];
			}
			$scope.search = function ($item){
				// zoek op slogan en naam
				var searchQuery = $scope.query != null ? $scope.query.toLowerCase() : ""; 
				return $item.naam.toLowerCase().indexOf(searchQuery || "") != -1 ||
		          $item.slogan.toLowerCase().indexOf(searchQuery || "") != -1
			  };

			$scope.filterDb  = function($url) {
				// interactie met servlet !!! alleen testing, moet performanter !!!
				//alert($url);
				ajaxStart();
				$http.get('Controller?action=filter&' + $url).success(function(response) {
					$scope.list = response; 
					});

				ajaxStop();
				};
		}
	])
	// binding 'highlight'
	.filter('highlight', function($sce) {
	    return function(text, phrase) {
	  
	        // met regex door de $scope data gaan 
	    	if (phrase) text = text.replace(new RegExp('('+phrase+')', 'gi'),
	    			// voeg klasse toe voor makkelijk met jquery te vinden ($1 is phrase)
	          '<span class="highlighted">$1</span>')
	        return $sce.trustAsHtml(text);
	      }
	    })
	  
	