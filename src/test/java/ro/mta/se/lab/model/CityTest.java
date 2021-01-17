package ro.mta.se.lab.model;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CityTest extends TestCase {
    String id;
    String cityName;
    String country;
    private City cityToCompare;
    private City toSet;
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