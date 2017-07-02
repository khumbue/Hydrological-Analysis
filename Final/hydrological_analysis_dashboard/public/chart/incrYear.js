// Increment year and plots
function incrYear(){
    plotYear = plotYear + 1;
    document.getElementById("yearText").value = plotYear;
    updateCharts();
}