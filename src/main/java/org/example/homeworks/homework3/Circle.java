package org.example.homeworks.homework3;

public class Circle {
    Double radius;
    Colour color;

    public Circle(){}
    public Circle(Double radius, Colour color) {
        this.radius = radius;
        this.color = color;
    }

    public Double getRadius() {
        return radius;
    }
    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Colour getColor() {
        return color;
    }
    public void setColor(Colour color) {
        this.color = color;
    }

    public String createdCircle() {
        return "created circle with radius " + getRadius() + ", color " + getColor();
    }

}
