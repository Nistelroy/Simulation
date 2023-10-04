package ru.yandex.practicum.objects.mouvingObjects;

import org.junit.Test;
import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;
import ru.yandex.practicum.process.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Herbivore extends Creature {
    // eatGrass();
    List<Coordinates> grassCor = new ArrayList<>();
    public Coordinates move(Map map) {

        Action action = new Action();
        grassCor = action.findGrass(map);
        Coordinates nextGrass;


        int step = 0;
// nextGrass
        // possibleStep
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
        System.out.println(possibleStep.size()+"размер возможных ходов");

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
        System.out.println(possibleStep.size()+"размер возможных ходов");
        int[] nextsGrass = new int[possibleStep.size()];



        for (int i = 0; i < possibleStep.size(); i++) {
            System.out.println(possibleStep.size()+"размер возможных ходов внутри цикла");
            int summStep = 0;
            for (int j = 0; j < grassCor.size(); j++) {

                 summStep += (grassCor.get(j).height - possibleStep.get(i).height) + (grassCor.get(j).width - possibleStep.get(i).width);


            }
            System.out.println(summStep+" "+i);
            nextsGrass[i]=summStep;
        }
        /*
        for (int i = 0; i < nextsGrass.length; i++) {
            int sort = 0;
            if (sort < nextsGrass[i])
            {
                sort = nextsGrass[i];
                System.out.println(nextsGrass[i]+" sort "+i);
            }
            System.out.println(sort+"System.out.println(sort);");
        }


        int close = nearest(coordinates.height + coordinates.width, nextsGrass);
        System.out.println(close+"close");
        for (int i = 0; i < nextsGrass.length; i++) {
            if (close == nextsGrass[i]) {
                step = i;
                System.out.println(nextsGrass[i]+"close");
                break;
            }
        }*/
        nextGrass = grassCor.get(step);


      System.out.println(nextGrass.height +"---"+nextGrass.hashCode()+" Трава икс ");
         System.out.println(nextGrass.width +"---"+nextGrass.hashCode()+ " Трава игрик");
        System.out.println(coordinates.height +"---"+nextGrass.hashCode()+ " зебра икс ");
        System.out.println(coordinates.width +"---"+nextGrass.hashCode()+ " зебра игрик");


        int target = 0, k = 1;
        System.out.println(target+" target ");



        System.out.println(Sort.findKClosestElements(nextsGrass, k, target)+"+++++++++++");

        List<Integer> num = Sort.findKClosestElements(nextsGrass, k, target);
        System.out.println(num.get(0) + "GET O");
        for (int i = 0; i < nextsGrass.length; i++) {
            if (nextsGrass[i]==num.get(0)) {
                System.out.println(nextsGrass[i]+" nextsGrass "+ i);
                step = i;
                break;
            }

        }


/*


        if (nextGrass.height > coordinates.height) {
            System.out.println("зебра до шаг вверх "+hashCode() +"---"+ coordinates.height);
            coordinates.height += 1;

            System.out.println("зебра после шаг вверх "+hashCode() +"---"+ coordinates.height);
        } else if (nextGrass.height < coordinates.height) {
            System.out.println("зебра до шаг вниз "+hashCode() +"---"+ coordinates.height);
            coordinates.height -= 1;

               System.out.println("зебра после шаг вниз "+hashCode() +"---"+ coordinates.height);
        }

            if (nextGrass.width > coordinates.width) {
                System.out.println("зебра до шаг вперёд "+ hashCode() +"---"+ coordinates.width);
                coordinates.width += 1;
                System.out.println("зебра после шаг вперёд "+ hashCode() +"---"+ coordinates.width);


            }

            if (nextGrass.width < coordinates.width) {
                System.out.println("зебра до шаг назад "+hashCode() +"---"+ coordinates.width);
                coordinates.width -= 1;
                System.out.println("зебра после шаг назад "+hashCode() +"---"+ coordinates.width);


            }
*/
        return possibleStep.get(step);
    }


    public Herbivore(Coordinates coordinates, int healsPoint) {
        super(coordinates, healsPoint);
    }

    public void getHerbivoreMoveS(Map map) {
        for (int i = 1; i < Simulation.XX + 1; i++) {
            for (int j = 1; j < Simulation.YY + 1; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) != null) {
                    if (Grass.class.equals(map.maps.get(cor).getClass())) {




                    }
                }
            }
        }
    }
    int nearest(int n, int...args)
    {
        int nearest = 0;
        long value = 2*Integer.MAX_VALUE;
        for(int arg : args)
            if (value > Math.abs(n - arg)){
                value = Math.abs(n-arg);
                nearest = arg;}
        return nearest;
    }
}