package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * method to add a new city to the list
     * @param city is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * method to get the city list in a sorted manner
     * @param flag used to decide whether to sort by city name or province name
     * @return the sorted list
     */

    public List<City> getCities(int flag) {
        List<City> cityList = cities;
        if(flag==1)
            Collections.sort(cityList); // sorts by city name
        else{   // sorts by province name
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
     * method to delete an existing city
     * @param city is the city to delete
     */
    public void Delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }
        else {
            cities.remove(city);
        }
    }

    /**
     * method to count the total number of cities
     * @return item count size of cities list
     */
    public int count(){
        return cities.size();
    }

}
