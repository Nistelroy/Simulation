package ru.yandex.practicum;

import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Prefator;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.Random;

public class Simulation {
    public static void main(String[] args) {
        Random random = new Random();
        final int XX = 10;
        final int YY = 10;
        Coordinates coordinates = new Coordinates(1,2);
        Coordinates coordinates2 = new Coordinates(2,2);
        Map map = new Map();
        map.startRandomEmtitysPosicion();
        Action action = new Action();
        action.render(map);
        boolean bol = map.maps.get(coordinates) != null;
        System.out.println(bol);

        int size = XX*YY;
        int notMouvObj = size / 10;
        int mouvObj = size / 30;


        while (true){
            Coordinates coordinates1 = new Coordinates(random.nextInt(XX + 1), random.nextInt(YY + 1));
            if (map.maps.entrySet().size() < notMouvObj) {
                if (map.maps.get(coordinates1) == null) {
                    System.out.print("создаю фигуру травы ");
                    Emtity emtity = new Grass(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                    System.out.print(map.maps.get(coordinates1).coordinates.HEIGHT + " ");
                    System.out.print(map.maps.get(coordinates1).coordinates.WIDTH + " ");
                    System.out.println(map.maps.entrySet().size());
                }
            } else if ((notMouvObj <= map.maps.entrySet().size()) && map.maps.entrySet().size() < (notMouvObj*2)) {
                if (map.maps.get(coordinates1) == null) {
                    System.out.print("создаю фигуру камня ");
                    Emtity emtity = new Rock(coordinates1);
                    map.setEmtity(coordinates1, emtity);
                    System.out.print(map.maps.get(coordinates1).coordinates.HEIGHT + " ");
                    System.out.print(map.maps.get(coordinates1).coordinates.WIDTH + " ");
                    System.out.println(map.maps.entrySet().size());
                }
            } else if (notMouvObj*2 <= map.maps.entrySet().size() && map.maps.entrySet().size() < notMouvObj*3) {
                if (map.maps.get(coordinates1) == null) {
                System.out.print("создаю фигуру дерева ");
                Emtity emtity = new Tree(coordinates1);
                map.setEmtity(coordinates1, emtity);
                    System.out.print(map.maps.get(coordinates1).coordinates.HEIGHT + " ");
                    System.out.print(map.maps.get(coordinates1).coordinates.WIDTH + " ");
                    System.out.println(map.maps.entrySet().size());
            }}
            else if (notMouvObj*3 <= map.maps.entrySet().size() && map.maps.entrySet().size() < notMouvObj*3+mouvObj) {
                if (map.maps.get(coordinates1) == null) {
                System.out.print("создаю фигуру травоядного ");
                Emtity emtity = new Herbivore(coordinates1, 1);
                map.setEmtity(coordinates1, emtity);
                    System.out.print(map.maps.get(coordinates1).coordinates.HEIGHT + " ");
                    System.out.print(map.maps.get(coordinates1).coordinates.WIDTH + " ");
                    System.out.println(map.maps.entrySet().size());
            }}
            else if (notMouvObj*3+mouvObj <= map.maps.entrySet().size() && map.maps.entrySet().size() < notMouvObj*3+mouvObj*2) {
                if (map.maps.get(coordinates1) == null) {
                System.out.print("создаю фигуру хищника ");
                Emtity emtity = new Prefator(coordinates1, 1);
                map.setEmtity(coordinates1, emtity);
                    System.out.print(map.maps.get(coordinates1).coordinates.HEIGHT + " ");
                    System.out.print(map.maps.get(coordinates1).coordinates.WIDTH + " ");
                    System.out.println(map.maps.entrySet().size());
            }}
            else {
                break;
            }

        }
        System.out.println(map.maps.entrySet().size());
        }



    int a = 123;

    }
   // nextTurn() -  // просимулировать и отрендерить один ход
   // startSimulation() - // запустить бесконечный цикл симуляции и рендеринга
   // pauseSimulation() - // приостановить бесконечный цикл симуляции и рендеринга

