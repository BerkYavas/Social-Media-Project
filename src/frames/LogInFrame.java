package frames;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import project.AppUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LogInFrame extends JFrame {
    private JLabel lbUsername;
    private JTextArea txtrWelcomeUser;
    private JTextField tfUsername;
    private JLabel lblPassword;
    private JButton jbLogIn;
    private JButton jbForgetPassword;
    private JButton jbCreateAcc;
    private JPasswordField passwordField;
    private JTextArea txtJoke;
    private JTextArea txtDontHaveAcc;

    /**
     * Creates a login frame as the program is ran, if the username is correct the user can log in, or can create a new account.
     */
    public LogInFrame() {
        setResizable(false);
        setBackground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1800,1000);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        lbUsername = new JLabel("username");
        lbUsername.setBounds(685, 267, 99, 22);
        contentPane.add(lbUsername);

        txtrWelcomeUser = new JTextArea();
        txtrWelcomeUser.setEditable(false);
        txtrWelcomeUser.setBackground(SystemColor.menu);
        txtrWelcomeUser.setFont(new Font("Times New Roman", Font.BOLD, 26));
        txtrWelcomeUser.setText("Welcome User!");
        txtrWelcomeUser.setBounds(685, 234, 204, 52);
        contentPane.add(txtrWelcomeUser);

        tfUsername = new JTextField();
        tfUsername.setBounds(685, 286, 236, 20);
        contentPane.add(tfUsername);
        tfUsername.setColumns(10);

        lblPassword = new JLabel("password");
        lblPassword.setBounds(685, 319, 99, 22);
        contentPane.add(lblPassword);

        jbLogIn = new JButton("Log In");

        jbLogIn.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jbLogIn.setBounds(685, 380, 99, 22);
        contentPane.add(jbLogIn);


        jbLogIn.addActionListener(new ActionListener() {
        	
        	// Checks whether password and username are correct, transfers viewer to the mainpage if it is.
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUserName = tfUsername.getText();
                String inputPassWord = String.valueOf(passwordField.getPassword());

                if (AppUser.getNameAndPasswords().containsKey(inputUserName)) {
                    if(AppUser.getNameAndPasswords().get(inputUserName).equals(inputPassWord)) {
                    	mainPageFrame frame = new mainPageFrame(AppUser.users.get(AppUser.getUserIndexByUsername(inputUserName)));
                    	frame.setVisible(true);
                        ((JFrame) jbLogIn.getTopLevelAncestor()).dispose();
                    }
                }
            }
        });

        jbForgetPassword = new JButton("Forgot password?");
        
        jbForgetPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jbForgetPassword.setBounds(794, 380, 127, 23);
        jbForgetPassword.setHorizontalAlignment(SwingConstants.LEFT);
        contentPane.add(jbForgetPassword);

        jbCreateAcc = new JButton("Create Account");
        jbCreateAcc.addActionListener(new ActionListener() {
        	
        	// transfers to createAccountFrame and disposes itself.
            public void actionPerformed(ActionEvent e) {
            	
            	((JFrame) jbCreateAcc.getTopLevelAncestor()).dispose();
                CreateAccountFrame newFrame = new CreateAccountFrame();
                newFrame.setVisible(true);
            }
        });
        jbCreateAcc.setFont(new Font("Tahoma", Font.PLAIN, 11));
        jbCreateAcc.setBounds(820, 414, 117, 23);
        contentPane.add(jbCreateAcc);

        passwordField = new JPasswordField();
        passwordField.setBounds(685, 350, 236, 20);
        contentPane.add(passwordField);
        
        txtJoke = new JTextArea();
        txtJoke.setEditable(false);
        txtJoke.setFont(new Font("Ink Free", Font.BOLD, 16));
        txtJoke.setText("Forgot your password?\r\nToo bad!!\r\nThe instructions did not include it.\r\nAnd I gotta study for Math107!!\r\nNo time!!");
        txtJoke.setBackground(SystemColor.menu);
        txtJoke.setBounds(983, 283, 318, 120);
        contentPane.add(txtJoke);
        
        txtDontHaveAcc = new JTextArea();
        txtDontHaveAcc.setEditable(false);
        txtDontHaveAcc.setText("Don't have an account?");
        txtDontHaveAcc.setBackground(SystemColor.menu);
        txtDontHaveAcc.setBounds(679, 413, 131, 43);
        contentPane.add(txtDontHaveAcc);
        txtJoke.setVisible(false);
        
        jbForgetPassword.addActionListener(new ActionListener() {
        	
        	// A little joke text pops up :) What can I do? I had Math107 midterm to study.
        	public void actionPerformed(ActionEvent e) {
        		
        		txtJoke.setVisible(true);
        	}
        });
        
        txtDontHaveAcc.setLineWrap(true);


    }

    
    
	//Below here are getter&setters. 
	public JLabel getLbUsername() {
		return lbUsername;
	}

	public void setLbUsername(JLabel lbUsername) {
		this.lbUsername = lbUsername;
	}

	public JTextArea getTxtrWelcomeUser() {
		return txtrWelcomeUser;
	}

	public void setTxtrWelcomeUser(JTextArea txtrWelcomeUser) {
		this.txtrWelcomeUser = txtrWelcomeUser;
	}

	public JTextField getTfUsername() {
		return tfUsername;
	}

	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	public JLabel getLblPassword() {
		return lblPassword;
	}

	public void setLblPassword(JLabel lblPassword) {
		this.lblPassword = lblPassword;
	}

	public JButton getJbLogIn() {
		return jbLogIn;
	}

	public void setJbLogIn(JButton jbLogIn) {
		this.jbLogIn = jbLogIn;
	}

	public JButton getJbForgetPassword() {
		return jbForgetPassword;
	}

	public void setJbForgetPassword(JButton jbForgetPassword) {
		this.jbForgetPassword = jbForgetPassword;
	}

	public JButton getJbCreateAcc() {
		return jbCreateAcc;
	}

	public void setJbCreateAcc(JButton jbCreateAcc) {
		this.jbCreateAcc = jbCreateAcc;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	public JTextArea getTxtJoke() {
		return txtJoke;
	}

	public void setTxtJoke(JTextArea txtJoke) {
		this.txtJoke = txtJoke;
	}

	public JTextArea getTxtDontHaveAcc() {
		return txtDontHaveAcc;
	}

	public void setTxtDontHaveAcc(JTextArea txtDontHaveAcc) {
		this.txtDontHaveAcc = txtDontHaveAcc;
	}
    
    
    

}