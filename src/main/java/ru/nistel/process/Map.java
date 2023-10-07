package ru.nistel.process;

import ru.nistel.objects.Emtity;

import java.util.HashMap;

public class Map {
    public HashMap<Coordinates, Emtity> maps = new HashMap<>();

    public void setEmtity(Coordinates coordinates, Emtity emtity) {
        emtity.coordinates = coordinates;
        maps.put(coordinates, emtity);
    }

}
