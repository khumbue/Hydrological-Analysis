//import express package
var express = require("express");

//import mongodb package
var mongodb = require("mongodb");

//MongoDB connection URL - mongodb://host:port/dbName
var dbHost = "mongodb://127.0.0.1:27017/HYDRA";

//DB Object
var dbObject;

//get instance of MongoClient to establish connection
var MongoClient = mongodb.MongoClient;

//Connecting to the Mongodb instance.
//Make sure your mongodb daemon mongod is running on port 27017 on 127.0.0.1
MongoClient.connect(dbHost, function(err, db){
  if ( err ) throw err;
  dbObject = db;
});

function getData(responseObj, docx){
  //use the find() API and pass an empty query object to retrieve all records
  dbObject.collection(docx.toString()).find({}).limit(100).toArray(function(err, docs){
    if ( err ) throw err;
    var dateArray = [];
    var pkfArray = [];
    var pklArray = [];

    for ( index in docs){
      var doc = docs[index];
      //category array
      var Peak_Date = doc['Peak_Date'];
      //series 1 values array
      var Peak_Flow = doc['Peak_Flow'];
      //series 2 values array
      var Peak_Level = doc['Peak_Level'];
      dateArray.push({"label": Peak_Date});
      pkfArray.push({"value" : Peak_Flow});
      pklArray.push({"value" : Peak_Level});
    }

    var dataset = [
      {
        "seriesname" : "Peak_Flow ",
        "data" : pkfArray
      }
    ];
    var dataset2 = [
      {
        "seriesname" : "Peak_Flow ",
        "data" : pklArray
      },
      {
        "seriesname" : "Peak_Level ",
        "data": pklArray
      }
    ];

    var response = {
      "dataset2" : dataset2,
      "dataset" : dataset,
      "categories" : dateArray
    };
    responseObj.json(response);
  });
}

//create express app
var app = express();
var docx = "C1H001";
//NPM Module to integrate Handlerbars UI template engine with Express
var exphbs  = require('express-handlebars');

//Declaring Express to use Handlerbars template engine with main.handlebars as
//the default layout
app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');

//Defining middleware to serve static files
app.use('/public', express.static('public'));
app.get("/peakFlows/", function(req, res){
	
  getData(res,docx);
});
app.get("/:db_doc", function(req, res){
	docx = req.params.db_doc;
	//res.send(docx.toString());
  res.render("chart");
});

app.listen("3300", function(){
  console.log('Server up: http://127.0.0.1:3300');
});
