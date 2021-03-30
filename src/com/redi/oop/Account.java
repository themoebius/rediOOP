package com.redi.oop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Account {

    static Scanner scanner = new Scanner(System.in);
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Random rand = new Random();
    //try- counter for pin- enties made...
    int tryCounter = 2;

    //static int totalaccount- Counter to set new account number automatically.
    private static int totalAccounts = 0;
    private int accountNumber;
    private String accountHolder;
    private double balance;

    //overdraft limit for accounts with balance > certain amount.. (2500)
    private int overdraft;
    private boolean canOverdraft = false;

    //auto-creating random 4digit pin for account
    private final int pin = rand.nextInt((9999 - 100) + 1) + 10;


    /*
    //Hashmap to store account- transactions -replaced by Arraylist...
    HashMap<String, Double> transactions = new HashMap<>();
*/

    //ArrayList<int[3]> to store account- transactions
    //ele1: sentOrReceived:  0.0= received, 1.0=sent
    //ele2: amount
    //ele3: senderOrReceiver: sender | receiver AcctNo)
    ArrayList<double[]> transactionHistory = new ArrayList<double[]>();


    //constructors
    Account(){
        this.accountNumber = ++totalAccounts;
    }

    Account(String name){
        this.accountNumber = ++totalAccounts;
        this.accountHolder = name;
    }


    //getters
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getPIN() {
        return pin;
    }

    public double getBalance(){
        return balance;
    }

    //setters

    public void receiveFunds(double amount){
        this.balance += amount;
    }

    //balance check method to verify if withdraw sum does not
    //bush account balance <0 (except if overdraft is unlocked...)
    public boolean balanceCheck(double toDeduct){
        double maxAmount;
        maxAmount = canOverdraft ?  balance + overdraft : balance;
        return maxAmount - toDeduct >= 0;
    }

    //deposit method with pin-check
    //!!! maybe add state to enable multiple deposits per method-call...
    public void deposit(int pin, double toDeposit){
        if(this.pin == pin){
            balance+=toDeposit;
            System.out.printf("Your new balance is: %.2f\n",balance);
        }
        else{
            System.out.println("Wrong pin.");
        }
        System.out.println("Thank you.");
    }

    //withdraw method with pin-check
    public void withdraw(int pin, double toWithdraw){
        if(this.pin == pin){
            balance-=toWithdraw;
            System.out.printf("Your new balance is: %.2f\n",balance);
        }
        else{
            System.out.println("Wrong pin.");
        }
        System.out.println("Thank you.");
    }

    //method to unlock/ set overdraft - only accessible if balance > certain amount (here: 2500)
    public void advancedSetup(){
        System.out.println(balance >= 2000 ? "Welcome to your extended account settings\n" : "We are sorry to inform you that you do not qualify to access this menu\n");
        if(balance >= 2500 || canOverdraft){
            System.out.println("You can set a line of credit here:");
            System.out.println("please type your new overdraft limit (max. 550) or type '0' to don't use the feature\n");
            int newOverdraft = scanner.nextInt();
            if(newOverdraft >0 && newOverdraft <=500){
                canOverdraft = true;
                overdraft = newOverdraft;
                System.out.println("Your new settings have been applied:\nYour overdraft-limit is set to " + overdraft);
            }
            else{
                System.out.println("Your settings stay unchanged");
            }
        }
    }


    //transaction method to transfer money to different account
    //!!! continue working here to really add money to receiver account if account exists !!!
    public void transaction(Double amount, int receiverAccountNo){
        System.out.println("Please enter pin to proceed");
        Scanner scanner = new Scanner(System.in);
        int inputPin = scanner.nextInt();
        int tryAgain = 1;

        final boolean[] receiverHasAccount = new boolean[1];

        //check if AcctNo already exists in Hashmap for all accounts
        //if true, setting receiverhasAccount[0] to true...
        Main.accounts.forEach((key, value) -> {
            if (value == receiverAccountNo) {
               receiverHasAccount[0] = true;
            }
        });

        boolean newTransactions = false;
        boolean isPin = this.pin == inputPin;
        double[] transaction;
        double[] receiverTransaction;

        if(balanceCheck(amount) & isPin & receiverHasAccount[0] == true) {
            double transactionAmount = amount * -1;

            transaction = new double[]{1, transactionAmount, receiverAccountNo};

            this.transactionHistory.add(transaction);

            //also adding to transaction-history of receiver...
            receiverTransaction = new double[]{0, (transactionAmount * -1), receiverAccountNo};
            //...by updating transactions in receiver Obj
            for(Account account : Main.accountList){
                if(account.getAccountNumber() == receiverAccountNo){
                    account.receiveFunds(transactionAmount * -1);
                    account.transactionHistory.add(receiverTransaction);
                }
            }

            balance -= amount;
            tryCounter = 2;
            newTransactions = true;
            System.out.printf("Thank You.\nYour new Balance is: %.2f\n", balance);
            System.out.println("Do you want to make another transaction?\nType '1' for YES or '0' for NO");
            tryAgain = scanner.nextInt();
            if (tryAgain > 0) {
                System.out.println("Please enter the receivers acct No.");
                int newReceiver = scanner.nextInt();
                System.out.println("Please enter the amount");
                double newAmount = scanner.nextDouble();
                transaction(newAmount, newReceiver);
            } else {
                System.out.printf("Thank You.\nYour Balance is: %.2f\n", balance);

                if (newTransactions) {
                    System.out.println("Your transactions were successful");

                    for(double[] transactionArray : this.transactionHistory){
                        if(transactionArray[0]==1) {
                            System.out.println("Sum: " + (transactionArray[1] * -1) + "  | transferred to Acct: " + transactionArray[2]);
                        }
                        else if(transactionArray[0]==0) {
                            System.out.println("Sum: " + transactionArray[1] + "  | received from Acct: " + transactionArray[2]);
                        }
                    }
                }
            }
        }
        else if (isPin){
            System.out.printf("Maximum amount available: %.2f\n", balance);
            System.out.println("Please enter a lower amount to transfer");

            if(tryAgain == 1){
                Double newAmount = scanner.nextDouble();
                transaction(newAmount, receiverAccountNo);
            }
        }
        else if (tryCounter > 0){
            --tryCounter;
            System.out.println("Wrong pin- try again");
            transaction(amount, receiverAccountNo);
        }
        else{
            System.out.println("TILT!");
        }
    }








}
