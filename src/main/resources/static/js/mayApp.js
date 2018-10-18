var app=angular.module('CompteApp',[]);
app.controller('CompteController', function($scope,$http){
	$scope.compte={};
	$scope.codeCompte=null;
	$scope.chargerCompte=function(){
		$http.get("http://localhost:8090/comptes/"+$scope.codeCompte)
		     .success(Function(data){
		    	 alert('test')
		    	 console.log(data);
		    	 $scope.compte=data;
		     });
	}
		
	}
	
})