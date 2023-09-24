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
   public static final int XX = 10;
   public static final int YY = 10;
    public static void main(String[] args) {
        Random random = new Random();


        Coordinates coordinates = new Coordinates(XX,YY);
        Map map = new Map();
        map.startRandomEmtitysPosicion();
        Action action = new Action();



        int size = XX*YY;
        int notMouvObj = size / 10;
        int mouvObj = size / 30;


        while (true){
            Coordinates coordinates1 = new Coordinates(random.nextInt(XX + 1), random.nextInt(YY + 1));

            if (map.maps.entrySet().size() < notMouvObj) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Grass(coordinates1);
                    map.setEmtity(coordinates1, emtity);}
            } else if (map.maps.entrySet().size() < notMouvObj*2) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Rock(coordinates1);
                    map.setEmtity(coordinates1, emtity);}
            } else if (map.maps.entrySet().size() < notMouvObj*3) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Tree(coordinates1);
                    map.setEmtity(coordinates1, emtity);}
            } else if (map.maps.entrySet().size() < notMouvObj*3+mouvObj) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Herbivore(coordinates1, 1);
                    map.setEmtity(coordinates1, emtity);}
            } else if (map.maps.entrySet().size() < notMouvObj*3+mouvObj*2) {
                if (map.maps.get(coordinates1) == null) {
                    Emtity emtity = new Prefator(coordinates1, 1);
                    map.setEmtity(coordinates1, emtity);}
            } else { break; }
        }
        action.render(map);

        System.out.println(map.maps.entrySet().size());
        }



    }
   // nextTurn() -  // просимулировать и отрендерить один ход
   // startSimulation() - // запустить бесконечный цикл симуляции и рендеринга
   // pauseSimulation() - // приостановить бесконечный цикл симуляции и рендеринга

