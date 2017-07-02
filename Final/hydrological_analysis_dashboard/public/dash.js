    var grTag = [];
    var app = angular.module('myApp', []);
      app.controller('myCtrl', function($scope, $http) {
        var url = "http://127.0.0.1:3000/api/graph/peakFlowsDates";
        //var url = "data.txt";
        $http.get(url)
        .then(function(response) {
            $scope.students = response.data;
            grTag = response.data;
            //zingchart.render(response.data);
            //zingchart.render($scope.students);

            for ( index in grTag){
              var yearVal = grTag[index].toString().slice(0,4);
              plotYear = parseInt(yearVal);
        }

    zingchart.THEME = "classic";
    var myConfig = {
      "background-color": "#3F5666",
      "globals": {
        "font-family": "Arial",
        "font-weight": "normal"
      },
      "graphset": [{
        "type": "null",
        "x": "2.25%",
        "y": "1%",
        "background-color": "none",
        "title": {
          "text": "This year's Peak Flows",
          "text-align": "left",
          "font-size": "14px",
          "font-color": "#ffffff",
          "background-color": "none"
        }
      }, {
        "type": "null",
        "x": "73.75%",
        "y": "1%",
        "background-color": "none",
        "title": {
          "text": "Last Sync: Yesterday",
          "text-align": "right",
          "font-size": "11px",
          "font-color": "#f4f4f4",
          "background-color": "none"
        }
      }, {
        "type": "pie",
        "height": "40%",
        "width": "30%",
        "x": "3%",
        "y": "10%",
        "background-color": "#ffffff",
        "border-radius": 4,
        "title": {
          "text": "Rain Fall estimates",
          "text-align": "left",
          "background-color": "none",
          "font-color": "#000000",
          "font-size": "13px",
          "offset-y": "10%",
          "offset-x": "10%"
        },
        "value-box": {
          "visible": true
        },
        "plotarea": {
          "margin": "20% 0% 0% 0%"
        },
        "plot": {
          "slice": 50,
          "ref-angle": 270,
          "detach": false,
          "hover-state": {
            "visible": false
          },
          "value-box": {
            "visible": true,
            "type": "first",
            "connected": false,
            "placement": "center",
            "text": "%v",
            "rules": [{
              "rule": "%v < 3850",
              "visible": false
            }],
            "font-color": "#000000",
            "font-size": "20px"
          },
          "tooltip": {
            "rules": [{
              "rule": "%i == 0",
              "text": "%v %t Completed",
              "shadow": false,
              "border-radius": 4
            }, {
              "rule": "%i == 1",
              "text": "%v Remaining",
              "shadow": false,
              "border-radius": 4
            }]
          },
          "animation": {
            "delay": 0,
            "effect": 2,
            "speed": "600",
            "method": "0",
            "sequence": "1"
          }
        },
        "series": [{
          "values": [3852],
          "text": "Steps",
          "background-color": "#00baf0",
          "border-width": "0px",
          "shadow": 0
        }, {
          "values": [1148],
          "background-color": "#dadada",
          "alpha": "0.5",
          "border-color": "#dadada",
          "border-width": "1px",
          "shadow": 0
        }]
      }, {
        "type": "pie",
        "height": "40%",
        "width": "30%",
        "x": "35%",
        "y": "10%",
        "background-color": "#ffffff",
        "border-radius": 4,
        "title": {
          "text": "<strong>Peak Levels</strong>",
          "text-align": "left",
          "background-color": "none",
          "font-color": "#000000",
          "font-size": "13px",
          "offset-y": "10%",
          "offset-x": "10%"
        },
        "value-box": {
          "visible": true
        },
        "plotarea": {
          "margin": "20% 0% 0% 0%"
        },
        "plot": {
          "slice": 50,
          "ref-angle": 270,
          "detach": false,
          "hover-state": {
            "visible": false
          },
          "value-box": {
            "visible": true,
            "type": "first",
            "connected": false,
            "placement": "center",
            "text": "%v",
            "rules": [{
              "rule": "%v < 5.6",
              "visible": false
            }],
            "font-color": "#000000",
            "font-size": "20px"
          },
          "tooltip": {
            "rules": [{
              "rule": "%v == 5.6",
              "text": "%v %t Completed",
              "shadow": false,
              "border-radius": 4
            }, {
              "rule": "%v == 4.4",
              "text": "%v Remaining",
              "shadow": false,
              "border-radius": 4
            }]
          },
          "animation": {
            "delay": 0,
            "effect": 2,
            "speed": "600",
            "method": "0",
            "sequence": "1"
          }
        },
        "series": [{
          "values": [5.6],
          "text": "Miles",
          "background-color": "#8AB839",
          "border-width": "0px",
          "shadow": 0
        }, {
          "values": [4.4],
          "background-color": "#dadada",
          "alpha": "0.5",
          "border-color": "#dadada",
          "border-width": "1px",
          "shadow": 0
        }]
      }, {
        "type": "pie",
        "height": "40%",
        "width": "30%",
        "x": "67%",
        "y": "10%",
        "background-color": "#ffffff",
        "border-radius": 4,
        "title": {
          "text": "Peak Flows",
          "text-align": "left",
          "background-color": "none",
          "font-color": "#000000",
          "font-size": "13px",
          "offset-y": "10%",
          "offset-x": "10%"
        },
        "value-box": {
          "visible": true
        },
        "plotarea": {
          "margin": "20% 0% 0% 0%"
        },
        "plot": {
          "slice": 50,
          "ref-angle": 270,
          "detach": false,
          "hover-state": {
            "visible": false
          },
          "value-box": {
            "visible": true,
            "type": "first",
            "connected": false,
            "placement": "center",
            "text": "%v",
            "rules": [{
              "rule": "%v < 2078",
              "visible": false
            }],
            "font-color": "#000000",
            "font-size": "20px"
          },
          "tooltip": {
            "rules": [{
              "rule": "%v == 2078",
              "text": "%v %t Burned",
              "shadow": false,
              "border-radius": 4
            }, {
              "rule": "%v == 422",
              "text": "%v Remaining",
              "shadow": false,
              "border-radius": 4
            }]
          },
          "animation": {
            "delay": 0,
            "effect": 2,
            "speed": "600",
            "method": "0",
            "sequence": "1"
          }
        },
        "series": [{
          "values": [2078],
          "text": "Peak Flows",
          "background-color": "#FABE28",
          "border-width": "0px",
          "shadow": 0
        }, {
          "values": [422],
          "background-color": "#dadada",
          "alpha": "0.5",
          "border-color": "#dadada",
          "border-width": "1px",
          "shadow": 0
        }]
      }, {
        "type": "bar",
        "height": "42%",
        "width": "94%",
        "x": "3%",
        "y": "53%",
        "background-color": "#ffffff",
        "border-radius": 4,
        "title": {
          "text": "Step Tracker",
          "text-align": "left",
          "font-size": "13px",
          "font-color": "#000000",
          "background-color": "none",
          "offset-x": "10%",
          "offset-y": "10%"
        },
        "legend": {
          "toggle-action": "remove",
          "layout": "x3",
          "x": "52.5%",
          "shadow": false,
          "border-color": "none",
          "background-color": "none",
          "item": {
            "font-color": "#000000"
          },
          "marker": {
            "type": "circle",
            "border-width": 0
          },
          "tooltip": {
            "text": "%plot-description"
          }
        },
        "tooltip": {
          "text": "%t<br><strong>%v</strong>",
          "font-size": "12px",
          "border-radius": 4,
          "shadow": false,
          "callout": true,
          "padding": "5 10"
        },
        "plot": {
          "background-color": "#000000",
          "animation": {
            "effect": "4"
          }
        },
        "plotarea": {
          "margin": "35% 3.5% 20% 7.5%"
        },
        "scale-x": {
          "values": ["12AM", "2AM", "4AM", "6AM", "8AM", "10AM", "<strong>NOON</strong>", "2PM", "4PM", "6PM", "8PM", "10PM", "12AM"],
          "line-color": "#adadad",
          "line-width": "1px",
          "item": {
            "font-size": "10px",
            "offset-y": "-2%"
          },
          "guide": {
            "visible": false
          },
          "tick": {
            "visible": false
          }
        },
        "scale-y": {
          "values": "0:300:100",
          "line-color": "none",
          "item": {
            "font-size": "10px",
            "offset-x": "2%"
          },
          "guide": {
            "line-style": "solid",
            "line-color": "#adadad"
          },
          "tick": {
            "visible": false
          }
        },
        "series": [{
          "text": "Light",
          "background-color": "#FABE28",
          "description": "< 3 Miles / Hour",
          "hover-state": {
            "background-color": "#FFC942"
          },
          "values": [null, null, null, 170, 220, 240, 260, 250, 20, 10, 5]
        }, {
          "text": "Moderate",
          "values": [null, null, null, 30, 50, 40, 104, 34, 8, 15, 5, 0],
          "background-color": "#FF8A00",
          "description": "> 3 Miles / Hour < 5 Miles / Hour",
          "hover-state": {
            "background-color": "#FF9619"
          }
        }, {
          "text": "Intense",
          "values": [null, null, null, 33, 22, 17, 11, 8, 200, 100, 50],
          "background-color": "#88C100",
          "description": "> 5 Miles / Hour",
          "hover-state": {
            "background-color": "#91CE00"
          }
        }]
      }]
    };

    zingchart.render({
      id: 'myChart',
      data: myConfig,
      height: 500,
      width: 725
    });

  });
});