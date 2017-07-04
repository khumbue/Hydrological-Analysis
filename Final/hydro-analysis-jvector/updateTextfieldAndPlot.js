function updateTextfield(yearVar){
    dateString = myData[0].Peak_Date + "";
    numToDate(dateString);
    plotYear = parseInt(yearVar) + parseInt(year)
    document.getElementById("yearText").value = plotYear;
    updateCharts();
}
