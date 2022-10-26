package frames;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import project.AppGroup;
import project.AppUser;

import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;

public class groupFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfSearch;
	private JTextField tfRemoveUser;
	

	/**
	 * According to the given group it creates the frame and sets up the info, viewer also makes the contents visible or invisible depending on its membership of the group.
	 * @param group
	 * @param viewer
	 */
	public groupFrame(AppGroup group,AppUser viewer) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
	
		getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
		setResizable(false);
		setSize(1800,1000);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel groupInfoPanel = new JPanel();
		groupInfoPanel.setPreferredSize(new Dimension(100,100));
		contentPane.add(groupInfoPanel);
		groupInfoPanel.setLayout(null);
		
		JTextArea txtrGroupName = new JTextArea();
		txtrGroupName.setBackground(SystemColor.menu);
		txtrGroupName.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtrGroupName.setText("            Group ");
		txtrGroupName.setBounds(75, 22, 180, 29);
		groupInfoPanel.add(txtrGroupName);
		
		JLabel lbGroupName = new JLabel("Name: ");
		lbGroupName.setBounds(23, 87, 66, 14);
		groupInfoPanel.add(lbGroupName);
		
		JLabel lbGroupCountry = new JLabel("Country: ");
		lbGroupCountry.setBounds(23, 117, 46, 14);
		groupInfoPanel.add(lbGroupCountry);
		
		JLabel lbHobby = new JLabel("Hobbies:");
		lbHobby.setBounds(23, 151, 46, 14);
		groupInfoPanel.add(lbHobby);
		
		JLabel lbCreator = new JLabel("Creator:");
		lbCreator.setBounds(23, 181, 46, 14);
		groupInfoPanel.add(lbCreator);
		
		JButton jbJoin = new JButton("Join");
		jbJoin.setBounds(10, 234, 109, 23);
		groupInfoPanel.add(jbJoin);
		
		JButton jbLeave = new JButton("Leave");
		
		jbLeave.setBounds(10, 306, 109, 23);
		groupInfoPanel.add(jbLeave);
		
		JButton jbDeleteGroup = new JButton("Delete Group");
		jbDeleteGroup.addActionListener(new ActionListener() {
			
			
			 //Allows creator to delete the group, erases every user from group and removes group from the users arraylist
			public void actionPerformed(ActionEvent e) {
		 
				for (AppUser user : group.getMembers()) {
					user.getGroups().remove(group);
					
				}
				
				AppGroup.groups.remove(group);
				
				((JFrame) jbDeleteGroup.getTopLevelAncestor()).dispose();
            	mainPageFrame mainn = new mainPageFrame(viewer);
            	mainn.setVisible(true);
				
				
			}
		});
		jbDeleteGroup.setBounds(10, 380, 109, 23);
		groupInfoPanel.add(jbDeleteGroup);
		
		JButton jbPost = new JButton("Create Post");
		jbPost.addActionListener(new ActionListener() {
			
			  // Post Button asks an option to post an image, creates the content with given title and post, and the optional image
			 
			public void actionPerformed(ActionEvent e) {
				
				((JFrame) jbPost.getTopLevelAncestor()).dispose();
				   JFrame createPostFrame = new JFrame();
			        createPostFrame.setResizable(false);
			        createPostFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        createPostFrame.setSize(1800,1000);
			        JPanel contentPane = new JPanel();
			  		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			  		createPostFrame.setContentPane(contentPane);
			  		contentPane.setLayout(null);
			  		
			  		JTextField tfTitle = new JTextField();
			  		tfTitle.setBounds(670, 331, 240, 20);
			  		contentPane.add(tfTitle);
			  		tfTitle.setColumns(10);
			  		
			  		JTextField tfPost = new JTextField();
			  		tfPost.setBounds(670, 386, 240, 20);
			  		contentPane.add(tfPost);
			  		tfPost.setColumns(10);
			  		
			  		JTextArea txtrTypeInYour = new JTextArea();
			  		txtrTypeInYour.setFont(new Font("Times New Roman", Font.BOLD, 14));
			  		txtrTypeInYour.setText("Type in your title:");
			  		txtrTypeInYour.setBackground(SystemColor.menu);
			  		txtrTypeInYour.setBounds(670, 301, 118, 19);
			  		contentPane.add(txtrTypeInYour);
			  		
			  		JTextArea textArea_2 = new JTextArea();
			  		textArea_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
			  		textArea_2.setText("Type in your post:");
			  		textArea_2.setBackground(SystemColor.menu);
			  		textArea_2.setBounds(670, 362, 160, 19);
			  		contentPane.add(textArea_2);
			  		
			  		JTextArea txtrCreatingAPost = new JTextArea();
			  		txtrCreatingAPost.setFont(new Font("Times New Roman", Font.BOLD, 38));
			  		txtrCreatingAPost.setText("              Creating a Post");
			  		txtrCreatingAPost.setBackground(SystemColor.menu);
			  		txtrCreatingAPost.setBounds(520, 176, 553, 57);
			  		contentPane.add(txtrCreatingAPost);
			
			  		// An OptionPane is created to ask the option to add an image, depending on the (int) response an JFileChooser appears.
				int res = JOptionPane.showConfirmDialog(null,"Do you want to add an image?","Image Option",JOptionPane.YES_NO_OPTION);
				
				if (res == 0) {
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg","png");
			        fileChooser.addChoosableFileFilter(filter);
			        int response = fileChooser.showSaveDialog(null);
			        if(response == JFileChooser.APPROVE_OPTION){
			          File selFile = fileChooser.getSelectedFile();
			          
			          Image image = new ImageIcon(selFile.getAbsolutePath()).getImage();
			          Image image1 = image.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
			          ImageIcon image11 = new ImageIcon(image1);
			          viewer.setPostCreateIconTemp(image11);					
				} 
			        }
			        
			        JButton btCreatePost = new JButton("Create Post");
			  		btCreatePost.setBounds(806, 429, 118, 23);
			  		contentPane.add(btCreatePost);
			      createPostFrame.setVisible(true);
			      
			      btCreatePost.addActionListener(new ActionListener() {
			    	
						public void actionPerformed(ActionEvent e) {
							 
							  // A frame is generated to ask for post title and text, then it is created depending on the image option, according to the response of askOptionPane
							  
							String post1 = tfPost.getText();
						      String title1 = tfTitle.getText();
							if (res == 0) {
							     
								createPostFrame.setVisible(true);
								viewer.createGroupContent(group,viewer.getPostCreateIconTemp(), post1,java.time.LocalDateTime.now(), title1);
								viewer.setPostCreateIconTemp(null);
							}
							else {
								viewer.createGroupContent(group,null, post1,java.time.LocalDateTime.now(), title1);
							}
							((JFrame) btCreatePost.getTopLevelAncestor()).dispose();
							groupFrame framee = new groupFrame(group,viewer);
							framee.setVisible(true);							
						}});
		          }			
		});
		jbPost.setBounds(10, 268, 109, 23);
		groupInfoPanel.add(jbPost);
		
		
		
		JButton jbRemoveUser = new JButton("Remove User");

		
		jbRemoveUser.setBounds(10, 346, 109, 23);
		groupInfoPanel.add(jbRemoveUser);
		
		JTextArea taGroupName = new JTextArea();
		taGroupName.setBounds(75, 82, 109, 19);
		groupInfoPanel.add(taGroupName);
		taGroupName.setText(group.getName());
		
		
		JTextArea taGroupCountry = new JTextArea();
		taGroupCountry.setBounds(75, 112, 109, 19);
		taGroupCountry.setText(group.getCountry());
		groupInfoPanel.add(taGroupCountry);
		
		JTextArea taGroupHobby = new JTextArea();
		taGroupHobby.setBounds(75, 146, 109, 19);
		taGroupHobby.setText(group.getCommonHobbies());
		groupInfoPanel.add(taGroupHobby);
		
		JTextArea taGroupCreator = new JTextArea();
		taGroupCreator.setBounds(75, 176, 109, 19);
		taGroupCreator.setText(group.getCreator().getUsername());
		groupInfoPanel.add(taGroupCreator);
		
		tfSearch = new JTextField();
		tfSearch.setBounds(94, 466, 109, 20);
		groupInfoPanel.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton jbSearchForPost = new JButton("Search");
		jbSearchForPost.addActionListener(new ActionListener() {
			
			//If the textfield has a unique content title, a frame is created and the content is put in it. It also makes it invisible
			public void actionPerformed(ActionEvent e) {
				for (postContentPanel content : group.getContents().values()) {
					if (content.getTitle().contains(tfSearch.getText())) {
						JFrame frame = new JFrame();
						frame.setSize(366,600);
						frame.setResizable(false);
						frame.getContentPane().setLayout(new BorderLayout());
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.getContentPane().add(content,BorderLayout.CENTER);
						frame.setVisible(true);
					}
					
				}
			
			}
		});
		jbSearchForPost.setBounds(104, 497, 89, 23);
		groupInfoPanel.add(jbSearchForPost);
		
		JLabel lbSearchForPosts = new JLabel(" Search for Posts");
		lbSearchForPosts.setBounds(94, 441, 109, 14);
		groupInfoPanel.add(lbSearchForPosts);
		
		JButton btGoToHomepage = new JButton("Go back to Main Page");
		btGoToHomepage.addActionListener(new ActionListener() {
			
			// Closes current frame, returns viewer to its mainpage
			public void actionPerformed(ActionEvent e) {
								 				
				((JFrame) btGoToHomepage.getTopLevelAncestor()).dispose();
				mainPageFrame frame = new mainPageFrame(viewer);
				frame.setVisible(true);
			}
		});
		btGoToHomepage.setBounds(75, 551, 174, 54);
		groupInfoPanel.add(btGoToHomepage);
		
		tfRemoveUser = new JTextField();
		tfRemoveUser.setColumns(10);
		tfRemoveUser.setBounds(140, 335, 109, 20);
		groupInfoPanel.add(tfRemoveUser);
		tfRemoveUser.setVisible(false);
		JLabel lbRemoveUser = new JLabel("Which user?");
		lbRemoveUser.setBounds(158, 317, 66, 19);
		groupInfoPanel.add(lbRemoveUser);
		
		JButton jbRemoveConfirm = new JButton("Confirm");
	
		jbRemoveConfirm.setBounds(150, 363, 89, 23);
		groupInfoPanel.add(jbRemoveConfirm);
		lbRemoveUser.setVisible(false);
		jbRemoveConfirm.setVisible(false);
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		JLabel contentSign = new JLabel("Group's Content");
		contentSign.setBackground(SystemColor.menu);

		contentSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentSign.setPreferredSize(new Dimension(40, 40));
		contentPanel.add(contentSign);
		
		for (JPanel content  : group.getContents().values()) {
			
			contentPanel.add(content);
		}
		
		
		JScrollPane scrollContent = new JScrollPane();
		scrollContent.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollContent.setPreferredSize(new Dimension(450,600));
		scrollContent.setViewportView(contentPanel);
		contentPane.add(scrollContent);
		
		
		JPanel membersPanel = new JPanel();
		membersPanel.setPreferredSize(new Dimension(350,400));
		membersPanel.setLayout(new BoxLayout(membersPanel,BoxLayout.Y_AXIS));
		JLabel membersSign = new JLabel("Group's Members");
		membersSign.setBackground(SystemColor.menu);

		membersSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		membersSign.setPreferredSize(new Dimension(40, 40));
		membersPanel.add(membersSign);
		JTextArea txtBait = new JTextArea();
		txtBait.setEditable(false);
		txtBait.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtBait.setBackground(SystemColor.menu);
		
		JTextArea txtReal = new JTextArea();
		txtReal.setEditable(false);
		txtReal.setAlignmentY(1.0f);
		txtReal.setAlignmentX(1.0f);
		txtReal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txtReal.setBackground(SystemColor.menu);
		txtReal.setText("Members");
		txtReal.setPreferredSize(new Dimension(40, 40));
		
		// Users of the group is added to the membersPanel, a visit profile button is added if it does not exist
		for (AppUser member : group.getMembers()) {
			JPanel newOne = new JPanel();
			newOne = member.getPersonalCard();
			JButton btToProfile = new JButton("Visit Profile");
						
			btToProfile.setBounds(121, 55, 97, 36);
			if(member.personalCard.getComponentCount() == 2) {
				member.personalCard.add(btToProfile);
			}
			
			btToProfile.addActionListener(new ActionListener() {
				
				// The button action is set which takes us to the user's profile page, disposing the current frame as well.
				public void actionPerformed(ActionEvent e) {
					
					((JFrame) btToProfile.getTopLevelAncestor()).dispose();
					profileFrame frame = new profileFrame(viewer,member);
					frame.setVisible(true);
					
				}
			});
			
			membersPanel.add(newOne);
	
		}
		membersPanel.add(txtBait);

		
		JScrollPane scrollMembers = new JScrollPane();
		scrollMembers.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollMembers.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollMembers.setPreferredSize(new Dimension(350,400));
		scrollMembers.setViewportView(membersPanel);
		scrollMembers.setVisible(true);
		contentPane.add(scrollMembers);
		
		
		

		contentPane.add(scrollMembers);
		scrollMembers.add(txtReal);

		
		if (group.getMembers().contains(viewer) && viewer.equals(group.getCreator())) {
			
			 //If the viewer is the creator of the group
			 
			jbJoin.setVisible(false);
			
			
		}
		else if (group.getMembers().contains(viewer) && !viewer.equals(group.getCreator())) {
			
			  //If the viewer is a normal member, admin options are hidden
			 
			jbJoin.setVisible(false);
			jbRemoveUser.setVisible(false);
			jbDeleteGroup.setVisible(false);

			
		}
		
		else if (!group.getMembers().contains(viewer)) {
			
			 // If the viewer is not a member, join option is given and the content is set as invisible.
			tfSearch.setVisible(false);
			lbSearchForPosts.setVisible(false);
			jbSearchForPost.setVisible(false);
			jbLeave.setVisible(false);
			jbRemoveUser.setVisible(false);
			jbDeleteGroup.setVisible(false);
			jbPost.setVisible(false);	
			scrollContent.setVisible(false);
			scrollMembers.setVisible(false);
		}
		
		
		jbJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //Allows user to join the group, sets the previously hidden content, member list to visible. Hides itself and sets leave option visible.
				 
				group.addUser(viewer);
				viewer.getGroups().add(group);
				jbJoin.setVisible(false);
				jbPost.setVisible(true);
				jbLeave.setVisible(true);
				jbSearchForPost.setVisible(true);
				lbSearchForPosts.setVisible(true);
				tfSearch.setVisible(true);
				scrollContent.setVisible(true);
				scrollMembers.setVisible(true);
				
				groupFrame newFrame = new groupFrame(group,viewer);
				newFrame.setVisible(true);
				((JFrame) jbJoin.getTopLevelAncestor()).dispose();
				
				
				
			}
		});
		
		jbLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  //Leave button allows user to leave the group, deletes that users content.
				 
				group.getContents().values().removeAll(Collections.singleton(viewer)); // removes any content created by the user that just left 
																					   // so it removes any value with the key of that user
				group.removeUser(viewer);
				viewer.getGroups().remove(group);
				
				
				scrollContent.setVisible(false);
				jbJoin.setVisible(true);
				jbPost.setVisible(false);
				jbLeave.setVisible(false);
				jbSearchForPost.setVisible(false);
				lbSearchForPosts.setVisible(false);
				tfSearch.setVisible(false);
				scrollMembers.setVisible(false);

			}
		});
		
		jbRemoveUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// This button sets the confirmation button,textarea and textfield visible.
				 
				lbRemoveUser.setVisible(true);
				tfRemoveUser.setVisible(true);
				jbRemoveConfirm.setVisible(true);
			}
		});
		
		jbRemoveConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 // This button removes the user if the given text is equal to a nickname of a user in the group
				 
				for (AppUser user : group.getMembers()) {
					if (tfRemoveUser.getText().equals(user.getUsername())) {
						((JFrame) jbRemoveConfirm.getTopLevelAncestor()).dispose();
						user.getGroups().remove(group);
						group.getMembers().remove(user);
						groupFrame fraame = new groupFrame(group,viewer);
						fraame.setVisible(true);
						
						
					}
				}
			}
		});					
	}


	//Below here are getter&setters. 


	public JTextField getTfSearch() {
		return tfSearch;
	}


	public void setTfSearch(JTextField tfSearch) {
		this.tfSearch = tfSearch;
	}


	public JTextField getTfRemoveUser() {
		return tfRemoveUser;
	}


	public void setTfRemoveUser(JTextField tfRemoveUser) {
		this.tfRemoveUser = tfRemoveUser;
	}
	
	
	
}
