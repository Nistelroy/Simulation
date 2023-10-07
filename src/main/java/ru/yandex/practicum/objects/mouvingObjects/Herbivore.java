package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.List;

public class Herbivore extends Creature {
    
    public Herbivore(Coordinates coordinates) {
        super(coordinates);
    }
    
    public Coordinates move(Map map) {
        Action action = new Action();
        List<Coordinates> listGrassesCoordinates = action.findAllGrasses(map);
        List<Coordinates> possibleStep = getPossibleStepHerb(coordinates.height,coordinates.width,map);
        
        int indexBestMove = getIndexGrassInGrassCoordinates(listGrassesCoordinates, possibleStep);

        if (!possibleStep.isEmpty()) {
            coordinates.height = possibleStep.get(indexBestMove).height;
            coordinates.width = possibleStep.get(indexBestMove).width;

        }
      return coordinates;
    }

    private int getIndexGrassInGrassCoordinates(List<Coordinates> grassCor, List<Coordinates> possibleStep) {
        int closeMinStepForGrass = Simulation.XX*5;
        int indexGrassInGrassCor = -1;
        for (int i = 0; i < grassCor.size(); i++) {


            int closeXX = Math. abs(coordinates.height - grassCor.get(i).height);
            int closeYY = Math. abs(coordinates.width - grassCor.get(i).width);
            if (closeXX+closeYY < closeMinStepForGrass)
            {
                closeMinStepForGrass = closeXX+closeYY;
                indexGrassInGrassCor = i;

            }

        }
        int closeMinStepForGrass1 = Simulation.XX*5;
        int indexGrassInGrassCor1 = -1;
        for (int i = 0; i < possibleStep.size(); i++) {
            int closeXX = Math. abs(possibleStep.get(i).height - grassCor.get(indexGrassInGrassCor).height);
            int closeYY = Math. abs(possibleStep.get(i).width - grassCor.get(indexGrassInGrassCor).width);
            if (closeXX+closeYY < closeMinStepForGrass1)
            {
                closeMinStepForGrass1 = closeXX+closeYY;
                indexGrassInGrassCor1 = i;
            }
        }
        return indexGrassInGrassCor1;
    }


}