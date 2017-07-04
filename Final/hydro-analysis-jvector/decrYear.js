function decrYear(){
    plotYear = plotYear - 1; 
    document.getElementById("yearText").value = plotYear;
    updateCharts();
}