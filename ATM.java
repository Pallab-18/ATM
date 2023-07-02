import java.util.*;

class BankAccount {
    String accountNo = "AC23IBB45";
    int pin = 9876;
    float accountBalance = 87633.8f;
    int transactions = 0;
    String transactionHistory = "";

    Scanner sc = new Scanner(System.in);

    public boolean login() {
        boolean isLogin = false;
        System.out.println("Enter your Account Number :");
        String userAccNo = sc.nextLine();

        if (accountNo.equals(userAccNo)) {
            System.out.println("Enter PIN :");
            int userPin = sc.nextInt();
            if (pin == userPin) {
                isLogin = true;
            } else {
                System.out.println("Incorrect PIN");
                isLogin = false;
            }
        } else {
            System.out.println("Incorrect Account Number...");
            isLogin = false;
        }
        return isLogin;
    }

    public void displayTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions.\n");
        } else {
            System.out.println(transactionHistory);
        }
    }

    public void withdraw() {
        System.out.println("Enter amount to withdraw:");
        float amount = sc.nextFloat();

        if (accountBalance >= amount) {
            if (amount <= 10000.00f) {
                accountBalance -= amount;
                transactions++;
                String str = amount + " Rs. Withdrawn.\n";
                transactionHistory = transactionHistory.concat(str);
                System.out.println("Withdrawal Successful.\n");
            } else {
                System.out.println("Limit is 10000.00.\n");
            }
        } else {
            System.out.println("Insufficient Balance.\n");
        }
    }

    public void deposit() {
        System.out.println("Enter amount to deposit:");
        float amount = sc.nextFloat();

        if (amount <= 10000.00f) {
            accountBalance += amount;
            transactions++;
            String str = amount + " Rs. Deposited.\n";
            transactionHistory = transactionHistory.concat(str);
            System.out.println("Successfully Deposited.\n");
        } else {
            System.out.println("Limit is 10000.00.\n");
        }
    }

    public void transfer() {
        System.out.println("Enter Account Number of Recipient:");
        String accNumberR = sc.next();

        System.out.println("Enter amount:");
        float amount = sc.nextFloat();

        if (accountBalance >= amount) {
            if (amount <= 15000.00f) {
                System.out.println("\nAmount transferred Successfully.\n");
                accountBalance -= amount;
                transactions++;
                String str = amount + " Rs. transferred to " + accNumberR + "\n";
                transactionHistory = transactionHistory.concat(str);
            } else {
                System.out.println("Limit is 15000.00.\n");
            }
        } else {
            System.out.println("Insufficient Balance.\n");
        }
    }

    public void checkBalance() {
        System.out.println("Rs." + accountBalance + "\n");
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount a = new BankAccount();
        System.out.println("------------- WELCOME to ATM -------------");
        System.out.println("\nPlease Enter your card\n");

        boolean isValid = a.login();
        if (isValid) {
            boolean flag = false;
            while (!flag) {
                System.out.println();
                System.out.println("----------Enter your choice-----------");
                System.out.println(
                        "1. Transactions History\n2. Withdraw\n3. Deposit\n4. Transfer\n5. Check Balance\n6. Exit\n");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        a.displayTransactionHistory();
                        break;
                    case 2:
                        a.withdraw();
                        break;
                    case 3:
                        a.deposit();
                        break;
                    case 4:
                        a.transfer();
                        break;
                    case 5:
                        a.checkBalance();
                        break;
                    case 6:
                        flag = true;
                        System.out.println("\nThank you for visiting!!!");
                        break;
                    default:
                        System.out.println("Enter correct choice...");
                }
            }
        }
        sc.close();
    }
}
