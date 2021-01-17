package ro.mta.se.lab.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * La nivelul clasei City se definește principala entitate care va fi folosita anume "city" avand metodele specifice si campurile specifice
 * Aceasta clasa reprezinta partea de model a arhitecturii MVC
 *
 * @author Lazar Sebastian
 */

public class City {
    StringProperty id;
    StringProperty cityName;
    StringProperty country;

    /**
     *parametrul id reprezinta un identificator al obiectului de tip City
     * parametrul cityName reprezinta numele orasului
     * parametrul country indica tara(codul tarii din fisierul de intrare)
     */
    public City(String id,String cityName,String country)
    {
        this.id=new SimpleStringProperty(id);
        this.cityName=new SimpleStringProperty(cityName);
        this.country=new SimpleStringProperty(country);
    }
    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    /**
     *
     * metodele descrise reprezinta doar metode de get si set pentru manipularea obiectelor de tip City
     */
    public void setId(String id) {
        this.id.set(id);
    }
    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }
    public String getCountry() {
        return country.get();
    }

    public StringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }
}
