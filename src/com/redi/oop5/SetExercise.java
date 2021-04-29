package com.redi.oop5;

import java.util.*;

public class SetExercise {
    static Scanner scanner = new Scanner(System.in);

    //Helper Methods

    //helper-method to generate int[] with random positive numbers
    public static int[] createRandArray(int maxNumber, int arraySize){
        Random rand = new Random();
        int[] outputArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            outputArray[i] = rand.nextInt(maxNumber);
        }
        return outputArray;
    }


    //Helper-method to generate Hashsets of random ints of chosen size.
    public static HashSet<Integer> createRandomHash(int size, int maxNumber){
        HashSet<Integer> workingSet = new HashSet<>();
        Random rand = new Random();

        while(workingSet.size() < size){
            workingSet.add(rand.nextInt(maxNumber));
        }
        System.out.println(workingSet);
        return workingSet;
    }



    /*
    Exercise 1
    Write a method that takes an array with integers and return an array of unique values of the array
    (ordered)
    */
    public static int[] returnUnique(int[] inputArray){
        HashSet<Integer> sortSet = new HashSet<>();

        for(int i : inputArray){
            sortSet.add(i);
        }

        Object[] outputArray = sortSet.stream().toArray();
        int[] returnArray = new int[outputArray.length];

        for(int i=0;i< outputArray.length;i++) {
            returnArray[i] = (int) outputArray[i];
        }
        return returnArray;

    }


    /*
    Exercise 2
    Write a method that takes a String and returns all unique characters of this String
    (not ordered)
    */
    public static char[] uniqueCharsInString(String inputString){
        char[] StringToArray = inputString.toCharArray();
        HashSet<Character> sortSet = new HashSet<>();

        for(char c : StringToArray){
            sortSet.add(c);
        }

        Object[] outputArray = sortSet.stream().toArray();
        char[] returnArray = new char[outputArray.length];

        for(int i=0;i< outputArray.length;i++) {
            returnArray[i] = (char) outputArray[i];
        }
        return returnArray;
    }


    /*
    Exercise 3
    Write a static method intersection that will return an intersection of two sets given by parameters.
    Note - sets given by parameters may not be modified.
    */
    public static Set<Integer> intersection(HashSet<Integer> compareSet1, HashSet<Integer> compareSet2){
        Set<Integer> diffSet = new HashSet<>();
        /*
        //converting inputHashSets to List for access by index
        List<Integer> hashSetToList1 = new ArrayList<>(compareSet1);
        List<Integer> hashSetToList2 = new ArrayList<>(compareSet2);

        for(Integer i : hashSetToList1){
            for(int ii = 0; ii < hashSetToList2.size();){
                if(hashSetToList2.get(ii) == i){
                    diffSet.add(hashSetToList2.get(ii));
                    ii++;
                    continue;
                }
                else{
                    ii++;
                    continue;
                }
            }
        }
        */


        //Way shorter way using java Object methods:
        for (Integer i : compareSet1) {
            if(compareSet2.contains(i)) {
                diffSet.add(i);
            }
        }
        return diffSet;
    }


    /*
    Exercise 4
    Write a static method union that will return an union of two sets given by parameters.
    Note - sets given by parameters may not be modified.
    Don't know if union allows for multiple occurrences of the same value...
    */
    public static TreeSet<Integer> unionSet(HashSet<Integer> compareSet1, HashSet<Integer> compareSet2){
        /*
        ArrayList<Integer> unionListMultiple = new ArrayList<>();
        unionListMultiple.addAll(compareSet1);
        unionListMultiple.addAll(compareSet2);
        return unionListMultiple;
        */

        TreeSet<Integer> unionSetSingle = new TreeSet<>();
        unionSetSingle.addAll(compareSet1);
        unionSetSingle.addAll(compareSet2);

        return unionSetSingle;
    }


    /*
    Exercise 5
    Write a static method difference that will return a difference between two sets given by parameters.
    Note - sets given by parameters may not be modified.
    */
    public static HashSet<Integer> difference(HashSet<Integer> compareSet1, HashSet<Integer> compareSet2){
        HashSet<Integer> diffSet = new HashSet<>();
        HashSet<Integer> symmetricDiffSet = new HashSet<>();
        System.out.println("Please type '1' if you want to get the unique values from the first input-set\n" +
                "type '2' if you want to get the unique values from the second input-set\n" +
                "type '3' if you want to get the symmetric difference of both sets\n" +
                "any other input quits the method");

        int AorBorC = scanner.nextInt();

        switch(AorBorC){
            case 1:
                //gives the values that are in compareSet1 but NOT in compareSet2
                diffSet.addAll(compareSet1);
                diffSet.removeAll(compareSet2);
                return diffSet;
            case 2:
                //gives the values that are in compareSet2 but NOT in compareSet1
                diffSet.addAll(compareSet2);
                diffSet.removeAll(compareSet1);
                return diffSet;
            case 3 :
                //gives the values that are in compareSet1 AND compareSet2 but NOT in both
                diffSet.addAll(compareSet1);
                diffSet.removeAll(compareSet2);
                symmetricDiffSet.addAll(diffSet);
                diffSet.clear();
                diffSet.addAll(compareSet2);
                diffSet.removeAll(compareSet1);
                symmetricDiffSet.addAll(diffSet);
                return symmetricDiffSet;
            default :
                System.out.println("Something went wrong");
                break;
        }
        diffSet.clear();
        return diffSet;
    }

}








