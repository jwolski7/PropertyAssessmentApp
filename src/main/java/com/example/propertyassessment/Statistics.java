package com.example.propertyassessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statistics {

    /**Gets the max property assessment value of the csv file
     * @param list
     * @ returns the max value
     */
    public static int max(ArrayList<String[]> list) {
        int value = 0;
        int max = 0;

        for(String[] i: list){
            value = Integer.parseInt(i[8]);

            if(value > max)
                max = value;
        }

        return value;
    }

    /**Gets the min property assessment value of the csv fil
     * @param list
     * @ return the min value
     */
    public static int min(ArrayList<String[]> list) {
        int value = 0;
        int min = 0;

        for(String[] i: list){
            value = Integer.parseInt(i[8]);

            if (value < min)
                min = value;
        }

        return min;
    }

    /**Gets the range of the property assessment value of the csv file
     * @param max
     * @param min
     * @ returns the range
     */
    public static int range(int max, int min) {
        return (max - min);
    }

    /**Gets the mean of the property assessment value of the csv file
     * @param list
     * @returns the mean
     */
    public static int mean(ArrayList<String[]> list){
        int mean = 0;

        for (String[] i :list)
            mean = mean + Integer.parseInt(i[8]);

        mean = mean / list.size();

        return mean;
    }

    /**Gets the standard deviation of the property assessment value of the csv file
     * @param is the csv file as a list and the mean
     * @returns the standard deviation
     */
    public static int SD(ArrayList<String[]> list, int mean){
        int sum = 0;
        int standardDeviation = 0;
        int length = list.size();

        for(String[] i: list) {
            standardDeviation += Math.pow(Integer.parseInt(i[8]) - mean, 2);
        }
        int SD = (int) Math.sqrt(standardDeviation / length);

        return SD;
    }

    /**Gets the median of the property assessment value of the csv file
     * @param list
     *@ returns the median
     */
    public static int median(ArrayList<String[]> list){

        List<Double> lList = new ArrayList<Double>();

        for(String[] i: list)
            lList.add(Double.parseDouble(i[8]));

        Collections.sort(lList);

        double[] lost = new double[lList.size()];

        for (int i = 0; i < lost.length; i++) {
            lost[i] = lList.get(i);
        }

        int mid = lList.size();
        double m = 0;

        if (mid % 2 ==1)
            m = lost[(mid + 1) / 2 - 1];

        else
            m = (lost[mid / 2 - 1] + lost[mid / 2]) /2;

        return (int) m;
    }
}
