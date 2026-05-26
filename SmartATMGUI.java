import javax.swing.*;
import java.awt.event.*;

public class SmartATMGUI extends JFrame implements ActionListener {

    JLabel titleLabel, balanceLabel;
    JButton checkButton, depositButton, withdrawButton, exitButton;

    double balance = 5000;

    SmartATMGUI() {

        setTitle("Smart ATM Machine");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("SMART ATM MACHINE");
        titleLabel.setBounds(100, 20, 250, 30);
        add(titleLabel);

        balanceLabel = new JLabel("Welcome User");
        balanceLabel.setBounds(130, 60, 200, 30);
        add(balanceLabel);

        checkButton = new JButton("Check Balance");
        checkButton.setBounds(110, 100, 160, 35);
        add(checkButton);

        depositButton = new JButton("Deposit Money");
        depositButton.setBounds(110, 150, 160, 35);
        add(depositButton);

        withdrawButton = new JButton("Withdraw Money");
        withdrawButton.setBounds(110, 200, 160, 35);
        add(withdrawButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(110, 250, 160, 35);
        add(exitButton);

        checkButton.addActionListener(this);
        depositButton.addActionListener(this);
        withdrawButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkButton) {

            balanceLabel.setText("Balance: ₹" + balance);

        }

        else if (e.getSource() == depositButton) {

            String input = JOptionPane.showInputDialog(
                    this,
                    "Enter Deposit Amount:"
            );

            double deposit = Double.parseDouble(input);

            balance = balance + deposit;

            JOptionPane.showMessageDialog(
                    this,
                    "₹" + deposit + " Deposited Successfully!"
            );

            balanceLabel.setText("Balance: ₹" + balance);
        }

        else if (e.getSource() == withdrawButton) {

            String input = JOptionPane.showInputDialog(
                    this,
                    "Enter Withdrawal Amount:"
            );

            double withdraw = Double.parseDouble(input);

            if (withdraw <= balance) {

                balance = balance - withdraw;

                JOptionPane.showMessageDialog(
                        this,
                        "Please Collect Your Cash!"
                );

                balanceLabel.setText("Balance: ₹" + balance);

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Insufficient Balance!"
                );
            }
        }

        else if (e.getSource() == exitButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "Thank You For Using ATM"
            );

            System.exit(0);
        }
    }
    public static void main(String[] args) {

        new SmartATMGUI();
    }
}