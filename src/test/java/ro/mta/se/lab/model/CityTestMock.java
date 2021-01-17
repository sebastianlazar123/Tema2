package ro.mta.se.lab.model;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
/**
 * clasa de testare CityTestMock-realizeaza testarea clasei model City folosind metodele oferite de Mockito
 *Se verifica metodele de get  folosite in cadrul aplicatiei apartinand clasei model City
 * @author Lazar Sebastian
 */
public class CityTestMock {
    String id;
    String cityName;
    String country;
    private City cityToCompare;
    City test = mock(City.class);

    /**
     *
     *functia setUp explica ce ar trebui sa returneze obiectul mock in momentul apelarii anumitor metode
     */
    @Before
    public void setUp() throws Exception {
        id="819827";
        cityName="Razvilka";
        country="RU";
        cityToCompare=new City("819827","Razvilka","RU");
        when(test.getId()).thenReturn("819827");
        when(test.getCityName()).thenReturn("Razvilka");
        when(test.getCountry()).thenReturn("RU");
    }

    /**
     * fuctiile de test verifica corectitudinea metodelor de tip get folosite din clasa City
     */
    @Test
    public void testGetId() {
        assertEquals(cityToCompare.getId(),test.getId());
    }


    @Test
    public void testGetCityName() {
        assertEquals(cityToCompare.getCityName(), test.getCityName());
    }

    @Test
    public void testGetCountry() {
        assertEquals(cityToCompare.getCountry(), test.getCountry());
    }
}