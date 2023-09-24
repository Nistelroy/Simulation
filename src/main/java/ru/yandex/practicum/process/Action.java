package ru.yandex.practicum.process;

import ru.yandex.practicum.Simulation;
import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.objects.mouvingObjects.*;
import ru.yandex.practicum.objects.mouvingObjects.Herbivore;
import ru.yandex.practicum.objects.mouvingObjects.Prefator;
import ru.yandex.practicum.objects.notMouvingObjects.Grass;
import ru.yandex.practicum.objects.notMouvingObjects.Rock;
import ru.yandex.practicum.objects.notMouvingObjects.Tree;

public class Action {
    final int XX = Simulation.XX;
    final int YY = Simulation.YY;
    public void render(Map map) {
        for (int i = 1; i < XX+1; i++) {
            System.out.println("");
            for (int j = 1; j < YY+1; j++) {
                Coordinates cor = new Coordinates(i,j);
if (map.maps.get(cor) == null) {
    System.out.print("☘☘");
} else {
    System.out.print(getEmptySprite(map.maps.get(cor)));
   // System.out.print(map.getEnemy(cor));
}

}


            }

        }

    private String getEmptySprite(Emtity emtity) {
        if (emtity.getClass().equals(Grass.class)){
        return " \uD83C\uDF40 ";
        } else if (emtity.getClass().equals(Rock.class)) {
            return " \uD83C\uDF33 ";
        }else if (emtity.getClass().equals(Tree.class)) {
            return " \uD83C\uDF32 ";
        }else if (emtity.getClass().equals(Herbivore.class)) {
            return " \uD83E\uDD93 ";
        }else if (emtity.getClass().equals(Prefator.class)) {
            return " \uD83D\uDE3E ";
        }else { return null;}
    }

    private String getSpringForEmptySquare(Coordinates coordinates) {

        return " ";
    }
}
