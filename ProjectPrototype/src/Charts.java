import javafx.embed.swing.SwingNode;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

/**
 * Created by tefo-matshediso-tlotla on 2017/06/09.
 */
public class Charts {

    public SwingNode creatLineChart(String chartTitle, String xAxisLabel, String yAxisLabel, String key, List<Integer> xData, List<Double> yData){

        XYSeries series = new XYSeries(key);

        for(int i=0; i<xData.size(); i++){
            series.add(xData.get(i), yData.get(i));
        }

        for(int i=0; i<xData.size(); i++){
            series.add(xData.get(i), yData.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart(chartTitle,xAxisLabel,yAxisLabel,dataset, PlotOrientation.VERTICAL,true,true,false);
        ChartPanel chartPanel = new ChartPanel(chart);
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(chartPanel);
        return swingNode;

    }

}
