package ru.yandex.practicum.process;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;

import static org.junit.Assert.assertEquals;



public class MapTest {
    Map map = new Map();
    Coordinates coordinates = new Coordinates(1,2);
    Herbivore herbivore = new Herbivore(coordinates);
    @Before
    public void setUp() throws Exception {
        map.maps.put(coordinates, herbivore);
    }

    @Test
    public void isThereAHerbivoreCoordinatesTrue() {
      Emtity herbivoreThis = map.maps.get(coordinates);

        assertEquals("В объект в мапе не совпадает с созданным",herbivore,herbivoreThis);

    }

    @After
    public void tearDown() throws Exception {

    map.maps.remove(coordinates);

    }
}