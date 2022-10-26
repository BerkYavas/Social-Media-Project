package project;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PremiumUser extends AppUser {
	public String name;
    public String surname;
    public String age;
    public String email; 
    public String username;
    public String password;
    public String accountType;
    public String country;
    public ImageIcon icon;
    public String hobby;
    
    public ArrayList<AppUser> friends;
    public ArrayList<String> hobbies;
    public JPanel personalCard;


    public ArrayList<AppUser> followers;
    public ArrayList<AppUser> followed;
    
    /**
     * Sets up a user with the parameters. Creates a personalCard that is a JPanel.
     * @param username
     * @param password
     * @param name
     * @param surname
     * @param country
     * @param age
     * @param hobby
     * @param icon
     */
    public PremiumUser(String username, String password,String name, String surname,String country,String age,String hobby,ImageIcon icon) {
    	super(username,password,name,surname,country,age,hobby,icon);
    	this.username = username;
    	this.password = password;
    	this.name = name;
    	this.surname = surname;
    	this.country = country;
    	this.accountType = "Premium";
    	this.icon = icon;
    	this.age = age;

    	followers = new ArrayList<AppUser>();
    	followed = new ArrayList<AppUser>();

    	
    	AppUser.users.add(this);
        AppUser.nameAndPasswords.put(this.username,this.password);
        
        //personald card is creates that will displat the info of the PremiumUser
        personalCard = new JPanel();
    		JLabel usericon = new JLabel("");
    		usericon.setLocation(21, 22);
    		usericon.setIcon(this.icon);
    		usericon.setSize(50,50);
    		
    		personalCard.add(usericon);
    		
    		JTextArea txtUsername = new JTextArea();
    		txtUsername.setBounds(10, 83, 85, 22);
    		txtUsername.setText(this.getUsername());
    		personalCard.add(txtUsername);

    }

}
