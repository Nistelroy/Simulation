package ru.yandex.practicum.process;

import java.util.Objects;

public class Coordinates {
    public int height;
    public int width;

    public Coordinates(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(height, that.height) && Objects.equals(width, that.width);
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width);
    }
}
