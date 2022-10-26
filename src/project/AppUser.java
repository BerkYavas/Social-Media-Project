package project;

import javax.swing.*;
import frames.postContentPanel;


import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class AppUser {
    public static HashMap<String,String> nameAndPasswords = new HashMap<String,String>();
    public static ArrayList<AppUser> users = new ArrayList<AppUser>();;
    
    private String name;
    private String surname;
    private String age;
    private String email; 
    private String username;
    private String password;
    private String accountType;
    private String country;
    private ImageIcon icon;
    private String hobby;
    private ImageIcon postCreateIconTemp;
    private ArrayList<AppGroup> groups;

    private ArrayList<postContentPanel> contents;
    
    public JPanel personalCard;
    public ArrayList<AppUser> followers;
    public ArrayList<AppUser> followed;

    /**
     * Creates a user with the given parameters, creates a JPanel that is the personalCard of the User that will be displayed in the pages.
     * @param username
     * @param password
     * @param name
     * @param surname
     * @param country
     * @param age
     * @param hobby
     * @param icon
     */
    public AppUser(String username, String password,String name, String surname,String country,String age,String hobby,ImageIcon icon) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.age = age;
        this.icon = icon;
        this.hobby = hobby;
        this.postCreateIconTemp = null;
        
        contents = new ArrayList<postContentPanel>();
        followers = new ArrayList<AppUser>();
        followed = new ArrayList<AppUser>();
        groups = new ArrayList<AppGroup>();

        

        users.add(this);
        AppUser.nameAndPasswords.put(this.username,this.password);
     
        if (this.icon == null) {
        	// if a profile picture is not given a default picture is assigned.
        	Image profile = new ImageIcon(this.getClass().getResource("/defaultprofile.png")).getImage();
            Image newImage = profile.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        	this.icon = new ImageIcon(newImage);
        	
        }
        
        if (this instanceof PremiumUser) {
        	// Premium-Standart User differentiation
        	this.accountType = "Premium";
         								}
        else {
        this.accountType = "Standart"; }
        
        // personal card created which is a JPanel
        personalCard = new JPanel();
		JLabel usericon = new JLabel("");
		usericon.setLocation(21, 22);
		usericon.setIcon(this.icon);
		usericon.setSize(50,50);
		
		personalCard.add(usericon);
		
		JTextArea txtUsername = new JTextArea();
		txtUsername.setBounds(10, 83, 85, 22);
		txtUsername.setText(this.getUsername());
		txtUsername.setEditable(false);
		personalCard.add(txtUsername);
		
		


    
    }
    /**
     * Changes the information of the user with the given parameters except username, is called from EditProfileFrame.
     * @param password
     * @param name
     * @param surname
     * @param newAge
     * @param email
     * @param country
     */
    public void makeChanges(String password,String name, String surname,String newAge,String email,String country) {
    	
        this.password = password;
        this.age = newAge;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.country = country;
        

        AppUser.nameAndPasswords.remove(this.username);
        AppUser.nameAndPasswords.put(this.username,this.password);        
    	
    }
    /**
     * Returns the index of the user in class static variable users. Allows us to access the object user with its username from other classes.
     * @param username
     * @return
     */
	public static int getUserIndexByUsername(String username) {
		for (int i = 0; i<users.size(); i++) {
			if (users.get(i).getUsername().equals(username)) {
				return i;
			}
		}
		return -1;
	}
	/**
	 * Adds the given user as a follower, also updates the list that stores the users that parameter user follows, in this case adds itself.
	 * @param otherUser
	 */
	public void addFollower(AppUser otherUser) {
		if (!this.followers.contains(otherUser)) {
		this.getFollowers().add(otherUser);
		otherUser.getFollowed().add(this);
		}
	}
	/**
	 * Removes the given user from followers, also updates the list that stores the users that parameter user follows, in this case removes itself.
	 * @param otherUser
	 */
	public void removeFollower (AppUser otherUser) {
		if (this.followers.contains(otherUser)) {
			this.followers.remove(otherUser);
			otherUser.getFollowed().remove(this);		}
	}
	
	/**
	 * Creates content for a group with the given paramters. Creates the post panel in the function itself.
	 * @param group
	 * @param post
	 * @param postText
	 * @param dt
	 * @param title
	 * @return
	 */
	public JPanel createGroupContent(AppGroup group,ImageIcon post,String postText,LocalDateTime dt,String title) {
		
		postContentPanel toReturn = new postContentPanel(this,post,postText,dt,title);
		group.getContents().put(this, toReturn);
		return toReturn;
		
	}
	

	
	/**
	 * Creates content for the user's profile page and its followers with the given parameter. Content JPanel is created and modified inside the function.
	 * @param post
	 * @param postText
	 * @param dt
	 * @param title
	 * @return
	 */
	public JPanel createContent(ImageIcon post,String postText,LocalDateTime dt,String title) {
		
		postContentPanel newOne = new postContentPanel(this,post,postText,dt,title);

		this.contents.add(newOne);

		
		return newOne;

	}
	
	//Below here are getter&setters. 
    public JPanel getPersonalCard() {
		return personalCard;
	}

	public void setPersonalCard(JPanel personalCard) {
		this.personalCard = personalCard;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
    
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static HashMap<String, String> getNameAndPasswords() {
		return nameAndPasswords;
	}

	public static void setNameAndPasswords(HashMap<String, String> nameAndPasswords) {
		AppUser.nameAndPasswords = nameAndPasswords;
	}

	public static ArrayList<AppUser> getUsers() {
		return users;
	}

	public static void setUsers(ArrayList<AppUser> users) {
		AppUser.users = users;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
		
	}

	public ImageIcon getPostCreateIconTemp() {
		return postCreateIconTemp;
	}

	public void setPostCreateIconTemp(ImageIcon postCreateIconTemp) {
		this.postCreateIconTemp = postCreateIconTemp;
	}

	public ArrayList<AppUser> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<AppUser> followers) {
		this.followers = followers;
	}

	public ArrayList<AppUser> getFollowed() {
		return followed;
	}

	public void setFollowed(ArrayList<AppUser> followed) {
		this.followed = followed;
	}
	

	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public ArrayList<postContentPanel> getContents() {
		return contents;
	}


	public void setContents(ArrayList<postContentPanel> contents) {
		this.contents = contents;
	}

	public ArrayList<AppGroup> getGroups() {
		return groups;
	}

	public void setGroups(ArrayList<AppGroup> groups) {
		this.groups = groups;
	}
	

}


  

