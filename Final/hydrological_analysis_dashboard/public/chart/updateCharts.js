//Update charts
function updateCharts(){
    google.charts.setOnLoadCallback(drawCalendarLevelChart);   
    google.charts.setOnLoadCallback(drawCalendarFlowChart);  
    google.charts.setOnLoadCallback(drawBubbleChart);  
}