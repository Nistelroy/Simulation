package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature extends Emtity {
    int healsPoint;

    public Creature(Coordinates coordinates, int healsPoint) {
        super(coordinates);
        this.healsPoint = healsPoint;
    }
    public List<Coordinates> getPossibleStep(int height, int width, Map map) {

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
        if (coordinates.height == 0 || coordinates.height == 9 ||coordinates.width == 0 || coordinates.width == 9 ) {

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

    private static List<Coordinates> getCoordinates(int height, int width) {
        Coordinates cor1 = new Coordinates(height +1, width -1);
        Coordinates cor2 = new Coordinates(height +1, width);
        Coordinates cor3 = new Coordinates(height +1, width +1);
        Coordinates cor4 = new Coordinates(height, width -1);
        Coordinates cor5 = new Coordinates(height, width +1);
        Coordinates cor6 = new Coordinates(height -1, width -1);
        Coordinates cor7 = new Coordinates(height -1, width);
        Coordinates cor8 = new Coordinates(height -1, width +1);

        List<Coordinates> possibleStep = new ArrayList<>();
        possibleStep.add(cor1);
        possibleStep.add(cor2);
        possibleStep.add(cor3);
        possibleStep.add(cor4);
        possibleStep.add(cor5);
        possibleStep.add(cor6);
        possibleStep.add(cor7);
        possibleStep.add(cor8);
        return possibleStep;
    }
}
