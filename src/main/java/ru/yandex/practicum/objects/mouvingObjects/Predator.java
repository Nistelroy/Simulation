package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.process.Coordinates;

public class Predator extends Creature{

   public void move(){
      // System.out.println("хищник шаг");
       coordinates = new Coordinates(coordinates.height +1,coordinates.width +1 );
   }
   // punch();

    public Predator(Coordinates coordinates, int healsPoint) {
        super(coordinates, healsPoint);
    }
}
