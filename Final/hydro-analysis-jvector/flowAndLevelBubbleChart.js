google.charts.load("current", {packages:["corechart"]});

function drawBubbleChart() {        

  var data = new google.visualization.DataTable();
  data.addColumn({type:'string', id:'Day'});
  data.addColumn({type:'number', id:'Month'});
  data.addColumn({type:'number', id:'Level'});
  data.addColumn({type:'string', id:'Month'});
  data.addColumn({type:'number', id:'Flow'});

  var dateString;  
      
  for(i = 0 ; i < myData.length; i++){

    dateString = myData[i].Peak_Date +"";
    numToDate(dateString);
    if(year.valueOf() == plotYear.valueOf()){
      data.addRows([[day+'',month-0,myData[i].Peak_Level,month+'',  myData[i].Peak_Flow]]); 
    }
  }   

  var chart = new google.visualization.BubbleChart(document.getElementById('bubbleChartContainer'));    

  var options = {
    title: 'Yearly Peak Flow and Peak Level',
    hAxis: {title: 'Month'},
    vAxis: {title: 'Level'},
    bubble: {textStyle: {fontSize: 10}}
  };      
  chart.draw(data, options);
}

google.charts.setOnLoadCallback(drawBubbleChart);