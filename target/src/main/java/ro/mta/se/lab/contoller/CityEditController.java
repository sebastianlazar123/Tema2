package ro.mta.se.lab.contoller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CityEditController {
    @FXML
    private ComboBox cityCombo;
    @FXML
    private ComboBox countryCombo;
    @FXML
    private Label selectedCity;
    @FXML
    private Label weatherDescription;
    @FXML
    private Label temperature;
    @FXML
    private Label humidity;
    @FXML
    private Label wind;
    @FXML
    private Button selected;


    public void selectCountry(ActionEvent actionEvent) {

        String s = countryCombo.getSelectionModel().getSelectedItem().toString();
        if(s.equals("RO"))
        {
            ObservableList<String>cityList= FXCollections.observableArrayList("Iasi","Bucuresti");
            cityCombo.setItems(cityList);

        }
        if(s.equals("HU"))
        {
            ObservableList<String>cityList= FXCollections.observableArrayList("Budapesta","Debrecen");
            cityCombo.setItems(cityList);

        }
        if(s.equals("UK"))
        {
            ObservableList<String>cityList= FXCollections.observableArrayList("Kiev","Donetsk");
            cityCombo.setItems(cityList);

        }
        if(s.equals("FR"))
        {
            ObservableList<String>cityList= FXCollections.observableArrayList("Paris","Lyon");
            cityCombo.setItems(cityList);

        }
        if(s.equals("SP"))
        {
            ObservableList<String>cityList= FXCollections.observableArrayList("Madrid","Barcelona");
            cityCombo.setItems(cityList);

        }
    }

    public void selectCity(ActionEvent actionEvent) {
        String s = countryCombo.getSelectionModel().getSelectedItem().toString();
        selectedCity.setText(s);
    }
    @FXML
    public void initialize(){
        ObservableList<String>list= FXCollections.observableArrayList("RO","HU","UK","FR","SP");
        countryCombo.setItems(list);
    }
}
