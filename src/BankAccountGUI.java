import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankAccountGUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<BankAccount> bankAccounts;
	
	public BankAccountGUI() { 
		bankAccounts = new ArrayList<BankAccount>();
		this.setBounds(100, 100, 700, 600);
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setSize(600, 500);
		overall.setLayout(cl);
		
		JPanel panel1 = new JPanel(new GridBagLayout());
		JLabel name1 = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel1.add(name1, gbc);
		JLabel aA = new JLabel("Add Account");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel1.add(aA, gbc);
		JTextField fld1 = new JTextField("");
		fld1.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel1.add(fld1, gbc);
		JLabel deposit1 = new JLabel("Initial Deposit:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel1.add(deposit1, gbc);
		JTextField fld2 = new JTextField("");
		fld2.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 1;
		panel1.add(fld2, gbc);
		JLabel acctType = new JLabel("Account Type:");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel1.add(acctType);
		JComboBox<String> accts = new JComboBox<String>();
		accts.addItem("Savings Account");
		accts.addItem("Checking Account");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel1.add(accts);
		JButton submit = new JButton("Submit");
		gbc.gridx = 20;
		gbc.gridy = 20;
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
				if (accts.getSelectedItem().equals("Savings Account")) {
					SavingsAccount s = new SavingsAccount(name1.getText(), Double.parseDouble(fld2.getText()), 1.00, 100.0, 10.0, (int)(Math.random()*1000000000 + 1000000000));
					bankAccounts.add(bankAccounts.size(), s);
					JOptionPane.showMessageDialog(panel1, "Your account number is " + s.getAccountNumber());
				} else if (accts.getSelectedItem().equals("Checking Account")) {
					CheckingAccount c = new CheckingAccount(name1.getText(), Double.parseDouble(fld2.getText()), 10.0, 1.0, 10, (int)(Math.random()*1000000000 + 1000000000));
					bankAccounts.add(bankAccounts.size(), c);
					JOptionPane.showMessageDialog(panel1, "Your account number is " + c.getAccountNumber());
			}
				fld1.setText("");
				fld2.setText("");
			} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(panel1, "Please enter an appropriate balance");
					fld1.setText("");
					fld2.setText("");
			}
			}
		});
		panel1.add(submit);
		
		JPanel panel2 = new JPanel(new GridBagLayout());
		JLabel name2 = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel2.add(name2, gbc);
		JLabel rA = new JLabel("Remove account");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel2.add(rA, gbc);
		JTextField fld3 = new JTextField("");
		fld3.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel2.add(fld3, gbc);
		JLabel acctNum = new JLabel("Account Number:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel2.add(acctNum, gbc);
		JTextField fld4 = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 1;
		fld4.setPreferredSize(new Dimension(70,30));
		panel2.add(fld4, gbc);
		JButton submit2 = new JButton("Submit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		submit2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) JOptionPane.showMessageDialog(panel2, "There are no bank accounts");
				for (BankAccount i: bankAccounts) {
					if (i.getName().equals(fld3.getText()) && i.getAccountNumber() == Integer.parseInt(fld4.getText())) {
						bankAccounts.remove(i);
						JOptionPane.showMessageDialog(panel2, "Bank account has been removed");
					} else {
						JOptionPane.showMessageDialog(panel2, "Sorry, your bank account could not be found");
					}
				}
				if (fld3.getText().length() == 0 || fld4.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel2, "Please put in your name and account number");
				}
				fld3.setText("");
				fld4.setText("");
			}
		});
		panel2.add(submit2);
		
		JPanel panel3 = new JPanel(new GridBagLayout());
		JLabel name3 = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel3.add(name3, gbc);
		JLabel fA = new JLabel("Find Account");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel3.add(fA, gbc);
		JTextField fld5 = new JTextField("");
		fld5.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel3.add(fld5, gbc);
		JLabel acctNum2 = new JLabel("Account Number:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel3.add(acctNum2, gbc);
		JTextField fld6 = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 1;
		fld6.setPreferredSize(new Dimension(70,30));
		panel3.add(fld6, gbc);
		JButton submit3 = new JButton("Submit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		submit3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) JOptionPane.showMessageDialog(panel2, "There are no bank accounts");
				for (BankAccount i: bankAccounts) {
					if (i.getName().equals(fld5.getText()) && i.getAccountNumber() == Integer.parseInt(fld6.getText())) {
						JOptionPane.showMessageDialog(panel3, i.toString());
					} else {
						JOptionPane.showMessageDialog(panel3, "Sorry, your bank account could not be found");
					}
				}
				if (fld3.getText().length() == 0 || fld4.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel3, "Please put in your name and account number");
				}
				fld5.setText("");
				fld6.setText("");
			}
		});
		panel3.add(submit3);
		
		JPanel panel4 = new JPanel();
		JLabel name4 = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel4.add(name4, gbc);
		JTextField fld7 = new JTextField("");
		fld7.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel4.add(fld7, gbc);
		JLabel acctNum3 = new JLabel("Account Number:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel4.add(acctNum3, gbc);
		JTextField fld8 = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		fld8.setPreferredSize(new Dimension(70,30));
		panel4.add(fld8, gbc);
		JLabel depAmnt = new JLabel("Deposit amount:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel4.add(depAmnt);
		JTextField fld9 = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 1;
		fld9.setPreferredSize(new Dimension(70,30));
		panel4.add(fld9);
		JButton submit4 = new JButton("Submit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		submit4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) JOptionPane.showMessageDialog(panel2, "There are no bank accounts");
				for (BankAccount i: bankAccounts) {
					if (i.getName().equals(fld7.getText()) && i.getAccountNumber() == Integer.parseInt(fld8.getText())) {
						i.deposit(Double.parseDouble(fld9.getText()));
						JOptionPane.showMessageDialog(panel4, "Your bank account has been deposited");
					} else {
						JOptionPane.showMessageDialog(panel4, "Sorry, your bank account could not be found");
					}
				}
				if (fld3.getText().length() == 0 || fld4.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel4, "Please put in your name, account number, and amount you want to deposit");
				}
				fld7.setText("");
				fld8.setText("");
				fld9.setText("");
			}
		});
		panel4.add(submit4);
		
		JPanel panel5 = new JPanel();
		JLabel name5 = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel5.add(name5, gbc);
		JTextField fld10 = new JTextField("");
		fld10.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel5.add(fld10, gbc);
		JLabel acctNum4 = new JLabel("Account Number:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel5.add(acctNum4, gbc);
		JTextField fld11 = new JTextField("");
		gbc.gridx = 1;
		gbc.gridy = 1;
		fld11.setPreferredSize(new Dimension(70,30));
		panel5.add(fld11, gbc);
		JLabel withAmnt = new JLabel("Withdraw amount:");
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel5.add(withAmnt);
		JTextField fld12 = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 1;
		fld12.setPreferredSize(new Dimension(70,30));
		panel5.add(fld12);
		JButton submit5 = new JButton("Submit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		submit5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) JOptionPane.showMessageDialog(panel2, "There are no bank accounts");
				for (BankAccount i: bankAccounts) {
					if (i.getName().equals(fld10.getText()) && i.getAccountNumber() == Integer.parseInt(fld11.getText())) {
						i.withdraw(Double.parseDouble(fld12.getText()));
						JOptionPane.showMessageDialog(panel5, "Your bank account has been withdrawn");
					} else {
						JOptionPane.showMessageDialog(panel5, "Sorry, your bank account could not be found");
					}
				}
				if (fld3.getText().length() == 0 || fld4.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel5, "Please put in your name, account number, and amount you want to withdraw");
				}
				fld3.setText("");
				fld4.setText("");
			}
		});
		panel5.add(submit5);
		
		JPanel panel6 = new JPanel();
		
		JPanel panel7 = new JPanel();
		JLabel name7 = new JLabel("Name:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel7.add(name7, gbc);
		JLabel gB = new JLabel("Get Balance");
		gbc.gridx = 10;
		gbc.gridy = 10;
		panel7.add(gB, gbc);
		JTextField fld20 = new JTextField("");
		fld20.setPreferredSize(new Dimension(70,30));
		gbc.gridx = 2;
		gbc.gridy = 0;
		panel7.add(fld20, gbc);
		JLabel acctNum7 = new JLabel("Account Number:");
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel7.add(acctNum7, gbc);
		JTextField fld21 = new JTextField("");
		gbc.gridx = 2;
		gbc.gridy = 1;
		fld21.setPreferredSize(new Dimension(70,30));
		panel7.add(fld21, gbc);
		JButton submit7 = new JButton("Submit");
		gbc.gridx = 0;
		gbc.gridy = 5;
		submit7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (bankAccounts.size() == 0) JOptionPane.showMessageDialog(panel2, "There are no bank accounts");
				for (BankAccount i: bankAccounts) {
					if (i.getName().equals(fld20.getText()) && i.getAccountNumber() == Integer.parseInt(fld21.getText())) {
						JOptionPane.showMessageDialog(panel7, "Your balance is " + i.getBalance());
					} else {
						JOptionPane.showMessageDialog(panel7, "Sorry, your bank account could not be found");
					}
				}
				if (fld3.getText().length() == 0 || fld4.getText().length() == 0) {
					JOptionPane.showMessageDialog(panel7, "Please put in your name and account number");
				}
				fld3.setText("");
				fld4.setText("");
			}
		});
		panel7.add(submit7);
		JPanel panel8 = new JPanel();
		panel8.add(new JLabel("Welcome to the Bank Account Management System"));
		panel8.add(new JLabel(new ImageIcon("src/pictures/bankaccount.png")));
		overall.add(panel1, "panel1");
		overall.add(panel2, "panel2");
		overall.add(panel3, "panel3");
		overall.add(panel4, "panel4");
		overall.add(panel5, "panel5");
		overall.add(panel6, "panel6");
		overall.add(panel7, "panel7");
		overall.add(panel8, "panel8");
		cl.show(overall,"panel8");
		add(overall);
		JMenuBar menubar = new JMenuBar();
		JMenu menu1 = new JMenu("Account");
		
		JMenuItem option1 = new JMenuItem("Add account");
		menu1.add(option1);
		option1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel1");
				
			}
			
		});
		
		JMenuItem option2 = new JMenuItem("Remove account");
		menu1.add(option2);
		option2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel2");
			}
			
		});
		JMenuItem option3 = new JMenuItem("Find accounts");
		menu1.add(option3);
		option3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel3");
			}
			
		});
		JMenu menu2 = new JMenu("Transaction");
		
		JMenuItem option4 = new JMenuItem("Deposit");
		menu2.add(option4);
		option4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel4");
				
			}
			
		});
		JMenuItem option5 = new JMenuItem("Withdraw");
		menu2.add(option5);
		option5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel5");
				
			}
			
		});
		JMenuItem option6 = new JMenuItem("Transfer");
		menu2.add(option6);
		option6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel6");
				
			}
			
		});
		JMenuItem option7 = new JMenuItem("Get balance");
		menu2.add(option7);
		option7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel7");
				
			}
			
		});
		JMenuItem menu3 = new JMenuItem("Home");
		menu3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cl.show(overall, "panel8");
				
			}
			
		});
		menubar.add(menu1);
		menubar.add(menu2);
		menubar.add(menu3);
		
		this.setJMenuBar(menubar);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BankAccountGUI();
		
	}

}  