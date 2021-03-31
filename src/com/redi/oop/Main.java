package com.redi.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    //HashMap storing all <Name, AccountNo> for ACCOUNT
    static HashMap<String, Integer> accounts= new HashMap<>();

    //HashMap storing all <Name, Birthdate> for PERSON
    static HashMap<String, Date> people = new HashMap<>();

    //ArrayList storing all Account Objects
    static ArrayList<Account> accountList= new ArrayList<>();


    public static boolean accountCheck(int accountNo){
        boolean returnBool = false;
        for (Map.Entry<String, Integer> entry : Main.accounts.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (value == (Integer) accountNo) {
                returnBool = true;
            }
        }
        return returnBool;
    }

    //method to create Person-Object containing name, dob, acctNo(default:0);
    public static Person createPerson() {
        SimpleDateFormat format = new SimpleDateFormat("MM.dd.yyyy");


        System.out.println("Welcome to your creation- if you type in your name, I'll make you a customer");
        String name = scanner.nextLine();
        System.out.printf("You have been created, %S. Now tell me when you were born (- ie: 10.20.2000)\n", name);
        String inputDate = scanner.nextLine();


        Date dob = new Date();
        //using Dateformat NEEDS a try/catch or a throws...
        try {
            dob = format.parse(inputDate);
        }
        catch (ParseException e) {
            System.out.println("Oops- something went wrong with the date");
        }

        //crating new Person Obj
        Person newPerson = new Person(name, dob);
        //putting newPerson data(Name, dob) in people-HashMap
        Main.people.put(newPerson.name, dob);

        return newPerson;
    }




    public static void main(String[] args) {

        Person test1 =createPerson();
        Account p1acct1 = Atm.openAccount();


        Person test2 =createPerson();
        Account p1acct2 = Atm.openAccount();

        p1acct1.transaction(119., 2);

        p1acct2.transaction(119., 2);


    }
}
