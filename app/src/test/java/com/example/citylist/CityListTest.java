package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testdelete()//---RS
    {
        CityList cList = new CityList();
        City c1 = new City("Mumbai","Maharashtra");
        City c2 = new City("Kolkata","West Bengal");

        cList.add(c1);
        cList.add(c2);

        cList.delete(c1);
        assertTrue(!cList.getCities(1).contains(c1));
    }

    @Test
    public void testDeleteException()//----RS
    {
        CityList cList = new CityList();
        City c1 = new City("Mumbai","Maharashtra");
        City c2 = new City("Kolkata","West Bengal");

        cList.add(c1);
        cList.add(c2);

        cList.delete(c1);
        assertThrows(IllegalArgumentException.class, () -> {
            cList.delete(c1);
        });
    }
    @Test
    public void testcount()//-----RS
    {
        CityList cList = new CityList();
        City c1 = new City("Mumbai","Maharashtra");
        City c2 = new City("Kolkata","West Bengal");
        City c3 = new City("Chennai","Tamil Nadu");

        cList.add(c1);
        cList.add(c2);
        cList.add(c3);
        assertEquals(3,cList.count());

        cList.delete(c1);
        assertEquals(2,cList.count());

        cList.delete(c2);
        cList.delete(c3);
        assertEquals(0,cList.count());
    }

    @Test
    public void testGetCities()//-----RS
    {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testSortedCities()
    {
        CityList cityList = new CityList();
        City c1= new City("AA", "ZZ");
        cityList.add(c1);
        assertEquals(0, c1.compareTo(cityList.getCities(1).get(0)));//c1 comparing with the index zero of the sorted array(get(0) diye index 0 er value antesi)

        City c2 = new City("DD", "YY");
        cityList.add(c2);
        //city wise sorting test
        assertEquals(0, c1.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, c2.compareTo(cityList.getCities(1).get(1)));
        //province wise sorting test
        assertEquals(0, c1.compareTo(cityList.getCities(2).get(1)));
        assertEquals(0, c2.compareTo(cityList.getCities(2).get(0)));


    }
}
