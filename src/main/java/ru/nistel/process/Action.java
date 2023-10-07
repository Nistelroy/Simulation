package ru.nistel.process;

import ru.nistel.Simulation;
import ru.nistel.objects.mouvingObjects.Herbivore;
import ru.nistel.objects.mouvingObjects.Predator;
import ru.nistel.objects.notMovingObjects.Grass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Action {
Random random = new Random();
    List<Coordinates> listGrassesCoordinate = new ArrayList<>();
    List<Coordinates> listHerbivoresCoordinate = new ArrayList<>();
    int her = MapRender.movingObject;
    int kill = 0;

    public List<Coordinates> findAllGrasses(Map map) {
        for (int i = 0; i < Simulation.XX; i++) {
            for (int j = 0; j < Simulation.YY; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.maps.get(coordinates) != null) {
                    if (Grass.class.equals(map.maps.get(coordinates).getClass())) {
                        listGrassesCoordinate.add(coordinates);
                    }
                }
            }
        }
        return listGrassesCoordinate;
    }

    public List<Coordinates> findHerbivoresCoordinates(Map map) {
        for (int i = 0; i < Simulation.XX; i++) {
            for (int j = 0; j < Simulation.YY; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.maps.get(coordinates) != null) {
                    if (Herbivore.class.equals(map.maps.get(coordinates).getClass())) {
                        listHerbivoresCoordinate.add(coordinates);
                    }
                }
            }
        }
        return listHerbivoresCoordinate;
    }

    public void nextTurn(Map map) {

        List<Coordinates> listPredatorCoordinates = new ArrayList<>();
        List<Coordinates> listHerbivoreCoordinates = new ArrayList<>();
        List<Coordinates> listGrassCoordinates = new ArrayList<>();
        for (int i = 0; i < Simulation.XX; i++) {
            for (int j = 0; j < Simulation.YY; j++) {
                Coordinates coordinates = new Coordinates(i, j);
                if (map.maps.get(coordinates) != null) {
                    if (Grass.class.equals(map.maps.get(coordinates).getClass())) {
                        listGrassCoordinates.add(coordinates);
                    } else if (Predator.class.equals(map.maps.get(coordinates).getClass())) {
                        listPredatorCoordinates.add(coordinates);
                    } else if (Herbivore.class.equals(map.maps.get(coordinates).getClass())) {
                        listHerbivoreCoordinates.add(coordinates);
                    }
                }
            }
        }

        if (her > listHerbivoreCoordinates.size()){
            kill++;
            System.out.print("Произошло '"+ kill +"'-e убийство!");
            her = listHerbivoreCoordinates.size();
        }else her= listHerbivoreCoordinates.size();
        if (listGrassCoordinates.size() < (MapRender.notMovingObject/3) ) {
            setMoreGrass(map);

        }
        if (listHerbivoreCoordinates.size() == 1) {
            setMoreHerbivore(map);

        }
        if (listPredatorCoordinates.isEmpty()) {
            setMorePredator(map);


        }
        for (int i = 0; i < listHerbivoreCoordinates.size(); i++) {
            Herbivore herbivore = (Herbivore) map.maps.get(listHerbivoreCoordinates.get(i));
            Coordinates coordinates = herbivore.move(map);
            map.maps.put(coordinates, herbivore);
            map.maps.remove(listHerbivoreCoordinates.get(i));
        }
        for (int i = 0; i < listPredatorCoordinates.size(); i++) {
            Predator predator = (Predator) map.maps.get(listPredatorCoordinates.get(i));
            Coordinates coordinates = predator.move(map);
            map.maps.put(coordinates, predator);
            map.maps.remove(listPredatorCoordinates.get(i));
        }
    }

    private void setMorePredator(Map map) {
        int x = 0;
        while (x < (MapRender.movingObject)) {
            Coordinates coordinates = new Coordinates(random.nextInt(Simulation.XX), random.nextInt(Simulation.YY));
            if (map.maps.get(coordinates) == null) {
                Herbivore emtity = new Herbivore(coordinates);
                map.setEmtity(coordinates, emtity);
                x++;
            }
        }

    }

    private void setMoreHerbivore(Map map) {
        int x = 0;
        while (x < MapRender.movingObject) {
        Coordinates coordinates = new Coordinates(random.nextInt(Simulation.XX), random.nextInt(Simulation.YY));
        if (map.maps.get(coordinates) == null) {
            Herbivore emtity = new Herbivore(coordinates);
            map.setEmtity(coordinates, emtity);
            x++;
        }
        }
    }

    private void setMoreGrass(Map map) {
        int x = 0;
        while (x < MapRender.notMovingObject) {
        Coordinates coordinates = new Coordinates(random.nextInt(Simulation.XX), random.nextInt(Simulation.YY));
        if (map.maps.get(coordinates) == null) {
            Grass emtity = new Grass(coordinates);
            map.setEmtity(coordinates, emtity);
            x++;
        }
        }

    }
}

