package frames;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

import project.PremiumUser;
import project.AppUser;

public class CreateAccountFrame extends JFrame {
	private JTextField tfSurname;
	private JTextField tfCountry;
	private JTextField tfAge;
	private JTextField tfPassword;
	private JTextField tfUsername;
	private JTextField tfName;
	private JTextField tfConfirmPassword;
	private JTextField txtAccountType;
	private JTextField tfHobby;
	
	/**
	 * Creates a register frame, takes the given info and creates a User. After that it transfers the viewer to its own mainpage while disposing itself.
	 */
	public CreateAccountFrame() {
		getContentPane().setForeground(SystemColor.desktop);
		setSize(1200,689);
		getContentPane().setLayout(null);
		
		tfSurname = new JTextField();
		tfSurname.setColumns(10);
		tfSurname.setBounds(450, 198, 236, 20);
		getContentPane().add(tfSurname);
		
		tfCountry = new JTextField();
		tfCountry.setColumns(10);
		tfCountry.setBounds(450, 269, 236, 20);
		getContentPane().add(tfCountry);
		
		tfAge = new JTextField();
		tfAge.setColumns(10);
		tfAge.setBounds(450, 337, 236, 20);
		getContentPane().add(tfAge);
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(450, 401, 236, 20);
		getContentPane().add(tfPassword);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(450, 65, 236, 20);
		getContentPane().add(tfUsername);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(450, 129, 236, 20);
		getContentPane().add(tfName);
		
		tfConfirmPassword = new JTextField();
		tfConfirmPassword.setColumns(10);
		tfConfirmPassword.setBounds(450, 465, 236, 20);
		getContentPane().add(tfConfirmPassword);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(450, 96, 99, 22);
		getContentPane().add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(450, 165, 99, 22);
		getContentPane().add(lblSurname);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(450, 236, 99, 22);
		getContentPane().add(lblCountry);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(450, 304, 99, 22);
		getContentPane().add(lblAge);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(450, 368, 99, 22);
		getContentPane().add(lblPassword);
		
		JLabel lbUsername_4_1 = new JLabel("ConfirmPassword");
		lbUsername_4_1.setBounds(450, 432, 116, 22);
		getContentPane().add(lbUsername_4_1);
		
		JLabel lbUsername_4_2 = new JLabel("Username");
		lbUsername_4_2.setBounds(450, 34, 99, 22);
		getContentPane().add(lbUsername_4_2);
		
		JTextArea txtrChooseYourPassword = new JTextArea();
		txtrChooseYourPassword.setEditable(false);
		txtrChooseYourPassword.setBackground(SystemColor.menu);
		txtrChooseYourPassword.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrChooseYourPassword.setText("Choose your password wisely!");
		txtrChooseYourPassword.setBounds(35, 78, 298, 44);
		getContentPane().add(txtrChooseYourPassword);
		
		JTextArea txtrPressTheButton = new JTextArea();
		txtrPressTheButton.setEditable(false);
		txtrPressTheButton.setBackground(SystemColor.menu);
		txtrPressTheButton.setText("Press the button and pay for the Premium!");
		txtrPressTheButton.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtrPressTheButton.setBounds(737, 74, 418, 44);
		getContentPane().add(txtrPressTheButton);
		
		JButton btPremiumAccount = new JButton("Premium Account!");
		btPremiumAccount.setBackground(UIManager.getColor("Button.background"));
		btPremiumAccount.addActionListener(new ActionListener() {
			
			// Premium account option. Press it and you are premium.
			public void actionPerformed(ActionEvent e) {
				btPremiumAccount.setEnabled(false);
				txtAccountType.setText("Premium");
			}
		});
		btPremiumAccount.setBounds(888, 146, 148, 41);
		getContentPane().add(btPremiumAccount);
		
		JButton btCreateAccount = new JButton("Create Account");
		btCreateAccount.setBounds(500, 559, 130, 23);
		getContentPane().add(btCreateAccount);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setBounds(759, 214, 116, 22);
		getContentPane().add(lblAccountType);
		
		txtAccountType = new JTextField();
		txtAccountType.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAccountType.setEnabled(false);
		txtAccountType.setText("Standart");
		txtAccountType.setColumns(10);
		txtAccountType.setBounds(759, 237, 236, 20);
		getContentPane().add(txtAccountType);
		
		JLabel lblHobbyoptional = new JLabel("Hobby (Optional)");
		lblHobbyoptional.setBounds(450, 496, 99, 22);
		getContentPane().add(lblHobbyoptional);
		
		tfHobby = new JTextField();
		tfHobby.setColumns(10);
		tfHobby.setBounds(450, 529, 236, 20);
		getContentPane().add(tfHobby);
		btCreateAccount.addActionListener(new ActionListener() {
			// If the textfields are not empty and the info is in correct form, a new user is created and the mainpage is loaded.

			public void actionPerformed(ActionEvent e) {
				String username = tfUsername.getText();
				String name = tfName.getText();
				String surname = tfSurname.getText();
				String country = tfCountry.getText();
				String age = tfAge.getText();
				String password = tfPassword.getText();
				String ConfirmPassword = tfConfirmPassword.getText();
				String hobby = tfHobby.getText();
				
				if (ConfirmPassword.equals(password) && username != null && name!= null && surname != null && country != null && age != null && password != null) {
					if (btPremiumAccount.isEnabled()) {
						AppUser newGuy = new AppUser(username,password,name,surname,country,age,hobby,null);
						((JFrame) btCreateAccount.getTopLevelAncestor()).dispose();
						mainPageFrame newFrame = new mainPageFrame(newGuy);
						newFrame.setVisible(true);
					}
					else {
						PremiumUser newGuy = new PremiumUser(username,password,name,surname,country,age,hobby,null);
						((JFrame) btCreateAccount.getTopLevelAncestor()).dispose();
						mainPageFrame newFrame = new mainPageFrame(newGuy);
						newFrame.setVisible(true);
					}
					
					
					
					
				}
				
			}
		});
	
	}

	
	//Below here are getter&setters. 

	public JTextField getTfSurname() {
		return tfSurname;
	}

	public void setTfSurname(JTextField tfSurname) {
		this.tfSurname = tfSurname;
	}

	public JTextField getTfCountry() {
		return tfCountry;
	}

	public void setTfCountry(JTextField tfCountry) {
		this.tfCountry = tfCountry;
	}

	public JTextField getTfAge() {
		return tfAge;
	}

	public void setTfAge(JTextField tfAge) {
		this.tfAge = tfAge;
	}

	public JTextField getTfPassword() {
		return tfPassword;
	}

	public void setTfPassword(JTextField tfPassword) {
		this.tfPassword = tfPassword;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public JTextField getTfName() {
		return tfName;
	}

	public void setTfName(JTextField tfName) {
		this.tfName = tfName;
	}

	public JTextField getTfConfirmPassword() {
		return tfConfirmPassword;
	}

	public void setTfConfirmPassword(JTextField tfConfirmPassword) {
		this.tfConfirmPassword = tfConfirmPassword;
	}

	public JTextField getTxtAccountType() {
		return txtAccountType;
	}

	public void setTxtAccountType(JTextField txtAccountType) {
		this.txtAccountType = txtAccountType;
	}

	public JTextField getTfHobby() {
		return tfHobby;
	}

	public void setTfHobby(JTextField tfHobby) {
		this.tfHobby = tfHobby;
	}
	
	

}