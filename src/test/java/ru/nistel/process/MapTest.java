package ru.nistel.process;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.nistel.objects.Emtity;
import ru.nistel.objects.mouvingObjects.Herbivore;

import static org.junit.Assert.assertEquals;



public class MapTest {
    Map map = new Map();
    Coordinates coordinates = new Coordinates(1,2);
    Herbivore herbivore = new Herbivore(coordinates);
    @Before
    public void setUp() {
        map.maps.put(coordinates, herbivore);
    }

    @Test
    public void isThereAHerbivoreCoordinatesTrue() {
      Emtity herbivoreTest = map.maps.get(coordinates);

        assertEquals("В объект в мапе не совпадает с созданным",herbivore,herbivoreTest);

    }

    @After
    public void tearDown(){

    map.maps.remove(coordinates);

    }
}