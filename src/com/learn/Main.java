package com.learn;

import java.text.NumberFormat;
import java.util.Scanner; //import scanner class
//intellij is cool, web editors suck

class Main {
    static float calcMortgage(int principal,float monthlyInterest,int numPayments) {
        return (float) (principal * (monthlyInterest * Math.pow((1 + monthlyInterest),numPayments))
                                 / (Math.pow((1 + monthlyInterest),numPayments)-1));
    }

    public static void main(String[] args) {
        //constants
        final int MONTHS_IN_YEAR = 12;
        final int PERCENT = 100;
        int principal;
        float annualInterest;
        int numPayments;

        Scanner scan = new Scanner(System.in); //init scanner

        while (true) {
            System.out.print("Principal ($1k - $1M): ");
            principal = scan.nextInt();
            if (principal >= 1000 && principal<=1000000)
                break;
            else
                System.out.println("Principal must be between $1,000 and $1,000,000");
        }

        while (true){
            System.out.print("Annual Interest: ");
            annualInterest = scan.nextFloat();
            if (annualInterest > 0.0f && annualInterest <= 30.0f)
                break;
            else
                System.out.println("annual Interest must be more than 0% and less than or equal to 30%");
        }
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        while (true) {
            System.out.print("Years Financed: ");
            numPayments = scan.nextInt();
            if (numPayments > 0 && numPayments <=30)
                break;
            else
                System.out.println("Years must be between 1 and 30");
        }
        numPayments *= MONTHS_IN_YEAR;

        float mortgage = calcMortgage(principal,monthlyInterest,numPayments);

        System.out.println("Your Mortgage is: "+ NumberFormat.getCurrencyInstance().format(mortgage));
    }
}
