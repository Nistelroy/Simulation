package ru.yandex.practicum.objects;

import ru.yandex.practicum.process.Coordinates;

public abstract class Emtity {
    public Coordinates coordinates;
    public Emtity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


}
