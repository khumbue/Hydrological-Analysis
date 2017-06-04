 // Imports all the modules needed
var express = require('express');
var bodyParser = require('body-parser');
var mongodb = require('mongodb');

// Used to connect to the MongoDB database

var router = express.Router();


//Stations API
//router.delete('/:col&:doc', function(req, res){
  //tobefixed Delete function not detected//
router.get('/:col&:doc', function(req, res){
//initialise col with request parm
  var col = req.params.col;
  var doc = req.params.doc;

  // Get a Mongo client to work with the Mongo server
  var MongoClient = mongodb.MongoClient;

  // Define where the MongoDB server is
  var url = 'mongodb://127.0.1.1:27017/HYDRA';

  // Connect to the server
  MongoClient.connect(url, function (err, db) {
  if (err) {
    console.log('Unable to connect to the Server', err);
  } else {
    // We are connected
    console.log('Connection established to', url);

    // Get the documents collection
    var collection = db.collection(col);

    // Find all students
    collection.deleteOne({$or:[{"Station_No":doc}, {"Peak_Date":parseInt(doc)}]}).then(function (err, result) {
      if (err) {
        res.send(err);
      } else if (result.length) {
        res.json(result);
      } else {
        res.send('No documents found');
      }
      //Close connection
      db.close();
    });
  }
  });
});


module.exports = router;