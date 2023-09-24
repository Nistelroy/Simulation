package ru.yandex.practicum.process;

import ru.yandex.practicum.objects.Emtity;
import java.util.HashMap;

public class Map {
    public HashMap<Coordinates, Emtity> maps = new HashMap<>();


    public void setEmtity(Coordinates coordinates, Emtity emtitys) {
        emtitys.coordinates = coordinates;
        maps.put(coordinates, emtitys);
    }


    public void startRandomEmtitysPosicion() {
}

}
