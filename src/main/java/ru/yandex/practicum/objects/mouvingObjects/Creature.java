package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.notMovingObjects.Rock;
import ru.yandex.practicum.objects.notMovingObjects.Tree;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Emtity {


    public Creature(Coordinates coordinates) {
        super(coordinates);

    }
    public List<Coordinates> getPossibleStepHerb(int height, int width, Map map) {

        List<Coordinates> possibleStep = getCoordinates(height, width);

        for (int i = possibleStep.size()-1; i > -1; i--) {
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
        if (coordinates.height == 0 || coordinates.height == Simulation.XX - 1 ||coordinates.width == 0 || coordinates.width == Simulation.YY - 1 ) {

            for (int j = 0; j < Simulation.XX/3; j++) {
                for (int i = 0; i < possibleStep.size(); i++) {
                    if (possibleStep.get(i).height > Simulation.XX - 1 || possibleStep.get(i).width > Simulation.YY - 1) {
                        possibleStep.remove(possibleStep.get(i));
                    }
                }
                for (int i = 0; i < possibleStep.size(); i++) {
                    if (possibleStep.get(i).height < 0 || possibleStep.get(i).width < 0) {
                        possibleStep.remove(possibleStep.get(i));
                    }
                }
            }
        }
     return possibleStep;
    }

    public List<Coordinates> getListPossibleStepPredator(int height, int width, Map map) {

        List<Coordinates> possibleStep = getCoordinates(height, width);


        for (int i = possibleStep.size()-1; i > -1; i--) {
            if (map.maps.get(possibleStep.get(i)) != null) {
                if (Rock.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                } else if (Tree.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                } else if (Predator.class.equals(map.maps.get(possibleStep.get(i)).getClass())) {
                    possibleStep.remove(possibleStep.get(i));
                }
            }
        }
        if (coordinates.height == 0 || coordinates.height == Simulation.XX - 1 ||coordinates.width == 0 || coordinates.width == Simulation.YY - 1 ) {

            for (int j = 0; j < Simulation.XX/3; j++) {
                for (int i = 0; i < possibleStep.size(); i++) {
                    if (possibleStep.get(i).height > Simulation.XX - 1 || possibleStep.get(i).width > Simulation.YY - 1) {
                        possibleStep.remove(possibleStep.get(i));
                    }
                }
                for (int i = 0; i < possibleStep.size(); i++) {
                    if (possibleStep.get(i).height < 0 || possibleStep.get(i).width < 0) {
                        possibleStep.remove(possibleStep.get(i));
                    }
                }
            }
        }
        if (possibleStep.isEmpty()) {
            possibleStep.add(0, new Coordinates(coordinates.height,coordinates.width));
        }
        return possibleStep;
    }

    private static List<Coordinates> getCoordinates(int height, int width) {
        Coordinates step1 = new Coordinates(height +1, width -1);
        Coordinates step2 = new Coordinates(height +1, width);
        Coordinates step3 = new Coordinates(height +1, width +1);
        Coordinates step4 = new Coordinates(height, width -1);
        Coordinates step5 = new Coordinates(height, width +1);
        Coordinates step6 = new Coordinates(height -1, width -1);
        Coordinates step7 = new Coordinates(height -1, width);
        Coordinates step8 = new Coordinates(height -1, width +1);

        List<Coordinates> possibleStep = new ArrayList<>();
        possibleStep.add(step1);
        possibleStep.add(step2);
        possibleStep.add(step3);
        possibleStep.add(step4);
        possibleStep.add(step5);
        possibleStep.add(step6);
        possibleStep.add(step7);
        possibleStep.add(step8);

        return possibleStep;
    }
}
