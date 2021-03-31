package com.redi.oop2;

public class Square extends Rectangle{

    double sideLength;


    public Square(final double sideLength) {
        super("Square",sideLength,sideLength);
        this.sideLength = sideLength;
    }

    }
