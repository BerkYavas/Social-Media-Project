package frames;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;

import project.AppUser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class EditProfileFrame extends JFrame{
	private JTextField tfNameChange;
	private JTextField tfEmailChange;
	private JTextField tfAgeChange;
	private JTextField tfCountryChange;
	private JTextField tfPasswordChange;
	private JTextField tfusernameConfirmation;
	private JPasswordField pfPasswordConfirmation;
	private JTextField tfSurnameChange;
	
	/*
	 * Creates the frame to edit the profile
	 * Info can be edited with writing on the write textfields. username and password is asked to confirm the changes.
	 */
	public EditProfileFrame() {
		setSize(1200,689);
		setResizable(false);
		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 13));
		getContentPane().setLayout(null);
		
		JLabel lbNameChange = new JLabel("Name");
		lbNameChange.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lbNameChange.setBounds(212, 77, 187, 30);
		getContentPane().add(lbNameChange);
		
		JTextArea txtrEditingTheProfile = new JTextArea();
		txtrEditingTheProfile.setBounds(441, 11, 187, 30);
		txtrEditingTheProfile.setFont(new Font("Times New Roman", Font.BOLD, 22));
		txtrEditingTheProfile.setText("Editing The Profile");
		getContentPane().add(txtrEditingTheProfile);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblAge.setBounds(212, 248, 187, 30);
		getContentPane().add(lblAge);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1.setBounds(212, 188, 187, 30);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_1.setBounds(212, 369, 187, 30);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Country");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_1_1_2.setBounds(212, 308, 187, 30);
		getContentPane().add(lblNewLabel_1_1_2);
		
		tfNameChange = new JTextField();
		tfNameChange.setBounds(212, 106, 168, 20);
		getContentPane().add(tfNameChange);
		tfNameChange.setColumns(10);
		
		tfEmailChange = new JTextField();
		tfEmailChange.setColumns(10);
		tfEmailChange.setBounds(212, 217, 168, 20);
		getContentPane().add(tfEmailChange);
		
		tfAgeChange = new JTextField();
		tfAgeChange.setColumns(10);
		tfAgeChange.setBounds(212, 277, 168, 20);
		getContentPane().add(tfAgeChange);
		
		tfCountryChange = new JTextField();
		tfCountryChange.setColumns(10);
		tfCountryChange.setBounds(212, 338, 168, 20);
		getContentPane().add(tfCountryChange);
		
		tfPasswordChange = new JTextField();
		tfPasswordChange.setColumns(10);
		tfPasswordChange.setBounds(212, 398, 168, 20);
		getContentPane().add(tfPasswordChange);
		
		tfusernameConfirmation = new JTextField();
		tfusernameConfirmation.setColumns(10);
		tfusernameConfirmation.setBounds(586, 193, 236, 20);
		getContentPane().add(tfusernameConfirmation);
		
		pfPasswordConfirmation = new JPasswordField();
		pfPasswordConfirmation.setBounds(586, 253, 233, 20);
		getContentPane().add(pfPasswordConfirmation);
		
		JLabel lbUsername = new JLabel("username");
		lbUsername.setBounds(586, 170, 99, 22);
		getContentPane().add(lbUsername);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(586, 220, 99, 22);
		getContentPane().add(lblPassword);
		
		JTextArea txtrEnterYourUsername = new JTextArea();
		txtrEnterYourUsername.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtrEnterYourUsername.setText("Enter your username and current password to confirm changes.");
		txtrEnterYourUsername.setBounds(574, 133, 396, 27);
		getContentPane().add(txtrEnterYourUsername);
		
		JButton jbConfirmation = new JButton("Confirm");
		jbConfirmation.addActionListener(new ActionListener() {
			
			// If the username and password match, the info is updated and the viewer is sent to its own profile again, the current frame disposes itself.
			public void actionPerformed(ActionEvent e) {
				
				String inputUserName = tfusernameConfirmation.getText();
                String inputPassWord = String.valueOf(pfPasswordConfirmation.getPassword());
                if (AppUser.getNameAndPasswords().containsKey(inputUserName)) {
                	if(AppUser.getNameAndPasswords().get(inputUserName).equals(inputPassWord)) {
                		String newName = tfNameChange.getText();
                		String newSurname = tfSurnameChange.getText();
                		String newEmail = tfEmailChange.getText();
                		String newAge = tfAgeChange.getText();
                		String newCountry = tfCountryChange.getText();
                		String newPassword = tfPasswordChange.getText();
                		
                		AppUser.users.get(AppUser.getUserIndexByUsername(inputUserName)).makeChanges(newPassword, newName, newSurname, newAge,newEmail,newCountry);
                		profileFrame frame = new profileFrame(AppUser.users.get(AppUser.getUserIndexByUsername(inputUserName)),AppUser.users.get(AppUser.getUserIndexByUsername(inputUserName)));
                		frame.setVisible(true);
                		((JFrame) jbConfirmation.getTopLevelAncestor()).dispose();                		

			} }}
		});
		
		jbConfirmation.setBounds(586, 295, 89, 23);
		getContentPane().add(jbConfirmation);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblSurname.setBounds(212, 129, 187, 30);
		getContentPane().add(lblSurname);
		
		tfSurnameChange = new JTextField();
		tfSurnameChange.setColumns(10);
		tfSurnameChange.setBounds(212, 158, 168, 20);
		getContentPane().add(tfSurnameChange);	
	}

	
	
	//Below here are getter&setters. 
	public JTextField getTfNameChange() {
		return tfNameChange;
	}

	public void setTfNameChange(JTextField tfNameChange) {
		this.tfNameChange = tfNameChange;
	}

	public JTextField getTfEmailChange() {
		return tfEmailChange;
	}

	public void setTfEmailChange(JTextField tfEmailChange) {
		this.tfEmailChange = tfEmailChange;
	}

	public JTextField getTfAgeChange() {
		return tfAgeChange;
	}

	public void setTfAgeChange(JTextField tfAgeChange) {
		this.tfAgeChange = tfAgeChange;
	}

	public JTextField getTfCountryChange() {
		return tfCountryChange;
	}

	public void setTfCountryChange(JTextField tfCountryChange) {
		this.tfCountryChange = tfCountryChange;
	}

	public JTextField getTfPasswordChange() {
		return tfPasswordChange;
	}

	public void setTfPasswordChange(JTextField tfPasswordChange) {
		this.tfPasswordChange = tfPasswordChange;
	}

	public JTextField getTfusernameConfirmation() {
		return tfusernameConfirmation;
	}

	public void setTfusernameConfirmation(JTextField tfusernameConfirmation) {
		this.tfusernameConfirmation = tfusernameConfirmation;
	}

	public JPasswordField getPfPasswordConfirmation() {
		return pfPasswordConfirmation;
	}

	public void setPfPasswordConfirmation(JPasswordField pfPasswordConfirmation) {
		this.pfPasswordConfirmation = pfPasswordConfirmation;
	}

	public JTextField getTfSurnameChange() {
		return tfSurnameChange;
	}

	public void setTfSurnameChange(JTextField tfSurnameChange) {
		this.tfSurnameChange = tfSurnameChange;
	}
	
	
}