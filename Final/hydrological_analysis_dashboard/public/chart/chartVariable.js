var myData = JSON.parse(c1h001);
var year = 0;
var plotYear = 1999;
var month = 0;
var day = 0;

var CHX = [];

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
  var url = "http://127.0.0.1:3000/api/graph/peakFlows/C1H001";
  //var url = "data.txt";
  $http.get(url)
  .then(function(response) {
      $scope.stations = response.data;
      CHX = response.data;
  });
});

myData = CHX.toArray();