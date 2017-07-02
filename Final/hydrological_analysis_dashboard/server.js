var Model = require('./models/models.js');
var express = require('express');
var mongoose = require('mongoose');
var bodyParser = require('body-parser');
var morgan = require('morgan');

var app = express();

app.use(bodyParser.json());

app.use(bodyParser.urlencoded({ extended: true }));


var db = "mongodb://127.0.0.1:27017/HYDRA";

mongoose.connect(db, function(err, response){
	if(err){
		console.log('Failed to connected to ' + db);
	}
	else {
		console.log('Connected to ' + db);
	}
});


var router = express.Router();


// GET

router.get('/api/stations', function(request, response){

	Model.find({}, function(err, stations){
		if(err){
			response.status(404).send(err);
		}
		else {
			response.status(200).send(stations)
		}
	})

});

// DELETE

router.delete('/api/stations/:id', function(request, response){
	var id = request.params.id;
	Model.remove({_id: id}, function(err, res){
		if(err){
			response.status(500).send(err);
		}
		else {
			response.status(200).send({message: 'success on deleting station'});
		}
	})
})

// PUT

router.put('/api/stations', function(request, response){

	Model.findById(request.body._id, function(err, station){
		if(err){
			response.status(404).send(err);
		}
		else {
			station.update(request.body, function(err, success){
				if(err){
					response.send(err)
				}
				else {
					response.status(200).send({message: 'success'})
				}
			});
		}
	})

});



// POST

router.post('/api/stations', function(request, response){
	console.log(request.body);
	var model = new Model();
	model.Station_No = request.body.Station_No;
	model.Place = request.body.Place;
	model.Longitude = request.body.Longitude;
	model.Latitude = request.body.Latitude;
	model.Catchment_Area = request.body.Catchment_Area;
	model.Data_Available = request.body.Data_Available;
	model.save(function(err, station){
		if(err){
			response.status(500).send(err)
		}
		else {
			response.status(201).send(station)
		}
	});
});


app.use('/', router);
//#################################################################################

var docx = "C1H001";
//import express package
//var express = require("express");

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


function getRawData(responseObj, docx){
  //use the find() API and pass an empty query object to retrieve all records
  dbObject.collection(docx.toString()).find({}).limit(100).toArray(function(err, docs){
    if ( err ) throw err;
    //responseObj.json(response);
    responseObj.json(docs);
  });
}

app.get("/api/graph/peakFlows/:db_doc", function(req, res){
	docx = req.params.db_doc;
  getRawData(res,docx);
});

// app.get("/chart/main.html/:db_doc", function(req, res){
// 	docx = req.params.db_doc;
//   //res.redirect(__dirname + '/public/chart/main.html');
// });

//#################################################################################

// function getData(responseObj, docx){
//   //use the find() API and pass an empty query object to retrieve all records
//   dbObject.collection(docx.toString()).find({}).limit(100).toArray(function(err, docs){
//     if ( err ) throw err;
//     var dateArray = [];
//     var pkfArray = [];
//     var pklArray = [];

//     for ( index in docs){
//       var doc = docs[index];
//       //category array
//       var Peak_Date = doc['Peak_Date'];
//       //series 1 values array
//       var Peak_Flow = doc['Peak_Flow'];
//       //series 2 values array
//       var Peak_Level = doc['Peak_Level'];
//       dateArray.push({"label": Peak_Date});
//       //pkfArray.push({"values" : Peak_Flow});
//       pkfArray.push(Peak_Flow);
//       pklArray.push({"values" : Peak_Level});
//     }

//     var data = 
//       {
//       	"type" : 'bar',
//         "series" : [{"values":pkfArray}]
//       };
//     var data2 = 
//       {
//       	"type" : 'bar',
//         "series" : [{"values":[10,23,39, ,43,70]}]
//       };

//     var response = {
//       id : 'Chart_999',
//       "data" : data
//     };
//     //responseObj.json(response);
//     responseObj.json(docs);
//   });
//}





//#################################################################################

// function getDate(inpDate){
// var input = inpDate.toString();

// var year = input.slice(0,4);
// var month = input.slice(4,6);
// var day = input.slice(6,8);

// //var date = new Date(year, month - 1, day);
// var date = year+'-'+ month+'-'+ day;
// return date.toString();
// //return "999";
// };
// function getDataMaps(responseObj, docx){
//   //use the find() API and pass an empty query object to retrieve all records
//   dbObject.collection(docx.toString()).find({}).limit(100).toArray(function(err, docs){
//     if ( err ) throw err;
//     var dateArray = [];
//     var pkfArray = [];
//     var pklArray = [];

//     for ( index in docs){
//       var doc = docs[index];
//       //category array
//       var Peak_Date = doc['Peak_Date'];
//       //series 1 values array
//       var Peak_Flow = doc['Peak_Flow'];
//       //series 2 values array
//       var Peak_Level = doc['Peak_Level'];
//       dateArray.push(Peak_Date);
//       var dateFine = getDate(Peak_Date);
//       //pkfArray.push({"values" : Peak_Flow});
//       pkfArray.push([dateFine,Peak_Flow,"qwerty"]);
//       pklArray.push({"values" : Peak_Level});
//     }

//     var data = pkfArray;
//     var data2 = 
//         [[ new Date(2012, 3, 13), 37032 ],[ new Date(2012, 3, 14), 38024 ],[ new Date(2012, 3, 15), 38024 ],[ new Date(2012, 3, 16), 38108 ],[ new Date(2012, 3, 17), 38229 ],[ new Date(2013, 9, 30), 38447 ]];

//     var response = data;
//     responseObj.json(response);
//     //responseObj.json(docs);
//   });
// }



// app.get("/api/graph/peakMaps/", function(req, res){
// 	var docx = "C1H001";
//   getDataMaps(res,docx);
// });


//#################################################################################

app.use(morgan('dev'));

app.use(express.static(__dirname + '/public'));

var port = process.env.PORT || 3000

app.listen(port , function(){
	console.log('Listening on port ' + port);
})


