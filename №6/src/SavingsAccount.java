import java.util.Scanner;
public class SavingsAccount {
    static private double annualInterestRate;
    private double savingBalance;

    public SavingsAccount(double savingBalance)
    {
        this.savingBalance = savingBalance;
    }

    public double getSavingBalance()
    {
        return this.savingBalance;
    }

    public static void modifyInterestRate(double newInterestRate)
    {
        annualInterestRate = newInterestRate;
    }

    public void calculateMonthlyInterest()
    {
        double monthlyI;
        monthlyI = (double)(this.savingBalance * annualInterestRate / 12);
        this.savingBalance += monthlyI;
    }

    public static void main(String[] args) {
        SavingsAccount saver1, saver2;
        saver1 = new SavingsAccount(2000.0);
        saver2 = new SavingsAccount(3000.0);

        int total = 0;

        SavingsAccount.modifyInterestRate(0.04);
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();

        System.out.println("This month:\nSaver 1 balance= "+ saver1.getSavingBalance());
        System.out.println("Saver 2 balance= " + saver2.getSavingBalance());

        SavingsAccount.modifyInterestRate(0.05);

        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("Next month:\nSaver 1 balance= " + saver1.getSavingBalance());
        System.out.println("Saver 2 balance= " + saver2.getSavingBalance());
    }
}
