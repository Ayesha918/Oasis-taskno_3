import java.util.*;

class User {
    private String userId;
    private String userPin;
    private double balance;
    private List<String> transactionHistory;

    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() { 
        return userId; 
    }
    public String getUserPin() { 
        return userPin;
     }
    public double getBalance() { 
        return balance; 
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addTransaction(String detail) {
        transactionHistory.add(detail);
    }

    public void showTransactionHistory() {
        System.out.println("\n----- Transaction History -----");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}

class Bank {
    private Map<String, User> users = new HashMap<>();

    public Bank() {
        users.put("101", new User("101", "1234", 5000));
        users.put("102", new User("102", "5678", 8000));
        users.put("103", new User("103", "0000", 10000));
    }

    public User validateUser(String userId, String userPin) {
        User user = users.get(userId);
        if (user != null && user.getUserPin().equals(userPin)) {
            return user;
        }
        return null;
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}

class ATMOperations {

    public void withdraw(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > user.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            user.setBalance(user.getBalance() - amount);
            user.addTransaction("Withdrawn: ₹" + amount);
            System.out.println("Withdrawal successful! Remaining balance: ₹" + user.getBalance());
        }
    }

    public void deposit(User user, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            user.setBalance(user.getBalance() + amount);
            user.addTransaction("Deposited: ₹" + amount);
            System.out.println("Deposit successful! Current balance: ₹" + user.getBalance());
        }
    }

    public void transfer(User sender, User receiver, double amount) {
        if (receiver == null) {
            System.out.println("Receiver not found!");
            return;
        }
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > sender.getBalance()) {
            System.out.println("Insufficient balance!");
        } else {
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);
            sender.addTransaction("Transferred ₹" + amount + " to User ID " + receiver.getUserId());
            receiver.addTransaction("Received ₹" + amount + " from User ID " + sender.getUserId());
            System.out.println("Transfer successful! Remaining balance: ₹" + sender.getBalance());
        }
    }
}

class ATMMenu {
    private Scanner sc = new Scanner(System.in);
    private ATMOperations operations = new ATMOperations();
    private Bank bank = new Bank();

    public void start() {
        System.out.println("===== Welcome to the ATM System =====");
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        User currentUser = bank.validateUser(userId, pin);
        if (currentUser == null) {
            System.out.println("Invalid User ID or PIN!");
            return;
        }

        System.out.println("\nLogin Successful!");
        int choice;
        do {
            System.out.println("\n----- ATM Menu -----");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    currentUser.showTransactionHistory();
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double w = sc.nextDouble();
                    operations.withdraw(currentUser, w);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: ");
                    double d = sc.nextDouble();
                    operations.deposit(currentUser, d);
                    break;
                case 4:
                    System.out.print("Enter receiver User ID: ");
                    String recvId = sc.next();
                    System.out.print("Enter amount to transfer: ");
                    double t = sc.nextDouble();
                    operations.transfer(currentUser, bank.getUser(recvId), t);
                    break;
                case 5:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        ATMMenu menu = new ATMMenu();
        menu.start();
    }
}
