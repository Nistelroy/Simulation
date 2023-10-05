package ru.yandex.practicum.process;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Predator;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;

import java.util.ArrayList;
import java.util.List;

public class Action {

    List<Coordinates> grassCor = new ArrayList<>();


    public List<Coordinates> findGrass(Map map) {
        for (int i = 0; i < Simulation.XX ; i++) {
            for (int j = 0; j < Simulation.YY; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) != null) {
                    if (Grass.class.equals(map.maps.get(cor).getClass())) {
                        grassCor.add(cor);
                    }
                }
            }
        }
        return grassCor;
    }

    public void nextTurn(Map map) {
        List<Coordinates> predatorCor = new ArrayList<>();
        List<Coordinates> herbivoreCor = new ArrayList<>();
        List<Coordinates> objectCor = new ArrayList<>();
        for (int i = 0; i < Simulation.XX ; i++) {
            for (int j = 0; j < Simulation.YY ; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) != null) {
                    if (Rock.class.equals(map.maps.get(cor).getClass())) {
                        objectCor.add(cor);
                    } else if (Tree.class.equals(map.maps.get(cor).getClass())) {
                        objectCor.add(cor);
                    } else if (Predator.class.equals(map.maps.get(cor).getClass())) {
                        predatorCor.add(cor);
                        objectCor.add(cor);
                    } else if (Herbivore.class.equals(map.maps.get(cor).getClass())) {
                        herbivoreCor.add(cor);
                        objectCor.add(cor);

                    }
                }
            }
        }
        System.out.println();

        for (int i = 0; i < herbivoreCor.size(); i++) {

            System.out.println(herbivoreCor.get(i).height + " --" + " X "+ herbivoreCor.get(i).width + " --" + " Y herb "+ herbivoreCor.get(i).hashCode());
            map.maps.get(herbivoreCor.get(i));
            Herbivore herbivore = (Herbivore) map.maps.get(herbivoreCor.get(i));
            Coordinates cor1 = herbivore.move(map);
            map.maps.put(cor1, herbivore);
            map.maps.remove(herbivoreCor.get(i));
            System.out.println(herbivoreCor.get(i).height + " --" + " X "+ herbivoreCor.get(i).width + " --" + " Y herb "+ herbivoreCor.get(i).hashCode());


        }
        for (int i = 0; i < predatorCor.size(); i++) {
            map.maps.get(predatorCor.get(i));
            System.out.println("ВОлк найден");

        }
    }

}

