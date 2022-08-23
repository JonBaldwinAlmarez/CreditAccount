/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs6203_javacredit_almarez_jonbaldwin;
import java.util.Scanner;
/**
 *
 * @author almar
 */
public class newCreditAccountAlmarez {
    private String name;
    private double annualIncome;
    private int accountNumber;
    private double creditLimit;
    private double creditBalance;
    private double purchase;
    private double allowablePurchaseAmount;
    private double interestRate;
    private double payment;
    
        Scanner scan = new Scanner(System.in);
        
        public void account() {
            System.out.print("Enter name: ");
            this.name = scan.nextLine();
            System.out.println("      ");
            System.out.print("Enter Annual Income: ");
            this.annualIncome = scan.nextDouble();
                // Checking
                while(this.annualIncome <= 200000) {
                    System.out.print("Annual Income must be greater than 200,000 to be eligible for credit.");
                    System.out.println("        ");
                    System.out.println("Enter Annual Income: ");
                    this.annualIncome = scan.nextDouble();
                } 
                // initialize Account.
                this.accountNumber = (int)(Math.random() * 9999 + 1);
                this.setCreditLimit(this.annualIncome);
                this.setCreditBalance(creditBalance);
                this.setAllowablePurchaseAmount(this.getCreditLimit());
                
        }
        
        public void toPrint() {
            System.out.println("      ");
            System.out.println("name: " + this.name);
            System.out.println("Enter Annual Income: " + this.annualIncome);
            System.out.println("Account Number: " + this.accountNumber);
            System.out.println("Credit Limit: " + this.getCreditLimit());
            System.out.println("Credit balance: " + this.getCreditBalance());
            System.out.println("Allowable Purchase Amount " + this.getAllowablePurchaseAmount());
            System.out.println("      ");
        }
        
        public void menu() {
        System.out.println("      ");
        System.out.println("Java Credit Main Menu");
        System.out.println("[1]New Credit Account");
        System.out.println("[2]Credit Inquiry");
        System.out.println("[3]Purchases");
        System.out.println("[4]Payment");
        System.out.println("[5]Close Credit Account");
        System.out.println("[6]Exit");
        System.out.println("        ");
    }
    // Check Account Number.
    public void validateAccountNumber() {
        System.out.println("      ");
        System.out.print("Enter Account Number: ");
        int inputAccountNumber = scan.nextInt();
        
        while(inputAccountNumber != this.accountNumber) {
            System.out.println("      ");
            System.out.println("Invalid Account Number");
                    
            System.out.print("Enter Account Number: ");
            inputAccountNumber = scan.nextInt();
            System.out.println("      ");
        }
    }
    
    public void purchase() {
        System.out.println("      ");
        System.out.print("Credit Limit: " + this.getCreditLimit());
        System.out.println("      ");
        System.out.print("Enter amount of purchase: ");
        this.purchase = scan.nextInt();
        
        
        if(this.purchase >= this.getCreditLimit() || this.creditLimit <= 1 ) {
            System.out.print("Purchase Exceed Credit limit.");
            System.exit(0);
        }
        else if(this.purchase > 1 && this.purchase < this.getCreditLimit() && this.purchase < this.getAllowablePurchaseAmount()){
            this.setCreditBalance(this.creditBalance + this.purchase);
            this.interestRate = this.creditBalance * 0.03;
            this.setCreditBalance(this.creditBalance + this.interestRate);
            this.setAllowablePurchaseAmount(allowablePurchaseAmount - this.purchase);
            System.out.println("Interest rate: " + this.interestRate);
        }
        this.purchase = 0.00;
        System.out.println("      ");
    }
    
    public void payment() {
        System.out.println("      ");
        System.out.println("Credit Balance: " + this.creditBalance);
        System.out.println("      ");
        System.out.print("Enter amount of Payment: ");
        this.payment = scan.nextInt();
        
        // Checking
        while(this.payment <= 1 || this.payment > this.creditBalance) {
            System.out.println("Wrong Input, Input should be above Credit balance");
            System.out.println("Credit balance: " + this.creditBalance);
            
            System.out.print("Enter amount of Payment: ");
            this.payment = scan.nextInt();
        }
        
        this.setCreditBalance(this.creditBalance - this.payment); // Set CreditBalance after payment
        this.setAllowablePurchaseAmount(this.creditBalance + this.payment); // Set AllowablePurchaseAmount after payment
        
        System.out.println("Credit balance: " + this.getCreditBalance());
        System.out.println("Allowable Purchase Amount " + this.getAllowablePurchaseAmount());
        this.payment = 0.00;
    }
    
    public void closeAccount() {
        System.out.println("      ");
        System.out.print("Do you want to close your account: [1]yes : [2]no : ");
        int input = scan.nextInt();
        // Checking for input
        while(input >= 3 || input <= 0) {
            System.out.println("Again.Invalid Input");
            System.out.println("      ");
            System.out.print("Do you want to close your account: [1]yes : [2]no : ");
            input = scan.nextInt();
        }
        // Check the credit balance.
        if(this.creditBalance != 0) {
            System.out.println("You Cannot Close Your Account you still have a Current Balance of : " + this.creditBalance);
            this.toPrint();
        }
        // Reset All Variables
        else if(input == 1) {
            System.out.println("      ");
            this.name = "";
            this.annualIncome = 0.00;
            this.accountNumber = 0000;
            this.creditBalance = 0.00;
            this.creditLimit = 0.00;
            this.payment = 0.00;
            this.purchase = 0.00;
            this.allowablePurchaseAmount = 0.00;
            this.toPrint();
            System.out.println("      ");
            System.out.println("The Account has Been Close.");
            System.out.println("      ");
            this.name = scan.nextLine();
        }
        // Return to main.
        else if(input == 2) {
            
        }
    }
    // Getters and setters
    public double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        if(this.annualIncome < 300000 && this.annualIncome > 200000){
                creditLimit = 300000;
            }
            else if(this.annualIncome < 500000 && this.annualIncome >= 300000){
                creditLimit = 50000;
            }
            else if(this.annualIncome >= 500000) {
                creditLimit = 100000;
            }
        this.creditLimit = creditLimit;
    }

    /**
     * @return the creditBalance
     */
    public double getCreditBalance() {
        return creditBalance;
    }

    /**
     * @param creditBalance the creditBalance to set
     */
    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    /**
     * @return the allowablePurchaseAmount
     */
    public double getAllowablePurchaseAmount() {
        return allowablePurchaseAmount;
    }

    /**
     * @param allowablePurchaseAmount the allowablePurchaseAmount to set
     */
    public void setAllowablePurchaseAmount(double allowablePurchaseAmount) {
        allowablePurchaseAmount = this.getCreditLimit() - this.getCreditBalance();
        this.allowablePurchaseAmount = allowablePurchaseAmount;
    }
}
