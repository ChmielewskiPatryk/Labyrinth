package com.company;

import java.util.Map;
import java.util.Objects;

public class MapPosition {

    private int x;
    private int y;



    public MapPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] returnArr(){
        return new int[]{this.getX(), this.getY()};
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapPosition that = (MapPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "MapPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
