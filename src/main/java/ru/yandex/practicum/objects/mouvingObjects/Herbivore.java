package ru.yandex.practicum.objects.mouvingObjects;


import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.ArrayList;
import java.util.List;


public class Herbivore extends Creature {

    List<Coordinates> grassCor = new ArrayList<>();
    public Coordinates move(Map map) {

        Action action = new Action();
        grassCor = action.findGrass(map);


        Coordinates cor1 = new Coordinates(coordinates.height+1,coordinates.width-1);
        Coordinates cor2 = new Coordinates(coordinates.height+1,coordinates.width);
        Coordinates cor3 = new Coordinates(coordinates.height+1,coordinates.width+1);
        Coordinates cor4 = new Coordinates(coordinates.height,coordinates.width-1);
        Coordinates cor5 = new Coordinates(coordinates.height,coordinates.width+1);
        Coordinates cor6 = new Coordinates(coordinates.height-1,coordinates.width-1);
        Coordinates cor7 = new Coordinates(coordinates.height-1,coordinates.width);
        Coordinates cor8 = new Coordinates(coordinates.height-1,coordinates.width+1);

        List<Coordinates> possibleStep = new ArrayList<>();
        possibleStep.add(cor1);
        possibleStep.add(cor2);
        possibleStep.add(cor3);
        possibleStep.add(cor4);
        possibleStep.add(cor5);
        possibleStep.add(cor6);
        possibleStep.add(cor7);
        possibleStep.add(cor8);
        System.out.println(possibleStep.size()+"размер возможных ходов - 1");

        for (int i = 0; i < possibleStep.size(); i++) {

            if (map.maps.get(possibleStep.get(i)) != null) {
                if (Rock.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                } else if (Tree.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                } else if (Predator.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                } else if (Herbivore.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                }
            }

            }
        System.out.println(possibleStep.size()+"размер возможных ходов - 2");
        for (int i = 0; i < possibleStep.size(); i++) {
            if (possibleStep.get(i).height > Simulation.XX-1 || possibleStep.get(i).width > Simulation.YY-1) {
                possibleStep.remove(possibleStep.get(i));
            }
        }
        System.out.println(possibleStep.size()+"размер возможных ходов - 3");
        for (int i = 0; i < possibleStep.size(); i++) {
            if (possibleStep.get(i).height > Simulation.XX-1 || possibleStep.get(i).width > Simulation.YY-1) {
                possibleStep.remove(possibleStep.get(i));
            }
        }
        System.out.println(possibleStep.size()+"размер возможных ходов - 4");
        for (int i = 0; i < possibleStep.size(); i++) {
            if (possibleStep.get(i).height < 0 || possibleStep.get(i).width < 0) {
                possibleStep.remove(possibleStep.get(i));
            }
        }
        System.out.println(possibleStep.size()+"размер возможных ходов - 5");
        for (int i = 0; i < possibleStep.size(); i++) {
            if (possibleStep.get(i).height < 0 || possibleStep.get(i).width < 0) {
                possibleStep.remove(possibleStep.get(i));
            }
        }


        System.out.println(possibleStep.size()+"размер возможных ходов - 6");

        for (int i = 0; i < possibleStep.size(); i++) {

            System.out.println("шаг "+possibleStep.get(i).width+" "+possibleStep.get(i).height+" "+ (i+1));

        }
        for (int i = 0; i < grassCor.size(); i++) {
            System.out.println("трава "+grassCor.get(i).width+" "+grassCor.get(i).height+" "+ (i+1));

        }

        return coordinates;
    }

    public Herbivore(Coordinates coordinates, int healsPoint) {
        super(coordinates, healsPoint);
    }


}