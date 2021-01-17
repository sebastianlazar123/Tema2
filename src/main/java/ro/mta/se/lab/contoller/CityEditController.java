package ro.mta.se.lab.contoller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ro.mta.se.lab.model.City;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * La nivelul clasei CityEditController se realizeaza partea de manipulare a datelor si de rezolvare a functionalitatilor
 * Aceasta clasa reprezinta partea de controller a arhitecturii MVC
 * In momentul deschiderii aplicatiei se apeleaza initialize()
 * In cadrul initialize()  se apeleaza read_context() unde se realizeaza citirea datelor din fisier
 * selectCountry() si selectCity() se apeleaza in momentul in care se face alegerea la nivel de combobox
 * getInfo() se apeleaza in momentul apasarii butonului Selecteaza
 * @author Lazar Sebastian
 */
public class CityEditController {
    private ObservableList<City>initialData=FXCollections.observableArrayList();
    private ObservableList<String>list=FXCollections.observableArrayList();
    private ObservableList<String>cityList2=FXCollections.observableArrayList();
    /**
     *in initialData retinem toate obiectele de tip City obtinute in urma citirii
     * in list retinem toate codurile de identificare a tarilor distincte
     * in cityList2 retinem numele oraselor specifice unui anumit cod prelucrarea lui cityList2 facandu-se in selectCountry()
     */
    private String findCityinfo;
    private String findCountryinfo;
    /**
     * findCityinfo- numele orasului pentru care se vor obtine informatii
     * findCountryinfo-codul de identificare a tarii
    */
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
    @FXML
    private Label eroare;

    /**
     *
     * metoda selectCountry obtine codul de identificare a tarii si insereaza in cityList2 doar campul cityName din obiectele City din lista initialData al caror
     * cod de identificare al tarii este acelasi cu s(cel obtinut/ales de utilizator)
     */
    public void selectCountry(ActionEvent actionEvent) {
        String s=null;
        if(countryCombo.getSelectionModel().getSelectedItem()!=null)
        s = countryCombo.getSelectionModel().getSelectedItem().toString();
        findCountryinfo=s;
        int i=0;
        if(!cityList2.isEmpty())
        {
            cityList2.clear();
        }
        for(i=0;i<initialData.size();i++)
        {
            if(initialData.get(i).getCountry().contains(s))
            {
                cityList2.add(initialData.get(i).getCityName());
            }

        }

        cityCombo.setItems(cityList2);
    }
    /**
     *
     * metoda selectCity obtine numele orasului selectat dupa care se vor obtine datele
     */
    public void selectCity(ActionEvent actionEvent) {
        String s=null;
        if(cityCombo.getSelectionModel().getSelectedItem()!=null)
        s = cityCombo.getSelectionModel().getSelectedItem().toString();
        findCityinfo=s;
    }
    /**
     *
     * metoda getInfo obtine obiectul de tip Json pentru orasul si tara selectata de utilizator si se apeleaza in momentul apasarii butonului selecteaza
     * tot la nivelul acestei metode se seteaza variabilele de tip Label dupa ce se obtin date din obiect
     * un ultim aspect realizat la nivelul acestei metode este scrierea in istoric.txt reprezentand jurnalul/logger-ul aplicatiei
     */
    public void getInfo(ActionEvent actionEvent) throws IOException, JSONException {
        URL link;
        String s=null;
        if(findCountryinfo!=null &&findCityinfo!=null) {
            s="Orasul : "+findCityinfo;
            selectedCity.setText(s);
            eroare.setText("");
            link = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + findCityinfo + "," + findCountryinfo + "&appid=1ea572eb3298134d404f1c9572107c7e&lang=ro&units=metric");
            URLConnection connectionEstabilished = link.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connectionEstabilished.getInputStream()));
            String down = IOUtils.toString(reader);
            JSONObject obj = new JSONObject(down);
            JSONArray arr = obj.getJSONArray("weather");
            String post_id = "Descrierea vremii : " + arr.getJSONObject(0).getString("description");
            weatherDescription.setText(post_id);
            int p = obj.getJSONObject("main").getInt("humidity");
            humidity.setText("Umiditate este : " + String.valueOf(p) + "%");
            temperature.setText("Temperatura este :" + String.valueOf(obj.getJSONObject("main").getInt("temp")) + " grade Celsius");
            wind.setText("Viteza vantului este :" + String.valueOf(obj.getJSONObject("wind").getInt("speed")) + "m/s");
            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            String toHistory="La data si ora :"+formatter.format(date)+",Orasul: "+findCityinfo+",Descrierea vremii:"+arr.getJSONObject(0).getString("description")+",Temperatura a fost:";
            toHistory=toHistory+String.valueOf(obj.getJSONObject("main").getInt("temp")) + " grade Celsius";
            FileWriter outputFile=new FileWriter("src/main/resources/istoric.txt",true);
            outputFile.write(toHistory);
            outputFile.write("\n");
            outputFile.close();
            findCityinfo = null;
            findCountryinfo = null;
        }
        else
        {
            eroare.setText("Alege inainte sa apesi butonul!");
        }
    }
    /**
     *
     * read_context() realizeaza citirea datelor din fisier
     * crearea listei de obiecte de tip City initialData
     * O conditie pentru functionarea corecta este existenta tab intre campurile consecutive din fisierul de intrare
     * Se realizeaza in variabila vectorul list obtinirea codurilor de identificare distincte ale tarilor
     */
    private void read_context() throws IOException {
        File file = new File("src/main/resources/orase");
        if (file.exists()) {

            BufferedReader buffer = new BufferedReader(new FileReader(file));

            String str;
            str= buffer.readLine();
            while ((str = buffer.readLine()) != null) {

                String[] file_data = str.split("\t");
                City aux = new City(file_data[0], file_data[1], file_data[4]);
                initialData.add(aux);
                int i=0;
                for(i=0; i<list.size() ;i++)
                {
                    if(file_data[4].equals(list.get(i)))
                    {
                    i= list.size()+2;
                    }
                }
                if(i==list.size())
                {
                    list.add(file_data[4]);
                }

            }

        }
    }
    /**
     *
     * metoda initialize() apeleaza read_context()
     * dupa obtinerea listei identificatorilor tarilor seteaza la nivelul combobox-ului specific tarilor lista cu identificatori
     */
    @FXML
    public void initialize()throws IOException{
        //ObservableList<String>list= FXCollections.observableArrayList("RO","HU","UK","FR","SP");

            read_context();
        countryCombo.setItems(list);
    }
}
