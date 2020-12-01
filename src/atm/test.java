/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Andrew
 */
public class test {
    public static void main(String[] args) {
        Bank.addUser("Andrew", "1234");
        Bank.addUser("William", "5454");
        
        ATM a1 = new ATM();
        ATM a2 = new ATM();
    }
}
