import java.util.Scanner;

public class ATM_2026_11_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pin = 1234, attempts = 0, entered = 0;

        while (entered != pin && attempts < 3) {
            System.out.print("Enter PIN: ");
            entered = in.nextInt();
            attempts++;
        }
        if (entered != pin) {
            System.out.println("Card blocked");
            return;
        }

        double balance = 0;
        String[] history = new String[100];
        int count = 0, choice = 0;

        while (choice != 5) {
            System.out.print("\n1.Balance 2.Deposit 3.Withdraw 4.History 5.Exit\nChoose: ");
            choice = in.nextInt();

            if (choice == 1) {
                System.out.println("Balance: " + balance);
            } else if (choice == 2) {
                System.out.print("Amount: ");
                double amount = in.nextDouble();
                balance += amount;
                history[count++] = "Deposit " + amount;
            } else if (choice == 3) {
                System.out.print("Amount: ");
                double amount = in.nextDouble();
                if (amount <= balance) {
                    balance -= amount;
                    history[count++] = "Withdraw " + amount;
                } else {
                    System.out.println("Insufficient balance");
                }
            } else if (choice == 4) {
                for (int i = 0; i < count; i++) {
                    System.out.println(history[i]);
                }
            }
        }
    }
}
