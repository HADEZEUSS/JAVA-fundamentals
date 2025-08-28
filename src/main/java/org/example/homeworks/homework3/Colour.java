package org.example.homeworks.homework3;

public class Colour {
    String color;
    int x;
    int y;
    int z;

    public Colour(String color, int x, int y, int z) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return color + " (RGB: " + x + ", " + y + ", " + z + ")";
    }
}
