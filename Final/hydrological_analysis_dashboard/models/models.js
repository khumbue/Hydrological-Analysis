var mongoose = require('mongoose');

var Schema = mongoose.Schema;

var StationsSchema = new Schema({
	Station_No: {
		type: String, 
		required: true
	},
	Longitude: {
		type: String, 
		required: false
	},
	Latitude: {
		type: String, 
		required: false
	},
	Catchment_Area: {
		type:  Number, 
		required: false 
	},
	Place: {
		type: String, 
		required: false
	},
	Data_Available: {
		type: String, 
		required: false
	}
});

var model = mongoose.model('Stations', StationsSchema);

module.exports = model;