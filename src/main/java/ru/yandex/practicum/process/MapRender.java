package ru.yandex.practicum.process;
import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.*;
import ru.yandex.practicum.objects.mouvingObjects.*;
import ru.yandex.practicum.objects.notMouvingObjects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapRender {
    Random random = new Random();
    int notMoving;

    List<Coordinates> noGrassCor = new ArrayList<>();
    public void creatingTheNewWorld(Map map) {

        notMoving = Simulation.XX * Simulation.YY / 7;
        int moving = Simulation.XX * Simulation.YY / 30;
        while (true) {
            Coordinates coordinates1 = new Coordinates(random.nextInt(Simulation.XX + 1), random.nextInt(Simulation.YY + 1));
            if (map.maps.entrySet().size() < notMoving) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Grass(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < notMoving * 2) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Rock(coordinates1);
                    noGrassCor.add(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < notMoving * 3) {
                if (map.maps.get(coordinates1) == null) {
                    noGrassCor.add(coordinates1);
                    Emtity emtity = new Tree(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < notMoving * 3 + moving) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Herbivore(coordinates1, 1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else if (map.maps.entrySet().size() < notMoving * 3 + moving * 2) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Predator(coordinates1, 1);
                    map.setEmtity(coordinates1, emtity);
                }
            } else {

                break;
            }
        }
    }



    public void render(Map map) {
        for (int i = 1; i < Simulation.XX + 1; i++) {
            System.out.println();
            for (int j = 1; j < Simulation.YY + 1; j++) {
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

