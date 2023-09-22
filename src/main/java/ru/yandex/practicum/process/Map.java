package ru.yandex.practicum.process;

import ru.yandex.practicum.objects.Emtity;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Emtity> maps = new HashMap<>();

    public void setObjects(Emtity emtity, Coordinates coordinates) {
        emtity.setCoordinates(coordinates);
        maps.put(coordinates, emtity);
    }
    public void startRandomEmtityPosicion(){
        for (int i = 0; i < Coordinates.height.longValue(); i++) {

        }
    }
}
