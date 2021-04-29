package com.redi.oop5;

import static com.redi.oop5.SetExercise.*;


public class Main {

    public static void main(String[] args) {

        //exercise1
        int[] testOut = returnUnique(createRandArray(5,10));
        for(int i : testOut){
            System.out.println(i);
        }

        //exercise2
        char[] uniqueChars = uniqueCharsInString("TESTOMAT");
        for(char c : uniqueChars){
            System.out.println(c);
        }

        //exercise3
        //System.out.println(intersection(createRandomHash(5, 9), createRandomHash(5, 9)));

        //exercise4
        System.out.println(difference(createRandomHash(5, 9), createRandomHash(5, 9)));
    }
}


