package com.example.propertyassessment;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class PropertyAssignment {
    private SimpleStringProperty account;
    private SimpleStringProperty address;
    private SimpleStringProperty value;
    //private SimpleStringProperty houseNum;
    private SimpleStringProperty clas;
    private SimpleStringProperty neighbourhood;
    private SimpleDoubleProperty longitude;
    private SimpleDoubleProperty latitude;
    double[] assessmentPercentage;

    /**
     *The constructor of the propertyAssessment class
     */
    PropertyAssignment(String account, String address, String value,String clas, String neighbourhood, double longitude, double latitude ) {
        this.account = new SimpleStringProperty(account);
        this.address = new SimpleStringProperty(address);
        this.clas = new SimpleStringProperty(clas);
        this.value = new SimpleStringProperty(value);
        this.neighbourhood = new SimpleStringProperty(neighbourhood);
        this.longitude = new SimpleDoubleProperty(longitude);
        this.latitude = new SimpleDoubleProperty(latitude);
        //this.houseNum = new SimpleStringProperty(houseNum);
    }

    /**
     *Gets the account number
     *@return String account number
     */
    public String getAccount() { return account.get(); }

    /**
     *Sets the account number
     * @param account
     *
     */
    public void setAccount(String account ) { this.account.set(account); }

    /**
     *Gets the address
     *@return String address
     */
    public String getAddress() { return address.get(); }

    /**
     *Sets the address
     * @param address
     */
    public void address(String address ) { this.address.set(address); }

    /**
     *Gets the assessment value
     *@return String the assessment value
     */
    public String getValue() { return value.get(); }

    /**
     *Sets the assessment value
     * @param value
     */
    public void setValue(String value ){
        this.value.set(value);
    }

    /**
     *Gets the assessment class
     *@return String assessment class
     */
    public String getClas() { return clas.get(); }

    /**
     *Sets the assessment class
     * @param clas
     */
    public void setClas(String clas ){
        this.clas.set(clas);
    }

    /**
     *Gets the neighbourhood
     *@return String neighbourhood
     */
    public String getNeighbourhood() { return neighbourhood.get(); }

    /**
     *Sets the neighbourhood
     * @param neighbourhood
     */
    public void setNeighbourhood(String neighbourhood ){
        this.neighbourhood.set(neighbourhood);
    }
    /**
     *Gets the longitude
     *@return double longitude
     */
    public double getLongitude() { return longitude.get(); }

    /**
     *Sets the longitude
     * @param longitude
     */
    public void setLongitude(double longitude) { this.longitude.set(longitude); }

    /**
     *Gets the latitude
     *@return double latitude
     */
    public double getLatitude() { return latitude.get(); }

    /**
     *Sets the latitude
     * @param  latitude
     */
    public void setLatitude(double latitude ){
        this.latitude.set(latitude);
    }

    //public String getHouseNum() { return houseNum.get(); }

    //public void setHouseNum(String houseNum ) { this.houseNum.set(houseNum); }

}
