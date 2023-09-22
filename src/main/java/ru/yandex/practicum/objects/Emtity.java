package ru.yandex.practicum.objects;

import ru.yandex.practicum.process.Coordinates;

public abstract class Emtity {
    private Coordinates coordinates;
    public Emtity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public Coordinates getCoordinates() {
        return coordinates;
    }
}
