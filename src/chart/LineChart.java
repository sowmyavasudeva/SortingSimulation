package chart;

import org.apache.commons.lang3.Validate;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import java.util.*;

/**
 * A generic class that takes any type of data to generate charts after passing the data points.
 * @param <T>
 */
public class LineChart<T> extends ApplicationFrame {

    /**
     * Constructs a new application frame.
     *
     * @param title the frame title.
     */
    public LineChart(final String title) {
        super(title);
    }

    /**
     * Creates a chart using JFreeChart Library.
     * @param chartTitle the title of the chart.
     * @param xAxisList the {@link List} of {@link T} data points for the X axis.
     * @param data the {@link Map} of sorting type to the corresponding data points to plot in the graph.
     * @param xAxisLabel the label for the X Axis.
     * @param yAxisLabel the label for the Y Axis.
     */
    public void createChart(final String chartTitle,
                            final List<T> xAxisList,
                            final Map<String, List<T>> data,
                            final String xAxisLabel,
                            final String yAxisLabel) {
        JFreeChart lineChart
                = ChartFactory.createXYLineChart(chartTitle,
                                               xAxisLabel,
                                               yAxisLabel,
                                               createDataset(xAxisList, data),
                                               PlotOrientation.VERTICAL,
                                       true,
                                      true,
                                         false);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane(chartPanel);
    }

    /**
     * Creates a {@link XYDataset} required to generate the XY chart.
     * @param xAxisList the list of data point for x axis.
     * @param dataList the actual data points to plot in the graph.
     *
     * @return the {@link XYDataset} required to generate the XY chart.
     */
    private XYDataset createDataset(final List<T> xAxisList,
                                    final Map<String, List<T>> dataList) {
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataList.forEach((sortingTechnique, data) -> {
            XYSeries xySeries = new XYSeries(sortingTechnique);
            Validate.isTrue(xAxisList.size() == data.size());
            for (int i = 0; i < data.size(); i++) {
                T currentData = data.get(i);
                if (currentData instanceof Integer) {
                    Integer currentInteger = (Integer) data.get(i);
                    Integer xAxisData = (Integer) xAxisList.get(i);
                    xySeries.add(xAxisData, currentInteger);
                } else if (currentData instanceof Double) {
                    Double currentDouble = (Double) data.get(i);
                    Double xAxisData = (Double) xAxisList.get(i);
                    xySeries.add(currentDouble, xAxisData);
                } else if (currentData instanceof Long) {
                    Long currentDouble = (Long) data.get(i);
                    Long xAxisData = (Long) xAxisList.get(i);
                    xySeries.add(currentDouble, xAxisData);
                } else if (currentData instanceof Float) {
                    Float currentDouble = (Float) data.get(i);
                    Float xAxisData = (Float) xAxisList.get(i);
                    xySeries.add(currentDouble, xAxisData);
                }
            }
            dataset.addSeries(xySeries);
        });
        return dataset;
    }
}
