This is a pet project that spiralled out of a college assignment’s boundaries. It was used to practice and learn concepts like Java OOP, Swing GUI, Git/GitHub Usage, project creation and management for an outside audience.

**Using Guide - Hardcoded Data**

**-)** When the program runs for the first time, a log in frame appears. New account could be created, or the hardcoded user data and posts can be used.

**!! The contents are filled with long thought jokes and great pictures, a tour through the user profiles and group pages is highly suggested!**

**-)** User can visit own profile, profile of other users. The seen information and parts of the frame will differentiate depending on the following status between users. The same applies for group pages, with the existing members and newcomers.

**-)** User can create posts, add picture or text to it. Existing posts can be also deleted or edited if the user logged in chooses an owned post.

**-)** Premium users can create groups, add or remove users from it. Any user can visit and join a group and leave on choice. The content displayed will update itself accordingly.

` `**!! If you wish to only use the app and figure it out yourself, this part is all you need! The rest is boring details and explanations for the more interested nerds!**

**Users**

<username, password>

m.berk, 123

batman, 1939

heisenberg, meth

godfather, sicilia

behzat, ankara

iroh, jasmine

dead, blood

punisher, marine

witcher, ciri

morty, jessica

nightking, cold

redditor, meirl

**Premium Users:** m.berk, batman, morty, deadpool

**Functionality and Implementation Choices**

!! The rest is really detailed and technical, explaining every step of the implementation choices from packages to prominent methods. You have been warned twice so far!

**Packages**

The program consists of 2 packages: frames and project.

There is also a source folder named images, where profile pictures and and post images are kept. Every user has specified posts regarding to the famous character they are based on.

**Frames package**

There are 7 GUI – related classes in this package, 6 JFrames and 1JPanel.

**CreateAccountFrame** 

- Frame that is created and set visible from the login page when *Create Account* is clicked. Has absolute layout and enables the user to sign up.
- Checks the JTextFields and JPasswordFields in case they are empty, or the passwords do not match up.
- The age field must be an integer.
- Has two buttons and performs the actions of becoming a Premium User and at the end creating the account and disposing itself while creating the main page of the created user.
- Has no methods since it’s a JFrame class that will only create a user.
- Has no parameters.

**CreateGroupFrame** 

- Frame is created and set visible when the user visits its own profile for the button *Create a Group* to be visible and clicks it.
- Has a AppUser viewer *parameter that allows it to set it up as the creator.* Cannot be accessed by a Standard AppUser since *Create a Group* button is set to invisible for a Standard AppUser when its on the page of its own profile.
- Has absolute layout and has two buttons; *Add User* that adds users to the instance variable *members ArrayList* of the class and *Create Group* which creates the group if the given JTextFields are not empty.
- Has no methods since it’s a JFrame class that will only create a group.



**EditProfileFrame**

- Is created and set visible when the user clicks *Edit Profile* button from its own profile frame. Has an AppUser viewer parameter so it can set the information of the user that views it. 
- It edits the instance variables of the user if the given JTextFields for user to fill is not empty and the username and old password matches up.
- Has no methods since it’s a JFrame class that will edit the user.

**groupFrame**

- Has 2 parameters, AppGroup group so it can set up the group content and information of the group, and an* AppUser viewer, so it can check whether it is a member or not. It also checks if the visiting user is the creator so it can display administrative buttons.
- Has 4 buttons, which allows a visitor to join; a member to leave, create posts and search posts of the group. Has 2 buttons that allows the creator to remove a user and delete the group. Has a confirmation button when the remove user option is called and asks for the username of the user that will be removed.
- *Go Back To Main Page* allows users to return to their respective main page where they can see the content of the users they follow, and visit profiles of them.
- Has no method since it is a JFrame that sets up the frame with the given group and displays it depending on the user that views it.
- Has BoxLayout since it utilizes scrollPanes to show content, members.

**LogInFrame**

- It is the only frame that is created on Main class. Has no parameter and it creates a main page frame if the given username and password is true, or it creates a *createAccountFrame* if the button *Create Account* is created. 
- Has a joke which is quite funny I believe if it can be found.
- Has absolute layout and has no methods.

**mainPageFrame**

- Has BoxLayout** because it uses scrollPanes to show group content, followed users’ content to the viewer.
- Has 1 parameter which is AppUser viewer. Viewer allows the frame to set up the information depending on content, groups, and other users the viewer must see.
- Search JTextField and JButton utilizes direct search by matching a username, group name or a title name of a content with the text received from JTextField by comparing those two strings. In case of a match can pop up those frames and disposes itself unless it is a post search.

**postContentPanel**

- It is a JPanel class that takes in 5 parameters ; *AppUser poster, ImageIcon post,String postText,LocalDateTime dt,String title.* Allows consistency amongst the users and the content pages.
- Can create two different kinds of post/content panel depending on whether an image for the post is given.
- Has *compareTo* method which allows us to order posts by the DateTime object that specifies the time a post was created and posted.
- Has absolute layout.


**profileFrame**

- It is a JFrame class that has BoxLayout as its layout since it has 4 ScrollPanes that show the content of the user, user’s groups, suggested groups and suggested users.
- Has two parameters of both type AppUser, *owner* and *viewer*. These parameters allow the frame to differentiate between a visitor looking on a page it does not follow, a friend that follows it, and the owner that is looking on its own profile.
- Sets the content visible or invisible depending on the viewer being a follower, *Follow* and *Unfollow* buttons are used for visitors.
- Has no methods since it’s a JFrame, but has 11 buttons that allows the user to edit profile, edit posts, search for posts,visit suggested and joined groups, check out suggested users, delete account, logout, create a group, create a post, follow , unfollow and return to the main page.
- All these buttons are set accordingly by the viewer and the owner of the page has. For example, administrative buttons are set active only when the owner equals viewer.

**project package**

There are 4 classes in this package that mostly has-a frames package class and the information is set up according to the class.

**AppGroup**

- Has 5 parameters** String name , String Country , String commonHobbies , AppUser creator , ArrayList<AppUser> members.
- Has a member ArrayList which allows it to keep track of the members
- Creates a GUI component for itself, which is the groupCard JPanel that will be displayed on main pages and user profiles so the user can visit a group frame.
- Has 2 methods besides getters&setters, addUser , removeUser  methods which adds or removes a given user.

**AppUser**

- Has 8 parameters (String username, String password,String name, String surname,String country,String age,String hobby,ImageIcon icon).
- Sets up the information according to the parameters, sets a default picture if the icon is given as null
- Creates a *personalCard* of the JPanel and sets it on the constructor so other users can visit their profile by interacting with their personal card when they see it on their main page or profile frame.
- Method *makeChanges* takes all the parameters of the user except the username and changes them, returns nothing.
- *getUserIndexByUsername* takes an integer as parameter and returns the index of the user in the user ArrayList. This allows for quick access to the AppUser object by the username when we are working with users in the frames package classes. Since the username is unique for every user, it allows for quick access and certainty.
- Has *removeFollower* and *addFollower* which takes in other users and changes the followed ArrayList of itself and followed ArrayList of the other user that was given as the parameter.
- Has *createContent* and *createGroupContent* methods that take content components as parameters, calls, and creates a n object of class postContentPanel and uses it accordingly depending on whether it is for a group or a personal post. 

**Main**

- Creates the first LogInFrame that allows program to travel between *Frames* and function
- User initilizations, Groups initilizations, randomly generated *DateTime* objects, Imageicons for profile pictures and posts that are taken from *images* source file, post creations for both groups and personal pages, *addFollower* function calls so the users are following each other for demo purposes. All of these objects and materials that allows the program to demonstrate its capability is hardcoded and saved in the Main class, which of course also has the main static method which makes the program run.


**PremiumUser**

- Premium user is the sub-class of AppUser, which is the only hierarchy besides frames classes being a subclass of Swing components.
- Premium users can create groups and since they are the creators of these groups, they can remove users and delete the group all together 

WindowBuilder Tool of Eclipse is used to design mainly JFrames and other Swing GUI components.























