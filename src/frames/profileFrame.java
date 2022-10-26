package frames;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import project.AppGroup;
import project.AppUser;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;

public class profileFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfDelUsername;
	private JPasswordField pfDelPF;
	private JTextField tfSearchForPosts;
	
	/**
	 * Creates a profile frame of the owner, depending on the viewer that was referred to the page by another frame.
	 * @param viewer
	 * @param owner
	 */
	public profileFrame(AppUser viewer , AppUser owner) {
		
		getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1800,1000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JPanel userInfoPanel = new JPanel();
		userInfoPanel.setPreferredSize(new Dimension(100,100));
		
		JLabel usericon = new JLabel();
		usericon.setBounds(10, 95, 77, 77);
		usericon.setPreferredSize(new Dimension(30,30));
		usericon.setIcon(owner.getIcon());
		
		JTextArea username = new JTextArea();
		username.setEditable(false);
		username.setBounds(53, 62, 77, 22);
		username.setText(owner.getUsername());
		
		
		JButton jbEditProfile = new JButton();
		jbEditProfile.addActionListener(new ActionListener() {
			
			// If the viewer is the owner of the profile page this button is visible.
			// Disposes the current frame, creates a editProfileFrame that its viewer is the current viewer/owner
			public void actionPerformed(ActionEvent e) {
				EditProfileFrame frame = new EditProfileFrame();
				frame.setVisible(true);
        		((JFrame) jbEditProfile.getTopLevelAncestor()).dispose();
			}
		});
		jbEditProfile.setBounds(31, 344, 124, 20);
		jbEditProfile.setText("Edit Profile");
		jbEditProfile.setPreferredSize(new Dimension(100, 20));
		
		JButton jbLogOut = new JButton();
		jbLogOut.addActionListener(new ActionListener() {
			
			// If the viewer is the owner of the profile page, user can log out. A log in frame is called and the current frame disposes itself.
			public void actionPerformed(ActionEvent e) {
				
        		((JFrame) jbEditProfile.getTopLevelAncestor()).dispose();
        		LogInFrame newOne = new LogInFrame();
        		newOne.setVisible(true);
			}
		});
		jbLogOut.setBounds(31, 406, 124, 20);
		jbLogOut.setText("Logout");
		jbLogOut.setPreferredSize(new Dimension(100, 20));
		
		JButton jbDeleteAcc = new JButton();
		
		jbDeleteAcc.setBounds(31, 375, 124, 20);
		jbDeleteAcc.setText("Delete Account");
		jbDeleteAcc.setPreferredSize(new Dimension(120, 20));
		
		JButton jbCreatePost = new JButton();
		jbCreatePost.addActionListener(new ActionListener() {
			
			// If the viewer is also owner of the profileFrame, it can create posts, an optionPane pops up to ask for an option to add image. 
			// Can choose file from the computer and create the post for the user with another frame that asks for posttext and title.
			public void actionPerformed(ActionEvent e) {

				((JFrame) jbCreatePost.getTopLevelAncestor()).dispose();
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
			
				int res = JOptionPane.showConfirmDialog(null,"Do you want to add an image?","Image Option",JOptionPane.YES_NO_OPTION); //optionPane created whether user wants to add an image to a post or not
				
				// optionPaneResponse
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
			          owner.setPostCreateIconTemp(image11);					
				} 
			        }
			        
			        JButton btCreatePost = new JButton("Create Post");
			  		btCreatePost.setBounds(806, 429, 118, 23);
			  		contentPane.add(btCreatePost);
			      createPostFrame.setVisible(true);
			      
			      btCreatePost.addActionListener(new ActionListener() {
			    	  
			    	  // The final button that creates the post returns user to its own profile.
						public void actionPerformed(ActionEvent e) {
							String post1 = tfPost.getText();
						      String title1 = tfTitle.getText();
							if (res == 0) {
							     
								createPostFrame.setVisible(true);
								owner.createContent(owner.getPostCreateIconTemp(), post1,java.time.LocalDateTime.now(), title1);
								owner.setPostCreateIconTemp(null);
							}
							else {
								owner.createContent(null, post1,java.time.LocalDateTime.now(), title1);
							}
							((JFrame) btCreatePost.getTopLevelAncestor()).dispose();
							profileFrame framee = new profileFrame(owner,owner);
							framee.setVisible(true);							
						}});
		          }			
		});
		jbCreatePost.setBounds(31, 313, 124, 20);
		jbCreatePost.setText("Create a Post");
		jbCreatePost.setPreferredSize(new Dimension(100, 20));
		userInfoPanel.setLayout(null);

		userInfoPanel.add(username);
		userInfoPanel.add(usericon);
		userInfoPanel.add(jbCreatePost);

		userInfoPanel.add(jbEditProfile);
		userInfoPanel.add(jbLogOut);
		userInfoPanel.add(jbDeleteAcc);
	
		contentPane.add(userInfoPanel);
		
		JLabel lbDelUsername = new JLabel("username");
		lbDelUsername.setBounds(31, 437, 77, 14);
		userInfoPanel.add(lbDelUsername);
		lbDelUsername.setVisible(false);
		
		tfDelUsername = new JTextField();
		tfDelUsername.setBounds(31, 457, 99, 20);
		userInfoPanel.add(tfDelUsername);
		tfDelUsername.setVisible(false);
		tfDelUsername.setColumns(10);
		
		JLabel lbDelPassword = new JLabel("password");
		lbDelPassword.setBounds(31, 488, 77, 14);
		lbDelPassword.setVisible(false);
		userInfoPanel.add(lbDelPassword);
		
		pfDelPF = new JPasswordField();
		pfDelPF.setBounds(31, 513, 99, 20);
		userInfoPanel.add(pfDelPF);
		pfDelPF.setVisible(false);
		
		JButton jbConfirmDel = new JButton("Delete Account");
		jbConfirmDel.addActionListener(new ActionListener() {
			
			// If the user viewing its own profile, this button Confirms the deletion of the account by checking the username and password.
			// Opens up a logInFrame and disposes the current frame 
			public void actionPerformed(ActionEvent e) {
							
				String inputUserName = tfDelUsername.getText();
                String inputPassWord = String.valueOf(pfDelPF.getPassword());

                if (AppUser.getNameAndPasswords().containsKey(inputUserName)) {
                    if(AppUser.getNameAndPasswords().get(inputUserName).equals(inputPassWord)) {
                    	
                    	AppUser.users.remove(AppUser.getUserIndexByUsername(inputUserName));
                    	AppUser.nameAndPasswords.remove(inputUserName);
                    	LogInFrame frame = new LogInFrame();
                    	((JFrame) jbConfirmDel.getTopLevelAncestor()).dispose();
                    	frame.setVisible(true);
			}
                }}});
				
		jbConfirmDel.setBounds(31, 544, 120, 23);
		jbConfirmDel.setVisible(false);
		userInfoPanel.add(jbConfirmDel);
		
		JButton btFollow = new JButton("Follow");
		
		btFollow.setBounds(95, 101, 89, 23);
		userInfoPanel.add(btFollow);
		
		JButton btUnfollow = new JButton("Unfollow");
		
		btUnfollow.setBounds(95, 135, 89, 23);
		userInfoPanel.add(btUnfollow);
		
		JLabel lbAge = new JLabel("Age:");
		lbAge.setBounds(10, 263, 46, 14);
		userInfoPanel.add(lbAge);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setBounds(10, 188, 46, 14);
		userInfoPanel.add(lbName);
		
		JLabel lbSurname = new JLabel("Surname:");
		lbSurname.setBounds(10, 213, 46, 14);
		userInfoPanel.add(lbSurname);
		
		JLabel lbcountry = new JLabel("Country:");
		lbcountry.setBounds(10, 238, 46, 14);
		userInfoPanel.add(lbcountry);
		
		JTextArea txtName = new JTextArea();
		txtName.setEditable(false);
		txtName.setBackground(SystemColor.text);
		txtName.setBounds(66, 183, 89, 19);
		txtName.setText(owner.getName());
		userInfoPanel.add(txtName);
		
		JTextArea txtSurname = new JTextArea();
		txtSurname.setEditable(false);
		txtSurname.setBackground(SystemColor.text);
		txtSurname.setBounds(66, 208, 89, 19);
		txtSurname.setText(owner.getSurname());
		userInfoPanel.add(txtSurname);
		JTextArea txtCountry = new JTextArea();
		txtCountry.setEditable(false);
		txtCountry.setBackground(SystemColor.text);
		txtCountry.setBounds(66, 233, 89, 19);
		txtCountry.setText(owner.getCountry());
		userInfoPanel.add(txtCountry);
		
		JTextArea txtAge = new JTextArea();
		txtAge.setEditable(false);
		txtAge.setBackground(SystemColor.text);
		txtAge.setBounds(66, 258, 89, 19);
		txtAge.setText(owner.getAge());

		userInfoPanel.add(txtAge);
		
		JLabel lbHobby = new JLabel("Hobby:");
		lbHobby.setBounds(10, 288, 46, 14);
		
		userInfoPanel.add(lbHobby);
		
		JTextArea txtHobby = new JTextArea();
		txtHobby.setEditable(false);
		txtHobby.setBackground(Color.WHITE);
		txtHobby.setBounds(66, 283, 89, 19);
		txtHobby.setText(owner.getHobby());
		userInfoPanel.add(txtHobby);
		
		JButton btGoToHomepage = new JButton("Go back to Main Page");
		btGoToHomepage.addActionListener(new ActionListener() {
			
			// returns user to its own mainpage whether it is the owner, a visitor or a follower. Disposes the current frame.
			public void actionPerformed(ActionEvent e) {
				
            	((JFrame) jbConfirmDel.getTopLevelAncestor()).dispose();
            	mainPageFrame mainn = new mainPageFrame(viewer);
            	mainn.setVisible(true);
			}
		});
		btGoToHomepage.setBounds(0, 855, 165, 38);
		userInfoPanel.add(btGoToHomepage);
		
		JTextArea txtUserType = new JTextArea();
		txtUserType.setEditable(false);
		txtUserType.setBounds(43, 11, 99, 22);
		txtUserType.setText(owner.getAccountType());
		userInfoPanel.add(txtUserType);
		
		JLabel lbSearchForPosts = new JLabel("   Search for Posts");
		lbSearchForPosts.setBounds(34, 618, 121, 14);
		userInfoPanel.add(lbSearchForPosts);
		
		tfSearchForPosts = new JTextField();
		tfSearchForPosts.setBounds(31, 643, 124, 20);
		userInfoPanel.add(tfSearchForPosts);
		tfSearchForPosts.setColumns(10);
		

		JButton btSearch = new JButton("Search");
		btSearch.setBounds(43, 674, 99, 23);
		userInfoPanel.add(btSearch);
		
		JButton btCreateGroup = new JButton("Create a Group");
		btCreateGroup.addActionListener(new ActionListener() {
			
			// if the user is a premium and owner of the profile is equal to the viewer, disposes current frame and pops up a createGroupFrame
			public void actionPerformed(ActionEvent e) {
				CreateGroupFrame frame = new CreateGroupFrame(viewer);
				
				frame.setVisible(true);
				((JFrame) btCreateGroup.getTopLevelAncestor()).dispose();
				
			}
		});
		btCreateGroup.setBounds(20, 821, 124, 23);
		btCreateGroup.setVisible(false);
		userInfoPanel.add(btCreateGroup);
		
		JButton jbEditPosts = new JButton("Edit it");
		jbEditPosts.addActionListener(new ActionListener() {
			
			// If the given text is *equal* to any title of a post, a edit content frame is created and current frame is disposed. 
			public void actionPerformed(ActionEvent e) {
				for (postContentPanel content : owner.getContents()) {
					if (content.getTitle().equals(tfSearchForPosts.getText())) {
						((JFrame) jbEditPosts.getTopLevelAncestor()).dispose();
						JFrame frame = new JFrame();
						frame.setResizable(false);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.setBounds(100, 100, 450, 300);
						frame.setSize(1400,1000);
						frame.setVisible(true);
						
						contentPane = new JPanel();
						contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
						frame.setContentPane(contentPane);
						contentPane.setLayout(null);
						
						JButton btKeepImage = new JButton("Keep Image");
						
						btKeepImage.setBounds(750, 665, 125, 23);                                       	
						contentPane.add(btKeepImage);													
																									
						JTextField tfTitle = new JTextField();
						tfTitle.setText(content.getTitle());
						tfTitle.setBounds(429, 508, 364, 20);
						contentPane.add(tfTitle);
						tfTitle.setColumns(10);
						
						JTextField tfPost = new JTextField();
						tfPost.setText(content.getPostText());
						tfPost.setBounds(429, 564, 467, 69);
						contentPane.add(tfPost);
						tfPost.setColumns(10);
						
						JLabel lblNewLabel = new JLabel("Your post");
						lblNewLabel.setBounds(429, 539, 185, 14);
						contentPane.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel("Your Title");
						lblNewLabel_1.setBounds(429, 479, 150, 14);
						contentPane.add(lblNewLabel_1);
						
						JLabel lblNewLabel_2 = new JLabel("                        Editing a Post");
						lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 26));
						lblNewLabel_2.setBounds(407, 284, 489, 76);
						contentPane.add(lblNewLabel_2);
						
						JButton jbImage = new JButton("Change Image");
						
						jbImage.setBounds(597, 665, 125, 23);
						contentPane.add(jbImage);
						
						JButton delImage = new JButton ("Delete Image");
						delImage.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
						delImage.setBounds(445, 665, 125, 23);
						contentPane.add(delImage);
						
						
						btKeepImage.addActionListener(new ActionListener() {
							
							// Keeps the image, only changes post,title.
							public void actionPerformed(ActionEvent e) {
								owner.createContent(content.getPost(), tfPost.getText(), java.time.LocalDateTime.now(), tfTitle.getText());
								owner.getContents().remove(content);
								
								((JFrame) btKeepImage.getTopLevelAncestor()).dispose();
								profileFrame newOne = new profileFrame(owner,owner);
								newOne.setVisible(true);
							}
						});
						
						delImage.addActionListener(new ActionListener() {
							
							// deletes image and changes the post,title
							public void actionPerformed(ActionEvent e) {
								owner.createContent(null, tfPost.getText(), java.time.LocalDateTime.now(), tfTitle.getText());
								owner.getContents().remove(content);
								((JFrame) delImage.getTopLevelAncestor()).dispose();
								profileFrame newOne = new profileFrame(owner,owner);
								newOne.setVisible(true);

							}
						});
						
						jbImage.addActionListener(new ActionListener() {
							
							// using optionPane and JFileChooser a image is chosen, the image,post,title are all changed.
							public void actionPerformed(ActionEvent e) {
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
							          owner.getContents().remove(content);
							          owner.createContent(image11, tfPost.getText(),java.time.LocalDateTime.now() , tfTitle.getText());
							          
								} 
							        }
								
								else {
									owner.createContent(content.getPost(), tfPost.getText(), java.time.LocalDateTime.now(), tfTitle.getText());
									owner.getContents().remove(content);
									
								}
								
								((JFrame) jbImage.getTopLevelAncestor()).dispose();
								profileFrame newOne = new profileFrame(owner,owner);
								newOne.setVisible(true);																
							}
						});
						
					}
				}
			}
		});
		
		jbEditPosts.setBounds(43, 714, 99, 23);
		userInfoPanel.add(jbEditPosts);
		btSearch.addActionListener(new ActionListener() {
			
			// Users can search posts by title. Checks whether the given text matches a title, pops up a new frame displaying the asked post if it is correct.
			public void actionPerformed(ActionEvent e) {
				for (postContentPanel content : owner.getContents()) {
					String search = tfSearchForPosts.getText();
					if (content.getTitle().contains(search)) {
						JFrame frame = new JFrame();
						frame.setSize(366,600);
						frame.setResizable(false);
						frame.getContentPane().setLayout(new BorderLayout());
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						frame.getContentPane().add(content,BorderLayout.CENTER);
						frame.setVisible(true);
				} }
								
			}
		}); 
		
		jbDeleteAcc.addActionListener(new ActionListener() {
			
			// Asks for username and password confirmation to delete account. Sets the components visible.
			public void actionPerformed(ActionEvent e) {
				lbDelUsername.setVisible(true);
				lbDelPassword.setVisible(true);
				jbConfirmDel.setVisible(true);
				tfDelUsername.setVisible(true);
				pfDelPF.setVisible(true);				
			}
		});
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		
		// contents of the owner is set up here
		for (JPanel post : owner.getContents()) {
			JButton jbdelete = new JButton();
			jbdelete.addActionListener(new ActionListener() {				
				
				// Deletes the selected content
				public void actionPerformed(ActionEvent e) {
					owner.getContents().remove(jbdelete.getParent());
                	((JFrame) jbdelete.getTopLevelAncestor()).dispose();
                	profileFrame framme = new profileFrame(owner,owner);
                	framme.setVisible(true);
				}
			});
			jbdelete.setBounds(350,200,130,20);
			post.add(jbdelete);
			if (!viewer.equals(owner)) {
				jbdelete.setVisible(false);
				
			} 
			else {
				jbdelete.setVisible(true);

			}
			jbdelete.setText("Delete Post");
			contentPanel.add(post);
		}
		
		JScrollPane scrollContent = new JScrollPane();
		scrollContent.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollContent.setPreferredSize(new Dimension(450,600));
		scrollContent.setViewportView(contentPanel);
		contentPane.add(scrollContent);
			
		JPanel friendsPanel = new JPanel();
		friendsPanel.setLayout(new BoxLayout(friendsPanel,BoxLayout.Y_AXIS));
		friendsPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		JLabel friendsSign = new JLabel("Suggested Users");
		friendsSign.setBackground(SystemColor.menu);

		friendsSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		friendsSign.setPreferredSize(new Dimension(40, 40));
		friendsPanel.add(friendsSign);


		
		for (AppUser user : AppUser.users) {
			
			// Suggests user with similar hobbies, same country and <=5 age difference. Adds their personalCards to the panel.
			if (owner.getFollowed().contains(user) == false && owner.equals(user) == false ) {
				if ( owner.getHobby().equals(user.getHobby())||
					Math.abs(Integer.parseInt(owner.getAge())- Integer.parseInt(user.getAge())) <= 5||
					owner.getCountry().equals(user.getCountry())) {
					JPanel newOne = new JPanel();
					newOne = user.getPersonalCard();
					JButton btToProfile = new JButton("Visit Profile");
								
					btToProfile.setBounds(121, 55, 97, 36);
					if(user.personalCard.getComponentCount() == 2) {
						user.personalCard.add(btToProfile);
					}					
					btToProfile.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							((JFrame) btToProfile.getTopLevelAncestor()).dispose();
							profileFrame frame = new profileFrame(viewer,user);
							frame.setVisible(true);
						}
					});
					
					friendsPanel.add(newOne);
				}				
			}     
		}		
		
		JScrollPane scrollFriends = new JScrollPane();
		scrollFriends.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollFriends.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollFriends.setPreferredSize(new Dimension(300,500));
		scrollFriends.setViewportView(friendsPanel);
		scrollFriends.setVisible(true);
		contentPane.add(scrollFriends);			
		
		JPanel groupsPanel = new JPanel();
		groupsPanel.setLayout(new BoxLayout(groupsPanel,BoxLayout.Y_AXIS));
		JLabel groupSign = new JLabel("User's Groups");
		groupSign.setBackground(SystemColor.menu);

		groupSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		groupSign.setPreferredSize(new Dimension(40, 40));
		groupsPanel.add(groupSign);

		
		// Displays the groups the user is in.
		for (project.AppGroup group : owner.getGroups()) {
			JPanel newOne = group.getGroupCard();
			JButton btToGroup = new JButton("Visit Group");
			btToGroup.setBounds(211, 27, 118, 40);
			if(group.getGroupCard().getComponentCount() == 6) {
				group.getGroupCard().add(btToGroup);
			}
			btToGroup.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					((JFrame) btToGroup.getTopLevelAncestor()).dispose();
					groupFrame frame = new groupFrame(group,viewer);
					frame.setVisible(true);
					
				}
			});
			groupsPanel.add(newOne);
		}

		JScrollPane scrollGroups = new JScrollPane();
		scrollGroups.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollGroups.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollGroups.setPreferredSize(new Dimension(300,400));
		scrollGroups.setViewportView(groupsPanel);
		contentPane.add(scrollGroups);
		
		JPanel suggestGroupsPanel = new JPanel();
		suggestGroupsPanel.setLayout(new BoxLayout(suggestGroupsPanel,BoxLayout.Y_AXIS));
		JLabel groupContentSign = new JLabel("Suggested Groups");
		groupContentSign.setBackground(SystemColor.menu);

		groupContentSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		groupContentSign.setPreferredSize(new Dimension(40, 40));
		suggestGroupsPanel.add(groupContentSign);

		
		// Checks the hobbies and countries of different groups to suggest for the user if the viewer is the owner of the profile frame.
		for (AppGroup group : AppGroup.groups) {
			if (!group.getMembers().contains(owner)) {
				
				if ( group.getMembers().contains(owner) == false && ( group.getCommonHobbies().equals(owner.getHobby())  || group.getCountry().equals(owner.getCountry())       ) ) {
					
					JButton btTo2Group = new JButton("Visit Group");
					btTo2Group.setBounds(211, 27, 118, 40);
					if(group.getGroupCard().getComponentCount() == 6) {
						group.getGroupCard().add(btTo2Group);
					}
					
					btTo2Group.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							((JFrame) btTo2Group.getTopLevelAncestor()).dispose();
							groupFrame frame = new groupFrame(group,viewer);
							frame.setVisible(true);							
						}
					});					
					suggestGroupsPanel.add(group.getGroupCard());
				}					
			}			
		}
		
		JScrollPane scrollSuggestGroups = new JScrollPane();

		scrollSuggestGroups.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollSuggestGroups.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollSuggestGroups.setPreferredSize(new Dimension(300,400));
		scrollSuggestGroups.setViewportView(suggestGroupsPanel);
		contentPane.add(scrollSuggestGroups);
		
		
		// if the viewer is the owner of the profile frame follow and unfollow options are set to invisible.
		// Depending on the account type, group opening option is shown.		
		if (owner.equals(viewer)) {

			if (viewer.getAccountType().equals("Premium")) {
				btCreateGroup.setVisible(true);
			}
			btUnfollow.setVisible(false);
			btFollow.setVisible(false);			
		}

		// A visitor that also follows the user. Account modification components are set to invisible.
		// An option to unfollow is given, content is shown as it follows the owner.
		else if (owner.getFollowers().contains(viewer)) {

			jbDeleteAcc.setVisible(false);
			jbCreatePost.setVisible(false);
			jbLogOut.setVisible(false);
			jbEditProfile.setVisible(false);
			btFollow.setVisible(false);
			scrollFriends.setVisible(false);
			scrollGroups.setVisible(true);
			scrollSuggestGroups.setVisible(false);
			
			lbSearchForPosts.setVisible(true);
			tfSearchForPosts.setVisible(true);
			btSearch.setVisible(true);
		}
		
		// A visitor that does not follow, an option to follow is given, content is hidden.
		// Account modification components are hidden.
		else if (!owner.getFollowers().contains(viewer)) {
			
			btUnfollow.setVisible(false);			
			jbEditProfile.setVisible(false);
			scrollContent.setVisible(false);
			scrollGroups.setVisible(false);
			scrollFriends.setVisible(false);
			
			lbSearchForPosts.setVisible(false);
			tfSearchForPosts.setVisible(false);
			btSearch.setVisible(false);
			jbEditPosts.setVisible(false);

			jbDeleteAcc.setVisible(false);
			jbCreatePost.setVisible(false);
			jbLogOut.setVisible(false);	
			scrollSuggestGroups.setVisible(false);
		}
		
		btFollow.addActionListener(new ActionListener() {
			
			// Adds the user to the followed of the viewer, adds viewer to user's followers. Displays the content that was hidden before.
			public void actionPerformed(ActionEvent e) {
				owner.addFollower(viewer);
				btUnfollow.setVisible(true);
				btFollow.setVisible(false);
				scrollContent.setVisible(true);
				scrollGroups.setVisible(true);
				
				lbSearchForPosts.setVisible(true);
				tfSearchForPosts.setVisible(true);
				btSearch.setVisible(true);
				
			}
		});
		
		btUnfollow.addActionListener(new ActionListener() {
			
			// Removes the user from the followed of the viewer, removes viewer from user's followers. Hides content that was shown before.
			public void actionPerformed(ActionEvent e) {
				owner.removeFollower(viewer);
				btUnfollow.setVisible(false);
				btFollow.setVisible(true);
				scrollContent.setVisible(false);
				scrollGroups.setVisible(false);
				scrollFriends.setVisible(false);
				
				lbSearchForPosts.setVisible(false);
				tfSearchForPosts.setVisible(false);
				btSearch.setVisible(false);
			}
		});
			
	}
	
	
}
