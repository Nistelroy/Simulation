package ru.yandex.practicum.objects.mouvingObjects;

import ru.yandex.practicum.objects.Emtity;
import ru.yandex.practicum.process.Coordinates;

public abstract class Creature extends Emtity {
    //move();
    int healsPoint;

    public Creature(Coordinates coordinates, int healsPoint) {
        super(coordinates);
        this.healsPoint = healsPoint;
    }
}
