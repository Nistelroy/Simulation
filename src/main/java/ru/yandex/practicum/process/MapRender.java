package ru.yandex.practicum.process;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Predator;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;

import java.util.Random;

public class MapRender {
    Random random = new Random();
    int stationaryObject;

    public void creatingTheNewWorld(Map map) {

        stationaryObject = Simulation.XX * Simulation.YY / 7;
        int movingObject = Simulation.XX * Simulation.YY / 30;
        while (true) {
            Coordinates coordinates1 = new Coordinates(random.nextInt(Simulation.XX ), random.nextInt(Simulation.YY ));
            if (map.maps.entrySet().size() < stationaryObject) {
                if (map.maps.get(coordinates1) == null) {
                    Grass emtity = new Grass(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < stationaryObject * 2) {
                if (map.maps.get(coordinates1) == null) {
                    Rock emtity = new Rock(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < stationaryObject * 3) {
                if (map.maps.get(coordinates1) == null) {

                    Tree emtity = new Tree(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < stationaryObject * 3 + movingObject ) {
                if (map.maps.get(coordinates1) == null) {
                    Herbivore emtity = new Herbivore(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < ((stationaryObject * 3 + movingObject * 2)-2)) {
                if (map.maps.get(coordinates1) == null) {
                    Predator emtity = new Predator(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else {

                break;
            }
        }
    }



    public void render(Map map) {
        for (int i = 0; i < Simulation.XX ; i++) {
            System.out.println();
            for (int j = 0; j < Simulation.YY ; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) == null) {
                    System.out.print("  ☘ ");
                } else {
                    System.out.print(getEmptySprite(map.maps.get(cor)));
                }
            }
        }
    }


        private String getEmptySprite (Emtity emtity){
            if (emtity.getClass().equals(Grass.class)) {

                return " \uD83C\uDF40 ";
            } else if (emtity.getClass().equals(Rock.class)) {
                return " \uD83C\uDF33 ";
            } else if (emtity.getClass().equals(Tree.class)) {
                return " \uD83C\uDF32 ";
            } else if (emtity.getClass().equals(Herbivore.class)) {
                return " \uD83E\uDD93 ";
            } else if (emtity.getClass().equals(Predator.class)) {
                return " \uD83D\uDE3E ";
            } else {
                return "  ☘ ";
            }
        }

    }

