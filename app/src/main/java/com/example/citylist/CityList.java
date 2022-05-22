package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 * @auther Ghani91
 * @version 3.1.2
 * @since 2022
 * @see <a href = "https://docs.oracle.com/en/java/javase/14/docs/api/index.html">Java Docs</a>
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This deletes a city from the list if that city exists
     * @param city
     *      This is the city to delete
     */
    public void delete(City city )//---RS
    {
        if( !cities.contains(city) )
        {
            throw new IllegalArgumentException();
        }
        else
        {
            cities.remove(city);
        }
    }


    /**
     * This returns a sorted list of cities
     * @param param
     *         if the param is 1 the list is sorted by city
     *         else the list is sorted by province
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities( int param ) //---RS
    {
        List<City> cityList = cities;
        if( param == 1 )
        {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }
        return cityList;
    }

    /**
     * This returns a count of the Cities from the list
     * @return
     *      Return the count of the Cities from the list
     */
    public int count()//---RS
    {
        return cities.size();
    }

}
