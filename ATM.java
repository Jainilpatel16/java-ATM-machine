//JAINIL PATEL
//gq6908

import java.util.*;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {

        Account[] A = new Account[10];          //create an array of 10.
        int ID;
        double balance;

        for (int i = 0; i < A.length; i++) {   //This for loop runs and set each account with
            balance = 100.00;                  // the balance of $100.00 each.
            ID = i;
            A[i] = new Account(ID, balance);
        }
        menu(A);
    }
    static void menu(Account Acc[])
    {
        int ID;                                  //getting ID from the user and store in this.
        double Amount_withdraw;                  //getting Amount for withdraw from the user.
        double Amount_deposit;                   //getting Amount for deposit from the user.

        System.out.println("Enter an ID: ");    //Ask the user to enter the ID.
        Scanner User_input = new Scanner(System.in);
        ID = User_input.nextInt();

        for(int i = 0; i < Acc.length; i++){
            if(ID == Acc[i].getID() && i < Acc.length){
                do{
                    System.out.println("Main menu");
                    System.out.println("1: check balance");
                    System.out.println("2: withdraw");
                    System.out.println("3: deposit");
                    System.out.println("4: exit");
                    Scanner choice = new Scanner(System.in);
                    System.out.println();
                    System.out.println("Enter a choice: ");
                    int user_choice = choice.nextInt();

                    while (user_choice != 4) {             //checks the user_choice if its within 1 to 4.

                        if (user_choice < 1 || user_choice >= 4) {

                            System.out.println("Enter Again: ");
                            user_choice = choice.nextInt();

                        }

                        else if(user_choice == 1){         //get balance
                            System.out.println("The balance is $ " + Acc[i].getBalance() + "\n");
                            break;
                        }
                        else if(user_choice == 2){        //withdraw
                            System.out.println("Enter an amount to withdraw: ");
                            Amount_withdraw = User_input.nextDouble();
                            Acc[i].withdraw(Amount_withdraw);
                            break;
                        }
                        else if(user_choice == 3){       //deposit
                            System.out.println("Enter the amount to deposit: ");
                            Amount_deposit = User_input.nextDouble();
                            Acc[i].deposit(Amount_deposit);
                            break;
                        }
                        else if(user_choice == 4){      //exit
                            System.exit(0);
                            System.out.println("Enter an ID: ");
                            ID = User_input.nextInt();
                        }
                    }
                }while(true);
            }
            else if(i == Acc.length - 1){       // if user enter the ID greater then the size of array it will ask again to enter the ID.
                System.out.println("You Enter invalid ID.");
                System.out.println("Enter the ID again: ");
                ID = User_input.nextInt();
                i = 0;
            }
        }
    }
}

 /**This is a Account class which has all the functions.
  * @author JAINIL PATEL.
  */
class Account{

    /**A private int data field named id for the account (default 0).
     * A private double data field named balance for the account (default 0).
     * A private double data field named annualInterestRate that stores the current interest rate (default 0).
     * A private Date data field named dateCreated that stores the date when the account was created.
     */

    private int ID = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private java.util.Date dateCreated;

    public Account(){
        dateCreated = new java.util.Date();
    }

     /**A constructor that creates an account with the specified id and initial balance.
      * @param ID
      * @param balance
      */
    public Account(int ID, double balance){
        this();
        this.ID = ID;
        this.balance = balance;
    }

     /** get ID
      * @return ID.
      */
    public int getID() {
        return ID;
    }

     /** get Balance
      * @return balance.
      */
    public double getBalance() {
        return balance;
    }

     /** get annual interest rate
      * @return annual interest rate.
      */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

     /** get date created
      * @return date created.
      */
    public Date getDateCreated() {
        return dateCreated;
    }

     /** set ID
      * @param ID
      */
    public void setID(int ID) {
        this.ID = ID;
    }

     /** set balance
      * @param balance
      */
    public void setBalance(double balance) {
        this.balance = balance;
    }

     /** set annual interest rate
      * @param annualInterestRate
      */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

     /**A method named getMonthlyInterestRate() that returns the monthly interest rate.
      * @return (annual interest rate / 100) / 12.
      */
    public double getMonthlyInterestRate(){
        return (annualInterestRate / 100) / 12;
    }

     /**A method named getMonthlyInterest() that returns the monthly interest not the interest rate.
      * @return (balance * get monthly interest rate);
      */
    public double getMonthlyInterest(){
        return (balance * getMonthlyInterestRate());
    }

     /**A method named withdraw that withdraws a specified amount from the account.
      * @param amount
      */
    public void withdraw(double amount){
        this.balance -= amount;
    }

     /**A method named deposit that deposits a specified amount to the account.
      * @param amount
      */
    public void deposit(double amount){
        this.balance += amount;
    }

}