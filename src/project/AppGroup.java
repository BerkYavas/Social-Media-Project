package project;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import frames.postContentPanel;

public class AppGroup {
	
	public static ArrayList<AppGroup> groups = new ArrayList<AppGroup>();
	
	private String name;
	private String Country;
	private String commonHobbies;
	private AppUser creator;
    private ArrayList<AppUser> members;
    private HashMap<AppUser,postContentPanel> contents;
    private JPanel groupCard;
    
    
    /**
     * Creates a group with the given info, creates a groupcard to be displayed on pages.
     * @param name
     * @param Country
     * @param commonHobbies
     * @param creator
     * @param members
     */
	public AppGroup(String name , String Country , String commonHobbies , AppUser creator , ArrayList<AppUser> members) {
		
		this.name = name;
		this.Country = Country;
		this.commonHobbies = commonHobbies;
		this.creator = creator;
		this.members = members;
		
		
		contents = new HashMap<AppUser,postContentPanel>();
		
		for (AppUser member : members) {
			member.getGroups().add(this);
		}
		
		//Creating the card of the group that will display info about the group and will have a button that will open the groupPage
		groupCard = new JPanel();
		groupCard.setSize(350,200);		
		groupCard.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Group");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(54, 11, 85, 21);
		groupCard.add(lblNewLabel);
				
		JTextField txtgrpName = new JTextField();
		txtgrpName.setBounds(55, 35, 150, 20);
		txtgrpName.setFocusable(true);
		txtgrpName.setEditable(false);
		txtgrpName.setText(this.name);
		txtgrpName.setBackground(new Color(255,255,255));
		txtgrpName.setFont(new Font("Snap ITC",Font.BOLD,18));
		groupCard.add(txtgrpName);
		
		txtgrpName.setColumns(10);
		JLabel lbMembers = new JLabel("Members:");
		lbMembers.setBounds(10, 78, 65, 14);
		lbMembers.setFocusable(false);
		groupCard.add(lbMembers);
		
		JLabel lbCountry = new JLabel("Country: ");
		lbCountry.setBounds(10, 112, 50, 20);
		lbCountry.setFocusable(false);
		groupCard.add(lbCountry);	
		
		
		JTextArea txtgrpMembers = new JTextArea();
		txtgrpMembers.setColumns(10);
		txtgrpMembers.setBounds(70, 75, 250, 20);
		txtgrpMembers.setBackground(new Color(240,240,240));
		txtgrpMembers.setLineWrap(true);
		txtgrpMembers.setFocusable(false);
		txtgrpMembers.setEditable(false);	
		
		for (AppUser member : this.members) {
			txtgrpMembers.append(member.getUsername() + " ");
		}
	
		groupCard.add(txtgrpMembers);		
		JTextArea txtgrpCountry = new JTextArea();
		txtgrpCountry.setColumns(10);
		txtgrpCountry.setText(this.Country);
		txtgrpCountry.setBackground(new Color(240,240,240));
		txtgrpCountry.setBounds(70, 112, 86, 20);
		txtgrpCountry.setEditable(false);
		txtgrpCountry.setFocusable(false);		
		groupCard.add(txtgrpCountry);			
		groups.add(this);
	}
	/**
	 * Adds the user to the members of the group
	 * @param toBeAdded
	 */
	public void addUser (AppUser toBeAdded) {
		if (!this.members.contains(toBeAdded)) {
			this.members.add(toBeAdded);
		}
	}
	/**
	 * Removes the user from members of the group.
	 * @param toBeRemoved
	 */
	public void removeUser(AppUser toBeRemoved) {
		if (this.members.contains(toBeRemoved) && !toBeRemoved.equals(creator)) {
			this.members.remove(toBeRemoved);
		}
	}

	
	//Below here are getter&setters. 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getCommonHobbies() {
		return commonHobbies;
	}

	public void setCommonHobbies(String commonHobbies) {
		this.commonHobbies = commonHobbies;
	}

	public AppUser getCreator() {
		return creator;
	}

	public void setCreator(AppUser creator) {
		this.creator = creator;
	}

	public ArrayList<AppUser> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<AppUser> members) {
		this.members = members;
	}



	public JPanel getGroupCard() {
		return groupCard;
	}

	public void setGroupCard(JPanel groupCard) {
		this.groupCard = groupCard;
	}

	public static ArrayList<AppGroup> getGroups() {
		return groups;
	}

	public static void setGroups(ArrayList<AppGroup> groups) {
		AppGroup.groups = groups;
	}

	public HashMap<AppUser, postContentPanel> getContents() {
		return contents;
	}

	public void setContents(HashMap<AppUser, postContentPanel> contents) {
		this.contents = contents;
	}

}
