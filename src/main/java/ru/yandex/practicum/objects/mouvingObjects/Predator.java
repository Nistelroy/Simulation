package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.List;

public class Predator extends Creature{

   public Coordinates move(Map map){
       Action action = new Action();
       List<Coordinates> possibleStep = getPossibleStepPred(coordinates.height,coordinates.width,map);
       List<Coordinates> herbivoreCor = action.findHerbivoreCor(map);


       int closeMinStepForHerb = Simulation.XX*5;
       int indexGrassInHerbCor = -1;
       for (int i = 0; i < herbivoreCor.size(); i++) {


           int closeXX = Math. abs(coordinates.height - herbivoreCor.get(i).height);
           int closeYY = Math. abs(coordinates.width - herbivoreCor.get(i).width);
           if (closeXX+closeYY < closeMinStepForHerb)
           {
               closeMinStepForHerb = closeXX+closeYY;
               indexGrassInHerbCor = i;

           }

       }
       int closeMinStepForGrass1 = Simulation.XX*5;
       int indexGrassInGrassCor1 = -1;
       for (int i = 0; i < possibleStep.size(); i++) {
           int closeXX = Math. abs(possibleStep.get(i).height - herbivoreCor.get(indexGrassInHerbCor).height);
           int closeYY = Math. abs(possibleStep.get(i).width - herbivoreCor.get(indexGrassInHerbCor).width);
           if (closeXX+closeYY < closeMinStepForGrass1)
           {
               closeMinStepForGrass1 = closeXX+closeYY;
               indexGrassInGrassCor1 = i;
           }
       }


       coordinates.height = possibleStep.get(indexGrassInGrassCor1).height;
       coordinates.width = possibleStep.get(indexGrassInGrassCor1).width;




       return coordinates;
   }


    public Predator(Coordinates coordinates, int healsPoint) {
        super(coordinates, healsPoint);
    }
}
