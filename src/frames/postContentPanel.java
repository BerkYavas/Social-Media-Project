package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import project.AppUser;

public class postContentPanel extends JPanel {

	private AppUser poster;
	private ImageIcon post ;
	private String postText;
	private LocalDateTime dt;
	private String title;
	private JLabel lbForPostImage;
	
	private JTextArea textPost;
	private JLabel lbUserIcon;
	private JTextArea txtUserName;
	
	private JTextArea txtTime;
	private JTextArea txtTitle;
	private JTextField txtNameSurname;
	
	
	/**
	 * Takes the parameters to create the content, a JPanel that keeps the information.
	 * @param poster
	 * @param post
	 * @param postText
	 * @param dt
	 * @param title
	 */
	public postContentPanel(AppUser poster, ImageIcon post,String postText,LocalDateTime dt,String title) {
		this.poster = poster;
		this.dt = dt;
		this.post = post;
		this.postText = postText;
		this.title = title;
		setLayout(null);

		if (post != null) {
		
		setPreferredSize(new Dimension (450,450));
		lbForPostImage = new JLabel();
		lbForPostImage.setBounds(32, 133, 245, 255);
		lbForPostImage.setIcon(this.post);
		add(lbForPostImage);
		
		textPost = new JTextArea();
		textPost.setBounds(32, 399, 285, 40);
		textPost.setText(this.postText);
		textPost.setBackground(new Color(224,224,224));
		textPost.setEditable(false);

		add(textPost);

		}
		
		else {
			
			setPreferredSize(new Dimension (450,200));
			textPost = new JTextArea();
			textPost.setBounds(32, 155, 300, 40);
			textPost.setText(this.postText);
			textPost.setLineWrap(true);
			textPost.setBackground(new Color(224,224,224));
			add(textPost);
			
		}
		
		lbUserIcon = new JLabel();
		lbUserIcon.setBounds(22, 11, 50, 50);
		lbUserIcon.setIcon(this.poster.getIcon());
		add(lbUserIcon);
		
		txtUserName = new JTextArea();
		txtUserName.setBounds(10, 68, 77, 22);
		txtUserName.setText("    "+ this.poster.getUsername());
		txtUserName.setEditable(false);
		txtUserName.setBackground(new Color(240,240,240));
		add(txtUserName);
		
		
		txtTime = new JTextArea();
		txtTime.setText(this.dt.toString().replace("T", " "));
		txtTime.setBounds(230, 68, 120, 22);
		txtTime.setBackground(new Color(224,224,224));
		txtTime.setEditable(false);
		add(txtTime);
		
		txtTitle = new JTextArea();
		txtTitle.setEditable(false);
		txtTitle.setBounds(32, 101, 245, 22);
		txtTitle.setText("Title: "+ this.title);
		txtTitle.setBackground(new Color(240,240,240));
		txtTitle.setFont(new Font("Times New Roman",Font.BOLD,18));
		add(txtTitle);
				
		txtNameSurname = new JTextField();
		txtNameSurname.setBounds(98, 11, 143, 20);
		txtNameSurname.setText(this.poster.getName() + " " + this.poster.getSurname());
		txtNameSurname.setColumns(10);
		txtNameSurname.setEditable(false);		
		add(txtNameSurname);
	}
	public int compareTo(postContentPanel o ) {
		return (this.getDt().compareTo(o.getDt()));
		
	}
	
	
	//Below here are getter&setters. 
	public AppUser getPoster() {
		return poster;
	}


	public void setPoster(AppUser poster) {
		this.poster = poster;
	}


	public ImageIcon getPost() {
		return post;
	}


	public void setPost(ImageIcon post) {
		this.post = post;
	}


	public String getPostText() {
		return postText;
	}


	public void setPostText(String postText) {
		this.postText = postText;
	}


	public LocalDateTime getDt() {
		return dt;
	}


	public void setDt(LocalDateTime dt) {
		this.dt = dt;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public JLabel getLbForPostImage() {
		return lbForPostImage;
	}


	public void setLbForPostImage(JLabel lbForPostImage) {
		this.lbForPostImage = lbForPostImage;
	}


	public JTextArea getTextPost() {
		return textPost;
	}


	public void setTextPost(JTextArea textPost) {
		this.textPost = textPost;
	}


	public JLabel getLbUserIcon() {
		return lbUserIcon;
	}


	public void setLbUserIcon(JLabel lbUserIcon) {
		this.lbUserIcon = lbUserIcon;
	}


	public JTextArea getTxtUserName() {
		return txtUserName;
	}


	public void setTxtUserName(JTextArea txtUserName) {
		this.txtUserName = txtUserName;
	}


	public JTextArea getTxtTime() {
		return txtTime;
	}


	public void setTxtTime(JTextArea txtTime) {
		this.txtTime = txtTime;
	}


	public JTextArea getTxtTitle() {
		return txtTitle;
	}


	public void setTxtTitle(JTextArea txtTitle) {
		this.txtTitle = txtTitle;
	}


	public JTextField getTxtNameSurname() {
		return txtNameSurname;
	}


	public void setTxtNameSurname(JTextField txtNameSurname) {
		this.txtNameSurname = txtNameSurname;
	}
	
	


	
	

}
