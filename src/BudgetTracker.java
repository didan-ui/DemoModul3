import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Transaction {
    String type; // "Income" atau "Expense"
    String description;
    double amount;

    public Transaction(String type, String description, double amount) {
        this.type = type;
        this.description = description;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return type + ": " + description + " - Rp" + amount;
    }
}

public class BudgetTracker {
    private List<Transaction> transactions;
    private double balance;

    public BudgetTracker() {
        transactions = new ArrayList<>();
        balance = 0.0;
    }

    public void addIncome(double amount, String description) {
        transactions.add(new Transaction("Income", description, amount));
        balance += amount;
    }

    public void addExpense(double amount, String description) {
        transactions.add(new Transaction("Expense", description, amount));
        balance -= amount;
    }

    public void showTransactions() {
        System.out.println("\n--- Transaction History ---");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("Current Balance: Rp" + balance);
    }

    public static void main(String[] args) {
        BudgetTracker tracker = new BudgetTracker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("--- WELCOME ---");
            System.out.println("\n--- Budget Tracker Menu ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. Show Transactions");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: Rp");
                    double income = scanner.nextDouble();
                    scanner.nextLine(); // Clear newline
                    System.out.print("Enter income description: ");
                    String incomeDesc = scanner.nextLine();
                    tracker.addIncome(income, incomeDesc);
                    break;
                case 2:
                    System.out.print("Enter expense amount: Rp");
                    double expense = scanner.nextDouble();
                    scanner.nextLine(); // Clear newline
                    System.out.print("Enter expense description: ");
                    String expenseDesc = scanner.nextLine();
                    tracker.addExpense(expense, expenseDesc);
                    break;
                case 3:
                    tracker.showTransactions();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
        System.out.println("Thank you for using Budget Tracker!");
    }
}
