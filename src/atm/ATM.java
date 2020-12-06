/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author Andrew
 */
public class ATM {
    
    private String atmId;
    private User user;
    private Account account;
    private static int nextId = 1;

    public ATM() {
        this.atmId = String.format("%06d", nextId++);
        this.user = null;
        this.account = null;
    }
    
    public ATM(String atmId) {
        this.atmId = atmId;
        this.user = null;
        this.account = null;
    }
        
    public ATM(ATM atm) {
        this.atmId = atm.atmId;
    }    
    
    public void pipeline() {
        printWelcome();
        
        readUserId();
        if (user == null)
            System.exit(1);
        if(!inputPin())
            System.exit(2);
        
        chooseAccount();
        do {        
            int oper = chooseOperation();
            switch (oper) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                default:
                    displayBalance();
            }
        }   while(doesContinue());
        
        printGoodbye();
    }
    
    /**
     * print welcome message at the beginning
     */
    private void printWelcome() {
        System.out.println("Welcome to our ATM.");
    }
    
    /**
     * 
     * 
     */
    public void readUserId() {
       Scanner console = new Scanner(System.in);
        
        System.out.println("Please enter your user ID: ");
        String inputId = console.next();
        
        for (int i = 0; i < Bank.getUsers().size(); i++)
            if (inputId.equals(Bank.getUsers().get(i).getUserId()))
                user = Bank.getUsers().get(i);
                return;
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    private boolean inputPin(User user) {
        Scanner console = new Scanner(System.in);
        int maxTry = 3;
        
        for (int i = 0; i < maxTry; i++) {
            System.out.println("Please enter your pin: ");
            String pin = console.next();
            if (user.getPin().equals(pin))
                return true;
            System.out.println("Your pin is wrong");
        }
        
        System.out.println("you input the wrong pin 3 times.");
        return false;
    }
    
    private void chooseAccount() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please choose the account you want to operate with"
                + "\n\t1. Checking account"
                + "\n\t2. Saving account");
        int accountChoice = console.nextInt();
        
        account = accountChoice == 1 ? user.getCheckingAccount() : user.getSavingAccount();
    }
    
    private int chooseOperation() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Please choose an operation"
                + "\n\t1. Withdraw"
                + "\n\t2. Deposit"
                + "\n\t3. Dislpay balance");
        int operation = console.nextInt();
        
        return operation;
    }
    
    private boolean withdraw() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to withdraw?");
        double amount = console.nextDouble();
        if (account.getBalance() < amount) {
            System.out.println("Sorry, you dont have enough balance. ");
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        System.out.println("Withdraw Success");
        user.getHistory().add(new Record("withdraw", amount, atmId));
        return true;
        
    }
    
    private boolean deposit() {
        Scanner console = new Scanner(System.in);
        
        System.out.println("How much do you want to deposit");
        double amount = console.nextDouble();
        
        account.setBalance(account.getBalance() + amount);
        System.out.println("deposit successful");
        user.getHistory().add(new Record("deposit", amount, atmId));
        return true;
    }
    
    private void displayBalance() {
        System.out.printf("Your current balnace is $%.2f\n", account.getBalance());
    }
    
    public boolean doesContinue() {
        Scanner console = new Scanner(System.in);
        int anserCon;
        
        System.out.println("Do you want to do another operation? ");
         int answerCon = console.nextInt();
         
         return answerCon == 1;
    }
    
    private void printGoodbye() {
        System.out.println("Thank you for using this ATM, goodbye.");
        user = null;
        account = null;
    }
    
    public boolean equals(ATM atm) {
        return this.atmId.equals(atm.atmId);
    }    

    @Override
    public String toString() {
        return String.format("&-10s: %s", "ATM ID", atmId);
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        ATM.nextId = nextId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    
}
