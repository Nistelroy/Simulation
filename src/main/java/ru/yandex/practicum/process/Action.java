package ru.yandex.practicum.process;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Predator;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;

import java.util.ArrayList;
import java.util.List;

public class Action {

    List<Coordinates> grassCor = new ArrayList<>();

    public List<Coordinates> findGrass(Map map) {
        for (int i = 1; i < Simulation.XX + 1; i++) {
            for (int j = 1; j < Simulation.YY + 1; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) != null) {
                    if (Grass.class.equals(map.maps.get(cor).getClass())) {
                        grassCor.add(cor);
                    }
                }
            }
        } return grassCor;
    }

    public void nextTurn(Map map) {

int steps = 0;

        for (int i = 1; i < Simulation.XX + 1; i++) {
            for (int j = 1; j < Simulation.YY + 1; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) != null) {
                    if (Grass.class.equals(map.maps.get(cor).getClass())){


                    } else if (Predator.class.equals(map.maps.get(cor).getClass())) {
                        Predator predator = (Predator) map.maps.get(cor);
                        predator.move();
                    } else if (Herbivore.class.equals(map.maps.get(cor).getClass())) {
                        Herbivore herbivore = (Herbivore) map.maps.get(cor);
                        Coordinates cor1 = herbivore.move(map);
                        map.maps.put(cor1, herbivore);
                        map.maps.remove(cor);
                        if (steps < 3){
                            steps++;
                        } else
                        break;

                    }

                }
            }
        }
    }
}


