package ro.mta.se.lab.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
/**
 * clasa de testare CityTest-realizeaza testarea clasei model City
 *Se verifica metodele de get si cele de set folosite in cadrul aplicatiei apartinand clasei model City
 * @author Lazar Sebastian
 */
public class CityTest extends TestCase {
    String id;
    String cityName;
    String country;
    private City cityToCompare;
    private City toSet;
    /**
     * in cadrul functiei de setUp se citeste din fisierul de intrare pana la linia corespunzatoare orasului ale caror informatii le folosim
     * Se verifica astfel ata citirea corecta din fisier pana la acel punct cat si folosirea constructorului din clasa City
     * Se considera obiectul toSet initializat cu anumite date irelevante pentru a se verifica functionalitatea metodelor de tip set
     *
    */
    @Before
    public void setUp() throws Exception {
        id="819827";
        cityName="Razvilka";
        country="RU";

        File file = new File("src/main/resources/orase");
        if(file.exists())
        {
            BufferedReader buffer = new BufferedReader(new FileReader(file));
            String bufferLine;
            bufferLine=buffer.readLine();
            bufferLine=buffer.readLine();
            String[] data= bufferLine.split("\t");
            cityToCompare=new City(data[0],data[1],data[4]);
            toSet=new City("55555","Iasi","RO");
            toSet.setCityName("Razvilka");
            toSet.setCountry("RU");
            toSet.setId("819827");

        }
    }

    /**
     * La nivelul testGetId() se realizeaza testarea getId() verificandu-se daca obiectul a fost corect construit si daca functioneaza returnarea parametrului cautat
     * Acelasi principiu exista si la testGetCityName()-verfica corectitudinea numelui orasului si la testGetCountry()-verifica corectitudinea numelui tarii
     */
    @Test
    public void testGetId() {
        assertEquals(cityToCompare.getId(), this.id);
    }

    @Test
    public void testGetCityName() {
        assertEquals(cityToCompare.getCityName(), this.cityName);
    }

    @Test
    public void testGetCountry() {
        assertEquals(cityToCompare.getCountry(), this.country);
    }

    /**
     * Functiile de tip testSet verifica corectidinea folosirii functiilor set din functia setUp()
     */
    public void testSetId() {
        assertEquals(cityToCompare.getId(), toSet.getId());
    }

    public void testSetCityName() {
        assertEquals(cityToCompare.getCityName(), toSet.getCityName());
    }

    public void testSetCountry() {
        assertEquals(cityToCompare.getCountry(), toSet.getCountry());
    }
}