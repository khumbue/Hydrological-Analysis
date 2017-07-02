//var chartData;

$(function(){
  $.ajax({
    url: 'http://127.0.0.1:3300/peakFlows',
    type: 'GET',
    success : function(data) {
      //chartData = data;
      var template = Handlebars.compile($("#tabular-template").html());
      $("#table-location").html(template(data));

      var flowProperties = {
        "caption": "Variation of Peak Flows per Station",
        "numberprefix": "",
        "xAxisName": "Date",
        "yAxisName": "Flow"
      };
      var levelProperties = {
        "caption": "Variation of Peak Levels per Station",
        "numberprefix": "",
        "xAxisName": "Date",
        "yAxisName": "Level",
      };

      var categoriesArray = [{
          "category" : data["categories"]
      }];

      var lineChart = new FusionCharts({
        type: 'msline',
        renderAt: 'chart-location',
        width: '1000',
        height: '300',
        dataFormat: 'json',
        dataSource: {
          chart: flowProperties,
          categories : categoriesArray,
          dataset : data["dataset"]
        }
      });
        var lineChart2 = new FusionCharts({
        type: 'msline',
        renderAt: 'chart-location2',
        width: '1000',
        height: '300',
        dataFormat: 'json',
        dataSource: {
          chart: levelProperties,
          categories : categoriesArray,
          dataset : data["dataset2"]
        }
      });
      lineChart.render();
      lineChart2.render();
    }
  });
});
