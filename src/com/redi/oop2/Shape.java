package com.redi.oop2;

public class Shape {

    private final String type;
    private final double area;
    private final double perimeter;

    public Shape(final String type, final double area, final double perimeter) {
        this.type = type;
        this.area = area;
        this.perimeter = perimeter;
    }

    public void print() {
        System.out.println("Name: " + type);
        System.out.println("Area: " + area);
        System.out.println("Perimeter: " + perimeter);
    }

    public void printArea(){
        System.out.println(this.area);
    }
}
