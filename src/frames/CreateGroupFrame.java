package frames;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.AppUser;
import project.AppGroup;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class CreateGroupFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfGroupName;
	private JTextField tfGroupHobbies;
	private JTextField tfUsernameSearch;
	private ArrayList<AppUser> givenUsers;
	private JTextField tfGroupCountry;
	/**
	 *Constructor takes the users name repeatedly and other group components once, like group name, country and hobbies. Forms the group with the viewer as the constructor   
	 * @param viewer
	 */
	public CreateGroupFrame(AppUser viewer) {
		givenUsers = new ArrayList<AppUser>();
		givenUsers.add(viewer);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setSize(1800,1000);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Creating a Group");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(688, 122, 264, 80);
		contentPane.add(lblNewLabel);
		
		JLabel lbGroupHobbies = new JLabel("Group Hobbies");
		lbGroupHobbies.setBounds(656, 279, 91, 32);
		contentPane.add(lbGroupHobbies);
		
		JLabel lbGroupName = new JLabel("Group Name:");
		lbGroupName.setBounds(656, 241, 91, 32);
		contentPane.add(lbGroupName);
		
		tfGroupName = new JTextField();
		tfGroupName.setText("");
		tfGroupName.setBounds(752, 247, 127, 20);
		contentPane.add(tfGroupName);
		tfGroupName.setColumns(10);
		
		tfGroupHobbies = new JTextField();
		tfGroupHobbies.setText("");
		tfGroupHobbies.setColumns(10);
		tfGroupHobbies.setBounds(752, 285, 127, 20);
		contentPane.add(tfGroupHobbies);
		
		tfUsernameSearch = new JTextField();
		tfUsernameSearch.setBounds(717, 401, 149, 20);
		contentPane.add(tfUsernameSearch);
		tfUsernameSearch.setColumns(10);
		
		JButton jbAddUser = new JButton("Add User");
		jbAddUser.addActionListener(new ActionListener() {
			
			// Adds the written user to the group if the user exists. 
			public void actionPerformed(ActionEvent e) {
				for (AppUser user : AppUser.users) {
				if (tfUsernameSearch.getText().equals(user.getUsername())) {
					givenUsers.add(user);
					tfUsernameSearch.setText("");
				}
				}
			}
		});
		jbAddUser.setBounds(747, 432, 89, 23);
		contentPane.add(jbAddUser);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the names of users you want in your group one after another");
		lblNewLabel_1.setBounds(614, 369, 400, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton jbCreateAGroup = new JButton("Create a Group");
		jbCreateAGroup.addActionListener(new ActionListener() {
			
			// Creates the group, the viewer as the creator. Disposes the current frame and makes the group page visible.
			public void actionPerformed(ActionEvent e) {
				
				if (tfGroupName.getText() != null && tfGroupHobbies.getText() != null) {
					AppGroup newGroup = new AppGroup(tfGroupName.getText(),tfGroupCountry.getText(),tfGroupHobbies.getText(),viewer,givenUsers);
					groupFrame frame = new groupFrame(newGroup,viewer);
					frame.setVisible(true);
					((JFrame) jbCreateAGroup.getTopLevelAncestor()).dispose();

				}
			}
		});
		jbCreateAGroup.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jbCreateAGroup.setBounds(688, 549, 226, 80);
		contentPane.add(jbCreateAGroup);
		
		JLabel lbGroupCountry = new JLabel("Group Country");
		lbGroupCountry.setBounds(656, 319, 91, 32);
		contentPane.add(lbGroupCountry);
		
		tfGroupCountry = new JTextField();
		tfGroupCountry.setText("");
		tfGroupCountry.setColumns(10);
		tfGroupCountry.setBounds(752, 325, 127, 20);
		contentPane.add(tfGroupCountry);
	}
	
	
	//Below here are getter&setters. 

	public JTextField getTfGroupName() {
		return tfGroupName;
	}
	public void setTfGroupName(JTextField tfGroupName) {
		this.tfGroupName = tfGroupName;
	}
	public JTextField getTfGroupHobbies() {
		return tfGroupHobbies;
	}
	public void setTfGroupHobbies(JTextField tfGroupHobbies) {
		this.tfGroupHobbies = tfGroupHobbies;
	}
	public JTextField getTfUsernameSearch() {
		return tfUsernameSearch;
	}
	public void setTfUsernameSearch(JTextField tfUsernameSearch) {
		this.tfUsernameSearch = tfUsernameSearch;
	}
	public ArrayList<AppUser> getGivenUsers() {
		return givenUsers;
	}
	public void setGivenUsers(ArrayList<AppUser> givenUsers) {
		this.givenUsers = givenUsers;
	}
	public JTextField getTfGroupCountry() {
		return tfGroupCountry;
	}
	public void setTfGroupCountry(JTextField tfGroupCountry) {
		this.tfGroupCountry = tfGroupCountry;
	}
	
	

}
