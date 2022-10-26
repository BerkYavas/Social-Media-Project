package frames;

import java.awt.BorderLayout;

import project.AppUser;

import project.AppGroup;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class mainPageFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtMainpageOf;

	/**
	 * Sets the content of the viewer, toProfile button that takes it to own profile, shows friends according to the User viewer given
	 * @param viewer
	 */
	public mainPageFrame(AppUser viewer) {
		getContentPane().setLayout(new BoxLayout(this.getContentPane(),BoxLayout.X_AXIS));
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
		usericon.setBounds(74, 52, 77, 77);
		usericon.setIcon(viewer.getIcon());
		
		JTextArea username = new JTextArea();
		username.setEditable(false);
		username.setBounds(66, 140, 97, 22);
		username.setText(viewer.getUsername());
		userInfoPanel.setLayout(null);
		
		txtMainpageOf = new JTextField();
		txtMainpageOf.setEditable(false);
		txtMainpageOf.setBounds(34, 5, 146, 26);
		txtMainpageOf.setBackground(SystemColor.menu);
		txtMainpageOf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMainpageOf.setText("       MainPage");
		userInfoPanel.add(txtMainpageOf);
		txtMainpageOf.setColumns(10);
		userInfoPanel.add(username);
		userInfoPanel.add(usericon);
		contentPane.add(userInfoPanel);
		
		JButton profile = new JButton();
		profile.setBounds(53, 173, 127, 23);
		profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Sends viewer to its own profile, current frame disposes itself.
				profileFrame ownProfile = new profileFrame(viewer,viewer);
        		((JFrame) profile.getTopLevelAncestor()).dispose();

				ownProfile.setTitle("My Profile");
				ownProfile.setVisible(true);
				
			}
		});
		profile.setText("My Profile");
		userInfoPanel.add(profile);
		
		
		
		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension (100,100));
		
		JTextField tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(100,20));
		
		JButton jbButton = new JButton();
		jbButton.addActionListener(new ActionListener() {
			
			// If the given username, group name or content title is correct, the page of the user, group page or the content is shown, current frame disposes itself.
			public void actionPerformed(ActionEvent e) {
				for (AppUser user : AppUser.users) {
					if (user.getUsername().equals(tfSearch.getText())){
						profileFrame newframe = new profileFrame(viewer,user);
						newframe.setVisible(true);
		        		((JFrame) jbButton.getTopLevelAncestor()).dispose();

					}
				}
				
				for (AppGroup group : AppGroup.groups) {
					if (group.getName().equals(tfSearch.getText())) {
						groupFrame newFrame = new groupFrame(group,viewer);
						newFrame.setVisible(true);
						((JFrame) jbButton.getTopLevelAncestor()).dispose();
						
					}
				}
				
		        for (AppUser friend : viewer.getFollowed()) {

                    //title search for followed users' content
                    for (postContentPanel content : friend.getContents()) {
                        if (content.getTitle().equals(tfSearch.getText())) {
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
		        
		        for (AppGroup group : viewer.getGroups()) {
		        	for (postContentPanel content : group.getContents().values()) {
		        		if (content.getTitle().equals(tfSearch.getText())) {
                            JFrame frame = new JFrame();
                            frame.setSize(366,600);
                            frame.setResizable(false);
                            frame.getContentPane().setLayout(new BorderLayout());
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.getContentPane().add(content,BorderLayout.CENTER);
                            frame.setVisible(true);
		        	}
		        }
			
		        }}});
		jbButton.setText("search");
		jbButton.setPreferredSize(new Dimension(80, 20));
		
		searchPanel.add(tfSearch);
		searchPanel.add(jbButton);
		contentPane.add(searchPanel);
		
		
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));


		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		JTextArea contentSign = new JTextArea("Friends Content");
		contentSign.setEditable(false);
		contentSign.setBackground(SystemColor.menu);
		contentSign.setAlignmentY(1.0f);
		contentSign.setAlignmentX(1.0f);
		contentSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		contentSign.setPreferredSize(new Dimension(40, 40));
		contentPanel.add(contentSign);
		
		
		for (AppUser followed : viewer.getFollowed()) {
			// adding content
			for (JPanel cont : followed.getContents()) {
				contentPanel.add(cont);

			}
		}
		
		
		JScrollPane scrollContent = new JScrollPane();
		scrollContent.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollContent.setPreferredSize(new Dimension(450,600));
		scrollContent.setViewportView(contentPanel);
		contentPane.add(scrollContent);
		
		
		JPanel groupContentPanel= new JPanel();
		groupContentPanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		groupContentPanel.setLayout(new BoxLayout(groupContentPanel,BoxLayout.Y_AXIS));
		JTextArea groupContentSign = new JTextArea("Group Content");
		groupContentSign.setEditable(false);
		groupContentSign.setBackground(SystemColor.menu);
		groupContentSign.setAlignmentY(1.0f);
		groupContentSign.setAlignmentX(1.0f);
		groupContentSign.setFont(new Font("Times New Roman", Font.BOLD, 18));
		groupContentSign.setPreferredSize(new Dimension(40, 40));
		groupContentPanel.add(groupContentSign);
		for (AppGroup group : AppGroup.getGroups()) {
			
			
			// adding content
			if (group.getMembers().contains(viewer)) {
			for (JPanel content : group.getContents().values()) {
				groupContentPanel.add(content);
			}
		}}
		
		
		JScrollPane scrollGroupContent = new JScrollPane();
		scrollGroupContent.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollGroupContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollGroupContent.setPreferredSize(new Dimension(400,600));
		scrollGroupContent.setViewportView(groupContentPanel);
		contentPane.add(scrollGroupContent);
		
		
		JPanel friendsPanel = new JPanel();
		friendsPanel.setPreferredSize(new Dimension(200,200));
		friendsPanel.setLayout(new BoxLayout(friendsPanel,BoxLayout.Y_AXIS));
		
		
		JScrollPane scrollFriends = new JScrollPane();
		scrollFriends.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollFriends.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollFriends.setPreferredSize(new Dimension(200,200));
		scrollFriends.setViewportView(friendsPanel);
		
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
		txtReal.setText("Friends");
		txtReal.setPreferredSize(new Dimension(40, 40));

		contentPane.add(scrollFriends);
		friendsPanel.add(txtReal);
		for (AppUser followed : viewer.getFollowed()) {
			JPanel newOne = new JPanel();
			newOne = followed.getPersonalCard();
			JButton btToProfile = new JButton("Visit Profile");
						
			btToProfile.setBounds(121, 55, 97, 36);
			if(followed.personalCard.getComponentCount() == 2) {
				followed.personalCard.add(btToProfile);
			}
			
			btToProfile.addActionListener(new ActionListener() {
				// Followed users' page can be visited, the current frame disposes itself.
				public void actionPerformed(ActionEvent e) {
					
					
					((JFrame) btToProfile.getTopLevelAncestor()).dispose();
					profileFrame frame = new profileFrame(viewer,followed);
					frame.setVisible(true);
					
				}
			});
			
			friendsPanel.add(newOne);
	
		}
		friendsPanel.add(txtBait);


	}

	
	// the rest is getter&setters


	public JTextField getTxtMainpageOf() {
		return txtMainpageOf;
	}

	public void setTxtMainpageOf(JTextField txtMainpageOf) {
		this.txtMainpageOf = txtMainpageOf;
	}
	
	

}
