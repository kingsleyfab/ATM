/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmmechine;
import java.util.Scanner;
/**
 *
 * @author PRESHOZ
 */
public class ATMMechine {
    private double balance;
    private int pin;
    double amount;
    static Scanner scanner;
    
    public ATMMechine(double balance, int pin){
        this.balance = balance;
        this.pin = pin;
    }
    
    public void deposit(double amount){
//        this.balance = this.balance + amount;
        this.balance += amount;
    }
    public void withdraw(double amount){
        
        this.balance -= amount;
    }
    
    public void transfer(double amount){
        
        this.withdraw(amount);
        
    }
    public double getBalance(){
        return this.balance;
    }
    
    public void setPin( int pin){
        this.pin = pin;
    }
    
    public int getPin(){
        return this.pin;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        classname objectname = new classname(parameters if any)
        ATMMechine powerAtm = new ATMMechine(5000,1234);
        scanner = new Scanner(System.in);
        String check = "y";
        
        while (check.toUpperCase().equals("Y")){
            System.out.println("Welcome to King's Bank \nEnter your pin");
        int getpin = scanner.nextInt();
        
        if(getpin == powerAtm.getPin() ){
            
            System.out.println("1.Check Balance \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Recharge \n6.Change pin");
            System.out.println("Select an option");
            
            int option = scanner.nextInt();
            
           if(option == 1){
               System.out.println("Your balance is #" + powerAtm.getBalance());
           }else if(option == 2 ){
               System.out.println("Enter Withdawal amount");
               double amount = scanner.nextDouble();
               powerAtm.withdraw(amount);
               if(powerAtm.getBalance() > amount){
                   powerAtm.transfer(amount);
                   System.out.println("Withdrawal successful \nNew balance is #" + powerAtm.getBalance());
               }else{
               System.out.println("Withdrawal fail \nInsufficient balance"); 
               }
           }else if(option == 3){
               System.out.println("Enter Deposit amount");
               double amount = scanner.nextDouble();
               powerAtm.deposit(amount);
               System.out.println("Deposit successful \nNew balance is #" + powerAtm.getBalance());
               
           }else if(option == 4){
               System.out.println("Enter Transfer amount");
               double amount = scanner.nextDouble();
               if(powerAtm.getBalance() > amount){
                   powerAtm.transfer(amount);
                   System.out.println("Transfer of " + amount + " was successful \nNew balance is #" + powerAtm.getBalance());
               }else{
                   System.out.println("Transfer failed \nInsufficient Balance");
               }
               
            }else if(option == 5){
                System.out.println(" Enter Recharge amount");
                double amount = scanner.nextDouble();
                if(powerAtm.getBalance() > amount){
                    powerAtm.withdraw(amount);
                    System.out.println("Enter pnone number" );
                    long phonenumber =scanner.nextLong();
                    System.out.println("Recharge of " + amount + " was successful \nBalance is #" + powerAtm.getBalance() );
                }
            }else if(option == 6){
                
                System.out.println("Enter old pin");
                int oldpin = scanner.nextInt();
                if(oldpin == powerAtm.getPin()){
                    System.out.println("Enter new pin");
                    int newpin = scanner.nextInt();
                    System.out.println("Confirm new pin");
                    int confirmpin = scanner.nextInt();
                   if(newpin == confirmpin){
                       powerAtm.setPin(newpin);
                   } else {
                       System.out.println("Pin Mismatch, try again");
                   }
                   
                }else{
                    System.out.println("Invalid pin, try again");
                }
                
            }
         
        }
        else{
            System.out.println("Incorrect pin");
        }
       System.out.println("Do you want to perform another transaction? Y/N");
       Scanner scanner = new Scanner(System.in);
       check = scanner.nextLine();
    }
        System.out.println("Thank you for banking with us");
   }
        
   
}
