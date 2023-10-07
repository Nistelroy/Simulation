package ru.nistel.objects;

import ru.nistel.process.Coordinates;

public abstract class Emtity {
    public Coordinates coordinates;
    public Emtity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}
