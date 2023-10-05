package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.List;

public class Herbivore extends Creature {

    public Coordinates move(Map map) {

        List<Coordinates> grassCor;
        Action action = new Action();
        grassCor = action.findGrass(map);
        List<Coordinates> possibleStep = getPossibleStep(coordinates.height,coordinates.width,map);

        for (int i = 0; i < possibleStep.size(); i++) {

            System.out.println("шаг "+possibleStep.get(i).height+" "+possibleStep.get(i).width+" "+ (i+1));

        }
        for (int i = 0; i < grassCor.size(); i++) {
            int r = -1;
            System.out.println("трава "+grassCor.get(i).height+" "+grassCor.get(i).width+" "+ (i+1));
            int closeXX = Math. abs(coordinates.height - grassCor.get(i).height);

            int closeYY = Math. abs(coordinates.width - grassCor.get(i).width);

            System.out.println(closeXX+closeYY);
        }

        return coordinates;
    }

    public Herbivore(Coordinates coordinates, int healsPoint) {
        super(coordinates, healsPoint);
    }


}