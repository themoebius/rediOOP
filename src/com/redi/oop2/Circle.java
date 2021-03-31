package com.redi.oop2;

public class Circle extends Shape {

    private final double radius;

    public Circle(final double radius) {
        super("CIRCLE", Math.PI * radius * radius, 2 * Math.PI * radius);
        this.radius = radius;
    }

    @Override
    public void print() {
        System.out.println("Radius: " + radius);
    }
}