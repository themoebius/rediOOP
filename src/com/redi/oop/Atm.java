package com.redi.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Atm {

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));


    //Since every account holder needs to be a person,
    //method for checking first if the newly created AccountHolder exists in people Hashmap,

    public static boolean isPerson(HashMap<String, Date> mapToCheck, String nameToCheckFor) {
        boolean isInMap = true;
        for (Map.Entry<String, Date> entry : mapToCheck.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase(nameToCheckFor)) {
                return isInMap;
            }
        }
        return false;
    }

    //openAccount method to create new account with checks
    //if (future) customer already exists as a Person in people / account already exists in accounts

    public static Account openAccount() {
        final boolean[] isCustomer = {false};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your new banking experience- please enter your name to open an account");
        String name = scanner.nextLine();
        final String cleanName = name.toLowerCase().trim();
        final int[] thisAccountNo = new int[1];

        //check if inputName already exists in Hashmap for all accounts
        //if true, getting the Account number from the Hashmap...
        Main.accounts.forEach((key, value) -> {
            if (key.equalsIgnoreCase(cleanName)) {
                thisAccountNo[0] = value;
                isCustomer[0] = true;
            }
        });

        //if its an existing customer...:
        if (isCustomer[0]) {
            System.out.println("You already have an account");
            System.out.printf("Your accountNumber is: %d\n", thisAccountNo[0]);
            //if its a NEW customer (1st doing some basic String cleaning/ops
        } else {
            String[] customerName = cleanName.split("\\s+");

            //checking if future customer is a person(i.e. has an ID)-
            //only if future customer is in people-Hashmap, an account can be opened...
            boolean isPerson = isPerson(Main.people, customerName[0]);


            //!!! maybe trigger new Person creation if Holder of newly created account
            //!!! is NOT yet in 'people'

            if (isPerson) {
                System.out.printf("It's great to have you as a customer, %S\n", customerName[0]);

                //creating the new Customer Object
                Account newAccount = new Account(cleanName);

                //getting autocreated accountNumber
                int outputNumber = newAccount.getAccountNumber();

                //getting autocreated pin- pin gets randomly set during Obj. creation.
                int outputPin = newAccount.getPIN();

                //adding <Name, AcctNo> of newly created customer to accounts HashMap
                Main.accounts.put(cleanName, outputNumber);


                //adding newly created Acct Object to of newly created customer to accountList ArrayList
                Main.accountList.add(newAccount);

                System.out.printf("You're all set, %S\n", cleanName);
                System.out.printf("Your account Number: %d\n", outputNumber);
                System.out.printf("Your PIN: %d\n", outputPin);





                //calling Account.deposit() as part of initial account- setup to set initial balance..
                //handing newly created pin over- this only happens during acct creation- pin must be entered
                //manually during every further interaction...
                System.out.println("Please make your first deposit to finalize the process: please enter the amount you wish to deposit");
                double initialPayment = scanner.nextDouble();

                newAccount.deposit(outputPin, initialPayment);

                //if the acct- balance is > certain amount, an extended menu gets unlocked, and a line of credit can be set
                if (newAccount.getBalance() >= 2500) {
                    newAccount.advancedSetup();
                }
                return newAccount;
            }

            else{
                System.out.println("Since you can't show an ID, you are not able to open an account");
            }
        }

        return null;
    }



}
