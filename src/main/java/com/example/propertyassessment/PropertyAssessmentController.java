package com.example.propertyassessment;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static com.example.propertyassessment.Statistics.*;

public class PropertyAssessmentController implements Initializable {

    @FXML
    private TableView myTable;
    @FXML
    private TextArea comment;
    @FXML
    private TextField accField;
    @FXML
    private TextField addField;
    @FXML
    private TextField neighbourField;
    @FXML
    private ComboBox<String> assessBox;

    ObservableList<PropertyAssignment> data = FXCollections.observableArrayList();
    ObservableList<PropertyAssignment> infor = FXCollections.observableArrayList();
    ArrayList<String[]> list = new ArrayList<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn account = new TableColumn("Account");
        TableColumn address = new TableColumn("Address");
        TableColumn value = new TableColumn("Assessed Value");
        TableColumn clas = new TableColumn("Assessment Class");
        TableColumn neighbourhood = new TableColumn("Neighbourhood");
        TableColumn latitude = new TableColumn("Latitude");
        TableColumn longitude = new TableColumn("Longitude");

        myTable.getColumns().addAll(account, address, value, clas, neighbourhood, latitude, longitude);

        OpenFile file = new OpenFile();
        file.openFile();
        list = file.getFile();
        for (String[] i: list) {
            Data info = new Data(i);
            String assess = numSort(info.assessedValue());
            String addr = info.suite()+" "+info.houseNum()+" "+info.streetName();
            data.add(new PropertyAssignment(info.actNum(), addr,
                    assess, info.assessmentClass(),
                    info.neighbourhood(), info.latitude(), info.longitude())
            );
        }

        account.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("account"));
        address.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("address"));
        value.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("value"));
        clas.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("clas"));
        neighbourhood.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("neighbourhood"));
        latitude.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("latitude"));
        longitude.setCellValueFactory(new PropertyValueFactory<PropertyAssignment, String>("longitude"));

        myTable.setItems(data);
    }

    /**Sorts an integer into a currency format.
     * @param num
     * @return String the money
     */
    public static String numSort(int num){
        double newNum = num;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(newNum);

        if (moneyString.endsWith(".00")) {
            int centsIndex = moneyString.lastIndexOf(".00");

            if (centsIndex != -1)
                moneyString = moneyString.substring(1, centsIndex);
        }
        moneyString = "$"+moneyString;

        return moneyString;
    }

    /**
     *Operates the search button in the fxml document
     * @param event
     */
    @FXML
    public void handleSearch(ActionEvent event){

        String pick = assessBox.getSelectionModel().getSelectedItem();
        String acc = accField.getText();
        String add = addField.getText();
        String neighbour = neighbourField.getText();

        if (acc != null && !acc.isEmpty()) {
            data.removeIf(propertyAssessment -> !propertyAssessment.getAccount().contains(acc));
            //sortList1(acc);
        }

        if (add != null && !add.isEmpty()) {

            data.removeIf(propertyAssessment -> !propertyAssessment.getAddress().contains(add));
            //sortList2(add);
        }
        if (neighbour != null && !neighbour.isEmpty()) {

            data.removeIf(propertyAssessment -> !propertyAssessment.getNeighbourhood().contains(neighbour.toUpperCase()));
            //sortList3(neighbour);
        }


        if (pick == null){
            myTable.setItems(data);

        }
        else if (pick.equals("Residential")){

            if (assessBox.getValue() != null && !assessBox.getValue().isEmpty()) {
                data.removeIf(propertyAssessment -> !propertyAssessment.getClas().equalsIgnoreCase(assessBox.getValue()));
                //sortList(pick);
            }
        }
        else if (pick.equals("Other Residential")){
            if (assessBox.getValue() != null && !assessBox.getValue().isEmpty()) {
                data.removeIf(propertyAssessment -> !propertyAssessment.getClas().equalsIgnoreCase(assessBox.getValue()));
                //sortList(pick);
            }
        }
        else if (pick.equals("Commercial")){
            if (assessBox.getValue() != null && !assessBox.getValue().isEmpty()) {
                data.removeIf(propertyAssessment -> !propertyAssessment.getClas().equalsIgnoreCase(assessBox.getValue()));
                //sortList(pick);
            }
        }
        else if (pick.equals("Farmland")){
            if (assessBox.getValue() != null && !assessBox.getValue().isEmpty()) {
                data.removeIf(propertyAssessment -> !propertyAssessment.getClas().equalsIgnoreCase(assessBox.getValue()));
                //sortList(pick);
            }
        }



        Statistics stats = new Statistics();
        ArrayList<String[]> showing = new ArrayList<>(myTable.getItems());
        int Min = stats.min(showing);
        int Max = max(list);
        int Range = range(Max, Min);
        int Mean = mean(list);
        int Median = median(list);
        int stanDev = SD(list, Mean);

        comment.setText("Statistics of assessed values;\n\nNumber of properties: "
                +data.size()+"\nMin: "+Min+"\nMax: "
                +Max+"\nRange: "+numSort(Range)+"\nMean: "+numSort(Mean)+
                "\nMedian: "+numSort(Median)+"\nStandard Deviation: "+numSort(stanDev));


        myTable.setItems(data);
    }
}