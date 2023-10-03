package ru.yandex.practicum.objects.mouvingObjects;

import org.junit.Test;
import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.process.Action;
import ru.yandex.practicum.process.Coordinates;
import ru.yandex.practicum.process.Map;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Herbivore extends Creature {
    // eatGrass();
    List<Coordinates> grassCor = new ArrayList<>();
    public Coordinates move(Map map) {
        Action action = new Action();
        grassCor = action.findGrass(map);
        Coordinates nextGrass;

        int[] nextsGrass = new int[grassCor.size()];
        int step = 0;

        for (int i = 0; i < grassCor.size(); i++) {


            nextsGrass[i] = ((grassCor.get(i).height - super.coordinates.height) + grassCor.get(i).width) - super.coordinates.width;


        }

        int close = nearest(super.coordinates.height + super.coordinates.width, nextsGrass);
        for (int i = 0; i < nextsGrass.length; i++) {
            if (close == nextsGrass[i]) {
                step = i;
                break;
            }
        }
        nextGrass = grassCor.get(step);

        System.out.println(super.coordinates.width +"---"+super.hashCode()+ "зебра игрик");
        System.out.println(super.coordinates.width +"---"+super.hashCode()+ "зебра икс");
      System.out.println(nextGrass.height +"---"+nextGrass.hashCode()+"Трава икс ");
         System.out.println(nextGrass.width +"---"+nextGrass.hashCode()+ "Трава игрик");



        if (nextGrass.height > super.coordinates.height) {
            System.out.println("зебра до шаг вверх"+super.hashCode() +"---"+ super.coordinates.height);
            super.coordinates.height += 1;

            System.out.println("зебра после шаг вверх"+super.hashCode() +"---"+ super.coordinates.height);
        } else if (nextGrass.height < super.coordinates.height) {
            System.out.println("зебра до шаг вниз"+super.hashCode() +"---"+ super.coordinates.height);
            super.coordinates.height -= 1;

               System.out.println("зебра после шаг вниз"+super.hashCode() +"---"+ super.coordinates.height);
        }

            if (nextGrass.width > super.coordinates.width) {
                System.out.println("зебра до шаг вперёд"+ super.hashCode() +"---"+ super.coordinates.width);
                super.coordinates.width += 1;
                System.out.println("зебра после шаг вперёд"+ super.hashCode() +"---"+ super.coordinates.width);


            }

            if (nextGrass.width < super.coordinates.width) {
                System.out.println("зебра до шаг назад"+super.hashCode() +"---"+ super.coordinates.width);
                super.coordinates.width -= 1;
                System.out.println("зебра после шаг назад"+super.hashCode() +"---"+ super.coordinates.width);


            }

        return super.coordinates;
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