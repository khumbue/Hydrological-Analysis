//Draw Calender chart against Date and Level
google.charts.load("current", {packages:["calendar"]});

function drawCalendarLevelChart() {       
            
    var dateString;
    var dataTable = new google.visualization.DataTable();
    dataTable.addColumn({ type: 'date', id: 'Date' });
    dataTable.addColumn({ type: 'number', id: 'Won/Loss' });

    for(i = 0 ; i < myData.length; i++){

        dateString = myData[i].Peak_Date +"";
        numToDate(dateString);
        if(year.valueOf() == plotYear.valueOf()){
            dataTable.addRows([[new Date(year,month-1,day),myData[i].Peak_Level]]);
        }

    }

    var chart = new google.visualization.Calendar(document.getElementById('calendarChartLevelContainer'));

    var options = {
        title: "Peak Level",
        height: 350000000,
    };

    chart.draw(dataTable, options);
}

google.charts.setOnLoadCallback(drawCalendarLevelChart);