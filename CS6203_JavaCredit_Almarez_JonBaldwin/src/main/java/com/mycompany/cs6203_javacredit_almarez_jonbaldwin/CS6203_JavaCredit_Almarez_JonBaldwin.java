/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.cs6203_javacredit_almarez_jonbaldwin;
import java.util.Scanner;
/**
 *
 * @author almar
 */
public class CS6203_JavaCredit_Almarez_JonBaldwin {

    public static void main(String[] args) {
        newCreditAccountAlmarez newCAA = new newCreditAccountAlmarez();
        Scanner scan = new Scanner(System.in);
        int input;
        
        newCAA.menu();
        System.out.println("      ");
        System.out.print("Enter Input: ");
        input = Integer.parseInt(scan.nextLine()); // Covert String input to int
        
        while(input < 6) {
            switch(input) {
                // New Account
                case 1 -> {
                    newCAA.account();
                    newCAA.toPrint();
                }
                // Credit Inquiry
                case 2 -> {
                    newCAA.validateAccountNumber();
                    newCAA.toPrint();
                }
                // Purchase
                case 3 -> {
                    newCAA.validateAccountNumber();
                    newCAA.purchase();
                }
                // Payment
                case 4 -> {
                    newCAA.validateAccountNumber();
                    newCAA.payment();
                }
                // Close Account
                case 5 ->{
                    newCAA.validateAccountNumber();
                    newCAA.closeAccount();
                }
                default -> {
                    System.out.println("Wrong Input");
                }
            }
        newCAA.menu();
        
        System.out.println("      ");
        System.out.print("Enter Input: ");
        input = Integer.parseInt(scan.nextLine());
        }
        
        System.out.print("You have exit the program. Goodbye");
    }
}
