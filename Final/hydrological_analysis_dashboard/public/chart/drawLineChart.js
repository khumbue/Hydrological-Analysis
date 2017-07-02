  

        function drawLineChart() {
            // Define the chart to be drawn.
            var data = new google.visualization.DataTable();
            data.addColumn('number', 'Date');
            data.addColumn('number', 'Level');  

            for(i = 0 ; i < myData.length; i++){

                dateString = myData[i].Peak_Date +"";
                numToDate(dateString);
                if(year.valueOf() == plotYear.valueOf()){
                    dataTable.addRows([
                        [myData[i].Peak_Date,  myData[i].Peak_Level]
                    ]);
                }

            }

            // Set chart options
            var options = {'title' : 'Average Temperatures of Cities',
                hAxis: {
                title: 'Date'
                },
                vAxis: {
                title: 'Level'
                },
                'width':350,
                'height':200
            };

            // Instantiate and draw the chart.
            var chart = new google.visualization.LineChart(document.getElementById('lineChartContainer'));
            chart.draw(data, options);
        }
        google.charts.setOnLoadCallback(drawLineChart);
