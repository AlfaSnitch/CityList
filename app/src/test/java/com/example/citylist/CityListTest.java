package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * this is a class where unit test is done
 */
public class CityListTest {
    /**
     * method to create a mock citylist for testing purpose
     * @return a citylist
     */
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    /**
     * method to create a mock city for testing purpose
     * @return a city
     */
    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    /**
     * this is a test-method for the "add" method
     */
    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    /**
     * this is a test-method for the "Delete" method
     */
    @Test
    public void testDelete(){
        CityList citylist = new CityList();
        City city = new City("Daulatpur","Khulna");
        City city1 = new City("Bonani","Dhaka");
        // adding the cities to the city list
        citylist.add(city);
        citylist.add(city1);

        citylist.Delete(city);
        assertTrue(!citylist.getCities(1).contains(city)); // not going to be true

    }

    /**
     * this is a test-method for the "delte" method's exception handling
     */
    @Test
    public void testDeleteException(){
        CityList citylist = new CityList();
        City city = new City("Daulatpur","Khulna");
        City city1 = new City("Jessore", "Khulna");
        // add city to the list but not city1
        citylist.add(city);
        // now if i try to delete city1 then it should throw an exception
        assertThrows(IllegalArgumentException.class,()->{citylist.Delete(city1);});
    }

    /**
     * this is a test-method for the "count" method
     */
    @Test
    public void testCount(){
        CityList cityList = new CityList();
        City city = new City("Daulatpur","Khulna");
        City city1 = new City("Jessore", "Khulna");
        //adding them to the list
        cityList.add(city);
        cityList.add(city1);
        // now the list has 2 cities, lets check that fact
        assertEquals(2,cityList.count());
        // now lets delete a city and check again
        cityList.Delete(city);
        //now the answer should be 1
        assertEquals(1,cityList.count());
    }

    /**
     * this is a test-method for the "add" method's exception handling
     */
    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    /**
     * this is a test-method for the "getcities" method to sort
     */
    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 = new City("AB","HI");
        City city2 = new City("CD","EF");

        cityList.add(city1);
        cityList.add(city2);
        // sort by city => 1.AB 2.CD
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));
        //now if we sort by province then 1.EF 2.HI
        assertEquals(0, city2.compareTo(cityList.getCities(2).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(2).get(1)));
    }
}
