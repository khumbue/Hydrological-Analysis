//Draw Calender chart against Date and Flow
google.charts.load("current", {packages:["calendar"]});

function drawCalendarFlowChart() {       
            
    var dateString;
    var dataTable = new google.visualization.DataTable();
    dataTable.addColumn({ type: 'date', id: 'Date' });
    dataTable.addColumn({ type: 'number', id: 'Won/Loss' });

    for(i = 0 ; i < myData.length; i++){

        dateString = myData[i].Peak_Date +"";
        numToDate(dateString);
        if(year.valueOf() == plotYear.valueOf()){
            dataTable.addRows([[new Date(year,month-1,day),myData[i].Peak_Flow]]);
        }

    }

    var chart = new google.visualization.Calendar(document.getElementById('calendarChartFlowContainer'));

    var options = {
        title: "Peak Flow",
        height: 350000000,
    };

    chart.draw(dataTable, options);
}

google.charts.setOnLoadCallback(drawCalendarFlowChart);
        