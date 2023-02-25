package com.example.propertyassessment;

import java.awt.*;

public class Data {
    String accountNum;
    String suite, houseNum, streetName, garage, neighbourhoodID;
    String neighbourhood, ward;
    int assessedValue;
    double longitude, latitude;
    Point location;
    double[] assessmentPercentage;
    String assessmentClass;


    public Data(String[] csv){

        accountNum = csv[0];
        suite = csv[1];
        houseNum = csv[2];
        streetName = csv[3];
        garage = csv[4];
        neighbourhoodID = csv[5];
        neighbourhood = csv[6];
        ward = csv[7];
        assessedValue = Integer.parseInt(csv[8]);
        longitude = Double.parseDouble(csv[9]);
        latitude = Double.parseDouble(csv[10]);
        assessmentClass = csv[15];
        //location = new Point (latitude, longitude)
        //assessmentPercentage = new double[3];
        //for(int j=0; j<3;j++){
            //assessmentPercentage[j] = Double.parseDouble(csv[12+j]);
        //}
    }

    /**Gets the account number of a specific account
     *
     * @return String the account number
     */
    public String actNum(){
        return accountNum;
    }

    /**Gets the suite number of a specific account
     *@return String the suite number
     *
     */
    public String suite(){
        return suite;
    }

    /**Gets the house number of a specific account
     * @return String the house number
     *
     */
    public String houseNum(){
        return houseNum;
    }

    /**Gets the street name of a specific account
     *@return String the street
     *
     */
    public String streetName(){
        return streetName;
    }

    /**Gets a yes or no if the account has a garage
     *@return String yes or no
     *
     */
    public String garage(){
        return garage;
    }

    /**Gets the neighbourhood ID of a specific account
     *@return String the neighbourhood ID
     *
     */
    public String neighbourhoodID(){
        return neighbourhoodID;
    }

    /**Gets the neighbourhood of a specific account
     *@return String the neighbourhood
     *
     */
    public String neighbourhood(){
        return neighbourhood;
    }

    /**Gets the ward of a specific account
     *@return String the ward
     *
     */
    public String ward(){
        return ward;
    }

    /*Gets the assessed value of a specific account
     *@return int the assessed value
     *
     */
    public int assessedValue(){
        return assessedValue;
    }

    /**Gets the longitude of a specific account
     * @return double the longitude
     *
     */
    public double longitude(){
        return longitude;
    }

    /**Gets the latitude of a specific account
     *@return double the latitude
     *
     */
    public double latitude(){
        return latitude;
    }
//    public double[] assessmentPercenatage(){
//        return assessmentPercentage;
//    }

    /**Gets the assessment class of a specific account
     *@return String the assessment class
     *
     */
    public String assessmentClass(){
        return assessmentClass;
    }
}
