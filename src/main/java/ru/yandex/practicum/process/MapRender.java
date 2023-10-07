package ru.yandex.practicum.process;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Predator;
import ru.yandex.practicum.objects.notMovingObjects.Grass;
import ru.yandex.practicum.objects.notMovingObjects.Rock;
import ru.yandex.practicum.objects.notMovingObjects.Tree;

import java.util.Random;

public class MapRender {
    Random random = new Random();
    public static int notMovingObject = Simulation.XX * Simulation.YY / 7;

    public static int movingObject = Simulation.XX * Simulation.YY / 30;
    public void creatingTheNewWorld(Map map) {


        while (true) {
            Coordinates coordinates = new Coordinates(random.nextInt(Simulation.XX ), random.nextInt(Simulation.YY ));
            if (map.maps.entrySet().size() < notMovingObject) {
                if (map.maps.get(coordinates) == null) {
                    Grass emtity = new Grass(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 2) {
                if (map.maps.get(coordinates) == null) {
                    Rock emtity = new Rock(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 3) {
                if (map.maps.get(coordinates) == null) {
                    Tree emtity = new Tree(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 3 + movingObject ) {
                if (map.maps.get(coordinates) == null) {
                    Herbivore emtity = new Herbivore(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < ((notMovingObject * 3 + movingObject * 2)-2)) {
                if (map.maps.get(coordinates) == null) {
                    Predator emtity = new Predator(coordinates);
                    map.setEmtity(coordinates, emtity);
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



