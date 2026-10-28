import java.util.*;
class BankAccount{
    protected double balance;
    public BankAccount(double initialBalance){
        this.balance=initialBalance;
    }
    public void deposit(double amount){
        if (amount>0) {
            balance +=amount;
            System.out.println("deposited"+amount);
        }
        else{
             System.out.println("Invalid deposit amount");
        }
    }
    public void withdraw(double amount){
        if(amount>0 && amount<=balance){
            balance -=amount;
            System.out.println("withdraw" +amount);
        }
        else{
             System.out.println("insufficient amount");
        }
    }
    public void showBalance(){
        System.out.println("current balance:"+balance);
    }
}
class SavingAccount extends BankAccount{
    public SavingAccount(double initialBalance){
        super(initialBalance);
    }
    @Override
    public void withdraw(double amount){
        if(amount>0 && (balance-amount)>=100){
            balance -=amount;
            System.out.println("withdraw:"+amount);
        }
        else{
            System.out.println("withdraw denied ,balance cannot fall below 100");
        }
    }
}
public class Bank{
    public static void main(String ar[]){
        SavingAccount sa=new SavingAccount(2000);
        sa.showBalance();
        System.out.println();

        sa.deposit(500);
        sa.showBalance();
        System.out.println();

        sa.withdraw(200);
        sa.showBalance();
        System.out.println();
        
        sa.withdraw(2250);
        sa.showBalance();

    }
}