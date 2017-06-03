 // Imports all the modules needed
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mongodb = require('mongodb');

var stations = require('./routes/stations.js');
var allstations = require('./routes/allstations.js');
var delStation = require('./routes/delStation.js');

//Create routes to the endpoints

app.use('/api/listStation/', stations);
app.use('/api/stations/all/', allstations);
app.use('/api/delStation/', delStation);

app.get('/', function(req, res, next) {
  res.send("Please use API endpoints")
});
app.get('/api/', function(req, res, next) {
  res.send("Please use API endpoints")
});

app.listen(3000);
console.log('Running on port 3000...');