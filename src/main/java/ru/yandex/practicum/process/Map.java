package ru.yandex.practicum.process;

import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;

import java.util.HashMap;
import java.util.Random;

public class Map {
    public HashMap<Coordinates, Emtity> maps = new HashMap<>();
    Random random = new Random();

    public void setEmtity(Coordinates coordinates, Emtity emtitys) {
        emtitys.coordinates = coordinates;
        maps.put(coordinates, emtitys);
    }

    public void startRandomEmtitysPosicion() {
        // for (int i = 0; i < 8; i++) {
        //  setEmtity(new Coordinates(1, i), new Grass(new Coordinates(1, i)));
            /*
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            setEmtity(new Coordinates(random.nextInt(x), random.nextInt(y)), new Grass(new Coordinates(random.nextInt(x), random.nextInt(y)))); */
//    }

}
    public static boolean isSquareDark(Coordinates coordinates) {
    return ((coordinates.HEIGHT + coordinates.WIDTH)) % 2 == 0;
    }
}
