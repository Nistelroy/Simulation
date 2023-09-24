package ru.yandex.practicum.process;

import java.util.Objects;

public class Coordinates {
    public final Integer HEIGHT;
    public final Integer WIDTH;

    public Coordinates(Integer height, Integer width) {
        this.HEIGHT = height;
        this.WIDTH = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(HEIGHT, that.HEIGHT) && Objects.equals(WIDTH, that.WIDTH);
    }

    @Override
    public int hashCode() {
        return Objects.hash(HEIGHT, WIDTH);
    }
}
