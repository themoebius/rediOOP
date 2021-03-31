package com.redi.oop2;

public class Rectangle extends Shape {

    private final double length;
    private final double breadth;

    public Rectangle(final double length, final double breadth) {
        this("Rectangle", length, breadth);

    }

    public Rectangle(final String type,final double length, final double breadth) {
        super(type, length * breadth, 2 * (length + breadth));
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
    }
}