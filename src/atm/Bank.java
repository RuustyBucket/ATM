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
public class Bank {
    
    public static ArrayList<ATM> atms;
    public static ArrayList<User> users;
    
    public static void addUser(String userName, String pin) {
        users.add(new User(userName, pin));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

}
