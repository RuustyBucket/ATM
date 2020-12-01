/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public class User {

    static int getSavingAccount;

    private String userId;
    private String userName;
    private String pin;
    private Account checkingAccount;
    private Account savingAccount;
    private ArrayList<Record> history;
    private static int nextId = 1;

    public User() {
        this.userId = String.format("%06d", nextId++);
        this.userName = null;
        this.pin = null;
        this.checkingAccount = null;
        this.savingAccount = null;
        this.history = null;
    }

    public User(String pin, String userName) {
        this.userId = String.format("%06d", nextId++);
        this.userName = userName;
        this.pin = pin;
        this.checkingAccount = new Account();
        this.savingAccount = null;
        this.history = new ArrayList<>();
    }

    public User(User user) {
        this.userId = user.userId;
        this.userName = user.userName;
        this.pin = user.pin;
        this.savingAccount = new Account(savingAccount);
        this.checkingAccount = new Account(checkingAccount);
        this.history = new ArrayList<>(history);
    }
    
    public boolean equals(User user) {
        return this.userId.equals(userId) &&
                this.userName.equals(userName) &&
                this.pin.equals(pin) &&
                this.savingAccount.equals(savingAccount) &&
                this.checkingAccount.equals(checkingAccount) &&
                this.history.equals(history);
    }
    
    @Override
    public String toString() {
        String str = "";
        
        str += String.format("%-20s: %s\n", "UserID", userId);
        str += String.format("%-20s: %s\n", "User Name", userName);
        str += String.format("%-20s: %s\n", "Saving Account", savingAccount);
        str += String.format("%-20s: %s\n", "Checking Account", checkingAccount);
        str += String.format("%-20s: %s\n", "History", history);
        
        return str;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Account getCheckingAccount() {
        return checkingAccount;
    }

    public void setCheckingAccount(Account checkingAccount) {
        this.checkingAccount = checkingAccount;
    }

    public Account getSavingAccount() {
        return savingAccount;
    }

    public void setSavingAccount(Account savingAccount) {
        this.savingAccount = savingAccount;
    }
   
    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }

    Object getHistory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}