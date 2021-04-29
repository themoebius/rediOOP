package com.redi.oop5;

import static com.redi.oop5.SetExercise.*;

public class Main {

    public static void main(String[] args) {

        //exercise1
        System.out.println("exercise 1");
        int[] testOut = returnUnique(createRandArray(5,10));
        for(int i : testOut){
            System.out.println(i);
        }
        System.out.println("-----------");

        //exercise2
        System.out.println("exercise 2");
        char[] uniqueChars = uniqueCharsInString("TESTOMAT");
        for(char c : uniqueChars){
            System.out.println(c);
        }
        System.out.println("-----------");

        //exercise3
        System.out.println("exercise 3");
        System.out.println(intersection(createRandomHash(5, 9), createRandomHash(5, 9)));
        System.out.println("-----------");

        //exercise4
        System.out.println("exercise 4");
        System.out.println(difference(createRandomHash(5, 9), createRandomHash(5, 9)));
        System.out.println("-----------");
    }
}


