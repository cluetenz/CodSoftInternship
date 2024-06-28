import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

// BankAccount class to manage the account balance and transactions
class BankAccount {
    private double balance;
    private List<String> transactions;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited $" + String.format("%.2f", amount));
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew $" + String.format("%.2f", amount));
            return true;
        }
        return false;
    }
}

// ATM class to create the GUI and handle user interactions
public class ATM {
    private BankAccount account;
    private JFrame frame;
    private JTextField pinField;
    private JLabel messageLabel;
    private JButton balanceButton, depositButton, withdrawButton;
    private JTextField amountField;

    public ATM(BankAccount account) {
        this.account = account;
        createGUI();
    }

    private void createGUI() {
        // Setting up the frame
        frame = new JFrame("ATM Interface");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // PIN Label and Field
        JLabel pinLabel = new JLabel("Enter PIN:");
        pinLabel.setBounds(50, 30, 100, 25);
        frame.add(pinLabel);

        pinField = new JTextField();
        pinField.setBounds(150, 30, 150, 25);
        frame.add(pinField);

        // Login Button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(310, 30, 80, 25);
        loginButton.addActionListener(e -> verifyPin());
        frame.add(loginButton);

        // Check Balance Button
        balanceButton = new JButton("Check Balance");
        balanceButton.setBounds(50, 80, 150, 25);
        balanceButton.setEnabled(false);
        balanceButton.addActionListener(e -> checkBalance());
        frame.add(balanceButton);

        // Deposit Button
        depositButton = new JButton("Deposit");
        depositButton.setBounds(210, 80, 150, 25);
        depositButton.setEnabled(false);
        depositButton.addActionListener(e -> deposit());
        frame.add(depositButton);

        // Withdraw Button
        withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(50, 120, 150, 25);
        withdrawButton.setEnabled(false);
        withdrawButton.addActionListener(e -> withdraw());
        frame.add(withdrawButton);

        // Amount Label and Field
        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(210, 120, 100, 25);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(270, 120, 100, 25);
        frame.add(amountField);

        // Message Label
        messageLabel = new JLabel("");
        messageLabel.setBounds(50, 160, 320, 25);
        frame.add(messageLabel);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    private void verifyPin() {
        String pin = pinField.getText();
        if ("1234".equals(pin)) {  // Simplified PIN verification
            enableButtons();
            messageLabel.setText("PIN verified. You can now perform transactions.");
        } else {
            messageLabel.setText("Invalid PIN. Try again.");
        }
    }

    private void enableButtons() {
        balanceButton.setEnabled(true);
        depositButton.setEnabled(true);
        withdrawButton.setEnabled(true);
    }

    private void checkBalance() {
        messageLabel.setText("Current Balance: $" + String.format("%.2f", account.getBalance()));
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.deposit(amount)) {
                messageLabel.setText("Deposited $" + String.format("%.2f", amount));
            } else {
                messageLabel.setText("Invalid deposit amount.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid amount.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (account.withdraw(amount)) {
                messageLabel.setText("Withdrew $" + String.format("%.2f", amount));
            } else {
                messageLabel.setText("Insufficient balance or invalid amount.");
            }
        } catch (NumberFormatException e) {
            messageLabel.setText("Please enter a valid amount.");
        }
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance for testing
        new ATM(account);
    }
}
