package com.redi.oop2;

public class TheDog extends Canine{
    private String color;
    private boolean motivatedByFood;
    private double age;


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("I'm %.2f years young.\n and my fur is %S\n", age, color);

        if(motivatedByFood){
            System.out.printf("And I really dig food");
        }
        else{
            System.out.println("Eating is not my priority");
        }
    }



    TheDog(String name, String color, boolean motivatedByFood, double age){
        super(name);
        this.name = name;
        this.motivatedByFood = motivatedByFood;
        this.age = age;
        this.color = color;
    }




}
