package sorting;

import chart.LineChart;
import org.apache.commons.math3.distribution.EnumeratedIntegerDistribution;
import org.jfree.ui.RefineryUtilities;
import org.supercsv.cellprocessor.*;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;
import sorting.types.*;

import java.io.FileReader;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * This class simulates all the sorting algorithms by running all the sorting techniques on different datasets
 * for multiple iterations, for every combination of parameters, recording the run time, memory usage for each iteration
 * and taking the average runtime or memory usage, pass the results to the graph library to finally generate the graphs.
 */
public class Evaluation {

    /**
     * The main method where the program starts executing. This method calls all the
     * simulation methods for every dataset.
     *
     * @param args stores all the command line arguments.
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void main(String[] args) throws Exception {

        Evaluation.generateGraphDataset1DataSizeVsRunTime();
        Evaluation.generateGraphDataset2DataSizeVsRunTime();
        Evaluation.generateGraphDataset3DataSizeVsRunTime();
        Evaluation.generateGraphDataset4DataSizeVsRunTime();

        Evaluation.generateGraphDataSet1DataSizeVsMemoryUsage();
        Evaluation.generateGraphDataSet2DataSizeVsMemoryUsage();
        Evaluation.generateGraphDataSet3DataSizeVsMemoryUsage();
        Evaluation.generateGraphDataSet4DataSizeVsMemoryUsage();

        Evaluation.generateGraphDataSet1DegreeOfSortednessVsRunTime();
        Evaluation.generateGraphDataSet2DegreeOfSortednessVsRunTime();
        Evaluation.generateGraphDataSet3DegreeOfSortednessVsRunTime();
        Evaluation.generateGraphDataSet4DegreeOfSortednessVsRunTime();


        Evaluation.generateGraphDataSet1DegreeOfSortednessVsMemoryUsage();
        Evaluation.generateGraphDataSet2DataSortednessVsMemoryUsage();
        Evaluation.generateGraphDataSet3DegreeOfSortednessednessVsMemoryUsage();
        Evaluation.generateGraphDataSet4DataSortednessVsMemoryUsage();

    }

    /**
     * This method is responsible for running simulation of all sorting techniques based on data size
     * and run time parametrs on the dataset 1.
     */
    public static void generateGraphDataset1DataSizeVsRunTime() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getUniformDistribution(sizeOfInput);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Uniform Distribution)");
        lineChart.createChart("Data Size Vs Run Time DataSet 1", xAxisList, map, "Data Size", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and run time parameters on the dataset 2.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataset2DataSizeVsRunTime() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> dataFromFile = Evaluation.getDataFromCreditCardData();
        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Real-time Credit Card Data)");
        lineChart.createChart("Data Size Vs Run Time - Dataset 2", xAxisList, map, "Data Size", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and run time parameters on the dataset 3.
     */
    public static void generateGraphDataset3DataSizeVsRunTime() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDiscreteDistribution(sizeOfInput);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Discrete Probability Distribution)");
        lineChart.createChart("Data Size Vs Run Time DataSet 3", xAxisList, map, "Data Size", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and run time parameters on the dataset 4.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataset4DataSizeVsRunTime() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> dataFromFile = Evaluation.getDataFromSalesRecordsData();
        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Real-time Data Sorting");
        lineChart.createChart("Data Size Vs Run Time - Dataset 4", xAxisList, map, "Data Size", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and memory usage parameters on the dataset 1.
     */
    public static void generateGraphDataSet1DataSizeVsMemoryUsage(){
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
//        Collections.addAll(xAxisList, 10, 50, 100, 500, 1000, 2000, 3000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getUniformDistribution(sizeOfInput);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }

        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Uniform Distribution)");
        lineChart.createChart("Memory Usage vs Data Size DataSet 1", xAxisList, map, "Data Size", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and memory usage parameters on the dataset 3.
     */
    public static void generateGraphDataSet3DataSizeVsMemoryUsage(){
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDiscreteDistribution(sizeOfInput);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }

        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Discrete Probability Distribution)");
        lineChart.createChart("Memory Usage vs Data Size DataSet 3", xAxisList, map, "Data Size", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and memory usage parameters on the dataset 2.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet2DataSizeVsMemoryUsage() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> dataFromFile = Evaluation.getDataFromCreditCardData();
        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Real-time Credit Card Data)");
        lineChart.createChart("Memory Usage vs Data Size - Dataset 2", xAxisList, map, "Data Size", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on data size and memory usage parameters on the dataset 4.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet4DataSizeVsMemoryUsage() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();
        Collections.addAll(xAxisList, 100, 1000, 5000, 10000);
        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> dataFromFile = Evaluation.getDataFromSalesRecordsData();
        for (int sizeOfInput: xAxisList) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Real-time Data Sorting");
        lineChart.createChart("Memory Usage vs Data Size - Dataset 4", xAxisList, map, "Data Size", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and run time parameters on the dataset 1.
     */
    public static void generateGraphDataSet1DegreeOfSortednessVsRunTime() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();


        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getUniformDistribution(sizeOfInput);

            //Measuring degree of sortedness of the given input size and the random numbers generated
            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Uniform Distribution)");
        lineChart.createChart("Degree Of Sortedness vs Run Time DataSet 1", xAxisList, map, "Degree Of Sortedness", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and run time parameters on the dataset 3.
     */
    public static void generateGraphDataSet3DegreeOfSortednessVsRunTime() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();


        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDiscreteDistribution(sizeOfInput);

            //Measuring degree of sortedness of the given input size and the random numbers generated
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Discrete Probability Distribution)");
        lineChart.createChart("Degree Of Sortedness vs Run Time DataSet 3", xAxisList, map, "Degree Of Sortedness", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and run time parameters on the dataset 2.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet2DegreeOfSortednessVsRunTime() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        List<Integer> dataFromFile = Evaluation.getDataFromCreditCardData();
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);

            //Measuring degree of sortedness of the given input size and the random numbers generated
            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Real-time Credit Card Data)");
        lineChart.createChart("Degree Of Sortedness Vs Run Time - Dataset 2", xAxisList, map, "Degree Of Sortedness", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and run time parameters on the dataset 4.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet4DegreeOfSortednessVsRunTime() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        List<Integer> dataFromFile = Evaluation.getDataFromSalesRecordsData();
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);

            //Measuring degree of sortedness of the given input size and the random numbers generated
            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForRunTime(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Real-time Data Sorting");
        lineChart.createChart("Degree Of Sortedness Vs Run Time - Dataset 4", xAxisList, map, "Degree Of Sortedness", "Run Time(in ms)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and memory usage parameters on the dataset 1.
     */
    public static void generateGraphDataSet1DegreeOfSortednessVsMemoryUsage() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();


        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getUniformDistribution(sizeOfInput);

            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Uniform Distribution)");
        lineChart.createChart("Degree Of Sortedness vs Memory Usage DataSet 1", xAxisList, map, "Degree Of Sortedness", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and memory usage parameters on the dataset 3.
     */
    public static void generateGraphDataSet3DegreeOfSortednessednessVsMemoryUsage() {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();


        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDiscreteDistribution(sizeOfInput);

            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Discrete Probability Distribution)");
        lineChart.createChart("Degree Of Sortedness vs Memory Usage DataSet 3", xAxisList, map, "Degree Of Sortedness", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and memory usage parameters on the dataset 4.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet4DataSortednessVsMemoryUsage() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        List<Integer> dataFromFile = Evaluation.getDataFromSalesRecordsData();
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);

            Sort sort = new InsertionSort();
            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Real-time Data Sorting");
        lineChart.createChart("Degree Of Sortedness Vs Memory Usage - Dataset 4", xAxisList, map, "Degree Of Sortedness", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for running simulation of all sorting techniques based
     * on degree of sortedness and memory usage parameters on the dataset 4.
     *
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static void generateGraphDataSet2DataSortednessVsMemoryUsage() throws Exception {

        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> xAxisList = new ArrayList<>();

        List<Integer> datapointsInsertionSort = new ArrayList<>();
        List<Integer> datapointsSelectionSort = new ArrayList<>();
        List<Integer> datapointsBubbleSort = new ArrayList<>();
        List<Integer> datapointsMergeSort = new ArrayList<>();
        List<Integer> datapointsQuickSort = new ArrayList<>();

        List<Integer> size = new ArrayList<Integer>();
        Collections.addAll(size, 100, 1000, 5000, 10000);

        List<Integer> dataFromFile = Evaluation.getDataFromCreditCardData();
        for (int sizeOfInput: size) {
            int[] randomNumbers = Evaluation.getDataFromList(dataFromFile, sizeOfInput);

            int totalDegreeOfSortedness = 0;
            totalDegreeOfSortedness = Evaluation.sortedMeasure(randomNumbers);
            xAxisList.add(totalDegreeOfSortedness);
            runSimulationForMemoryUsage(randomNumbers, datapointsBubbleSort, datapointsInsertionSort, datapointsMergeSort, datapointsQuickSort, datapointsSelectionSort);
        }
        map.put("InsertionSort", datapointsInsertionSort);
        map.put("SelectionSort", datapointsSelectionSort);
        map.put("BubbleSort", datapointsBubbleSort);
        map.put("MergeSort", datapointsMergeSort);
        map.put("QuickSort", datapointsQuickSort);
        LineChart<Integer> lineChart = new LineChart<>("Sorting Evaluation (Real-time Credit Card Data)");
        lineChart.createChart("Degree Of Sortedness Vs Memory Usage - Dataset 2", xAxisList, map, "Degree Of Sortedness", "Memory Usage(in KiloBytes)");
        lineChart.pack();
        RefineryUtilities.centerFrameOnScreen(lineChart);
        lineChart.setVisible(true);
    }

    /**
     * This method is responsible for reading the credit card real time data from the file using SuperCsv Library.
     *
     * @return {@link List} of {@link Integer} containing the credit limit data from the file.
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static List<Integer> getDataFromCreditCardData() throws Exception {
        final CellProcessor[] cellProcessors = new CellProcessor[] {
                new NotNull(),
                // Card Type Full Name
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new ParseInt()
        };

        ICsvListReader listReader = null;
        try {
            listReader = new CsvListReader(new FileReader("creditCard/CreditCardData.csv"), CsvPreference.STANDARD_PREFERENCE);

            listReader.getHeader(true); // skip the header (can't be used with CsvListReader)

            List<Object> creditCardList;
            List<Integer> creditCardLimits = new ArrayList<>();
            while ((creditCardList = listReader.read(cellProcessors)) != null) {
                creditCardLimits.add(Integer.parseInt((String) creditCardList.get(9)));
            }

            return creditCardLimits;

        } finally {
            if( listReader != null ) {
                listReader.close();
            }
        }
    }

    /**
     * This method is responsible for reading the credit card real time data from the file using SuperCsv Library.
     *
     * @return {@link List} of {@link Integer} containing the credit limit data from the file.
     * @throws Exception An exception is thrown where is there is a problem with reading of files.
     */
    public static List<Integer> getDataFromSalesRecordsData() throws Exception {
        final CellProcessor[] cellProcessors = new CellProcessor[] {
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new ParseInt(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull(),
                new NotNull()
        };

        ICsvListReader listReader = null;
        try {
            listReader = new CsvListReader(new FileReader("creditCard/SalesRecordsData.csv"), CsvPreference.STANDARD_PREFERENCE);

            listReader.getHeader(true); // skip the header (can't be used with CsvListReader)

            List<Object> salesRecordsList;
            List<Integer> unitsSoldList = new ArrayList<>();
            while ((salesRecordsList = listReader.read(cellProcessors)) != null) {
                unitsSoldList.add((Integer) salesRecordsList.get(8));
            }

            return unitsSoldList;

        } finally {
            if( listReader != null ) {
                listReader.close();
            }
        }
    }

    /**
     * Gets an integer array from the {@link List} of {@link Integer} based on {@code numberOfInputs}.
     *
     * @param data the {@link List} of {@link Integer} containing all the data.
     * @param numberOfInputs the input size requied.
     *
     * @return the integer array.
     */
    public static int[] getDataFromList(List<Integer> data, int numberOfInputs) {
        int[] creditCardArray = new int[numberOfInputs];
        Integer[] temp = data.toArray(new Integer[numberOfInputs]);
        for (int n = 0; n < numberOfInputs; ++n) {
            creditCardArray[n] = temp[n];
        }

        return creditCardArray;
    }

    /**
     * Gets the uniformly distributed data
     * @param numberOfInputs the input size required.
     *
     * @return the uniformly distributed integer array.
     */
    public static int[] getUniformDistribution(int numberOfInputs) {
        int[] randomNumberList = new int[numberOfInputs];
        Random random = new Random();
        for (int i = 0; i < numberOfInputs; i++) {
            int data =  random.nextInt();
            randomNumberList[i] = data;
        }

        return randomNumberList;
    }

    /**
     * Gets the discrete probability distributed data.
     *
     * @param sizeOfInput the input size required.
     *
     * @return the discrete probability distributed integer array.
     */
    public static int[] getDiscreteDistribution(int sizeOfInput) {
        int[] numbersForGeneration = new int[] {1, 10, 100, 1000};
        double[] probabilities = new double[] {0.3, 0.2, 0.2, 0.3};
        EnumeratedIntegerDistribution distribution = new EnumeratedIntegerDistribution(numbersForGeneration, probabilities);
        int[] samples = distribution.sample(sizeOfInput);
        return samples;
    }

    /**
     * Records and returns the run time of a sorting technique given an input data and the sorting type.
     *
     * @param inputArray the input array.
     * @param currentSortingType the {@link Sort} type.
     *
     * @return the run time for running the sorting techniqe on the given input data.
     */
    public static int getDuration(int[] inputArray, Sort currentSortingType) {
        Instant startTime = Instant.now();
        currentSortingType.sort(inputArray);
        Instant endTime = Instant.now();
        int duration = Duration.between(startTime, endTime).getNano()/1000000;
        return duration;
    }

    /**
     * Gets the run time memory usage for sorting the given input array and based on the current sorting type.
     *
     * @param inputArray the input array.
     * @param currentSortingType the {@link Sort} type.
     *
     * @return the run time memory usage for sorting the given input array and based on the current sorting type.
     */
    public static long getMemoryUsage(int[] inputArray, Sort currentSortingType) {
        long beforeUsedMemory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
        currentSortingType.sort(inputArray);
        long afterUsedMemory = Runtime.getRuntime().totalMemory()- Runtime.getRuntime().freeMemory();
        long actualMemoryUsage = (afterUsedMemory - beforeUsedMemory) / 1024;
        return actualMemoryUsage;
    }

    /**
     * Responsible for measuring the Inversions of sorting which is one of the degrees of sortedness.
     *
     * @param inputArray the input array.
     *
     * @return the Inversions of sorting which is one of the degrees of sortedness.
     */
    public static int sortedMeasure(int[] inputArray) {

        int count = 0;
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] > inputArray[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Runs simulation for measuring running time for every sorting technique based on the given {@code inputArray}.
     *
     * @param inputArray the input Array.
     * @param datapointsBubbleSort  the {@link List} of {@link Integer} to store the run time data points for Bubble Sort.
     * @param datapointsInsertionSort the {@link List} of {@link Integer} to store the run time data points for Insertion Sort.
     * @param datapointsMergeSort the {@link List} of {@link Integer} to store the run time data points for Merge Sort.
     * @param datapointsQuickSort the {@link List} of {@link Integer} to store the run time data points for Quick Sort.
     * @param datapointsSelectionSort the {@link List} of {@link Integer} to store the run time data points for Selection Sort.
     */
    public static void runSimulationForRunTime(final int[] inputArray,
                                               final List<Integer> datapointsBubbleSort,
                                               final List<Integer> datapointsInsertionSort,
                                               final List<Integer> datapointsMergeSort,
                                               final List<Integer> datapointsQuickSort,
                                               final List<Integer> datapointsSelectionSort) {
        //Measuring insertion sort running time
        int duration = 0;
        Sort sort = new InsertionSort();
        duration = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            duration = duration + Evaluation.getDuration(inputArray, sort);
        }
        datapointsInsertionSort.add(duration/5);

        // Measuring selection sort running time
        sort = new SelectionSort();
        duration = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            duration = duration + Evaluation.getDuration(inputArray, sort);
        }
        datapointsSelectionSort.add(duration/5);

        // Measuring bubble sort running time
        sort = new BubbleSort();
        duration = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            duration = duration + Evaluation.getDuration(inputArray, sort);
        }
        datapointsBubbleSort.add(duration/5);

        // Measuring merge sort running time
        sort = new MergeSort();
        duration = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            duration = duration + Evaluation.getDuration(inputArray, sort);
        }
        datapointsMergeSort.add(duration/5);

        // Measuring quick sort running time
        sort = new QuickSort();
        duration = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            duration = duration + Evaluation.getDuration(inputArray, sort);
        }
        datapointsQuickSort.add(duration/5);
    }

    /**
     * Runs simulation for measuring memory usage for every sorting technique based on the given {@code inputArray}.
     *
     * @param inputArray the input Array.
     * @param datapointsBubbleSort  the {@link List} of {@link Integer} to store the run time data points for Bubble Sort.
     * @param datapointsInsertionSort the {@link List} of {@link Integer} to store the run time data points for Insertion Sort.
     * @param datapointsMergeSort the {@link List} of {@link Integer} to store the run time data points for Merge Sort.
     * @param datapointsQuickSort the {@link List} of {@link Integer} to store the run time data points for Quick Sort.
     * @param datapointsSelectionSort the {@link List} of {@link Integer} to store the run time data points for Selection Sort.
     */
    public static void runSimulationForMemoryUsage(final int[] inputArray,
                                                   final List<Integer> datapointsBubbleSort,
                                                   final List<Integer> datapointsInsertionSort,
                                                   final List<Integer> datapointsMergeSort,
                                                   final List<Integer> datapointsQuickSort,
                                                   final List<Integer> datapointsSelectionSort) {
        //Measuring insertion sort memory usage
        long totalMemoryUsage = 0;
        Sort sort = new InsertionSort();
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            totalMemoryUsage = totalMemoryUsage + Evaluation.getMemoryUsage(inputArray, sort);
        }
        datapointsInsertionSort.add((int)totalMemoryUsage/5);

        // Measuring selection sort memory usage
        sort = new SelectionSort();
        totalMemoryUsage = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            totalMemoryUsage = totalMemoryUsage + Evaluation.getMemoryUsage(inputArray, sort);
        }
        datapointsSelectionSort.add((int)(totalMemoryUsage/5));

        // Measuring bubble sort memory usage
        sort = new BubbleSort();
        totalMemoryUsage = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            totalMemoryUsage = totalMemoryUsage + Evaluation.getMemoryUsage(inputArray, sort);
        }
        datapointsBubbleSort.add((int)(totalMemoryUsage/5));

        // Measuring merge sort memory usage
        sort = new MergeSort();
        totalMemoryUsage = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            totalMemoryUsage = totalMemoryUsage + Evaluation.getMemoryUsage(inputArray, sort);
        }
        datapointsMergeSort.add((int)totalMemoryUsage/5);

        // Measuring Quick sort memory usage
        sort = new QuickSort();
        totalMemoryUsage = 0;
        for (int noOfTimes = 0; noOfTimes < 5; noOfTimes++) {
            totalMemoryUsage = totalMemoryUsage + Evaluation.getMemoryUsage(inputArray, sort);
        }
        datapointsQuickSort.add((int)(totalMemoryUsage/5));
    }
}
