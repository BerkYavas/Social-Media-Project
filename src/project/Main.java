package project;
/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from 
anyone else. The effort in the project thus belongs completely to me. I did not search for a 
solution, or I did not consult to any program written by others or did not copy any program from 
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID 
SIGNATURE: <Mustafa Berk Yavas, 76764>
************************************************************************************************************/

import java.awt.Image;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import frames.LogInFrame;

public class Main {
	public static void main(String[] args) {
		
LogInFrame log = new LogInFrame();
	     

	 	
	 	log.setVisible(true);
		 
		  // Setting the icons here. berkyavas and redditor have their icons as null so they have defaultprofile icon.
	      Image profile1 = new ImageIcon(log.getClass().getResource("/batman.png")).getImage();
	      Image image2 = profile1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon batmanpng = new ImageIcon(image2);
	      
	      Image profile2 = new ImageIcon(log.getClass().getResource("/morty.png")).getImage();
	      Image image3 = profile2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon mortypng = new ImageIcon(image3);
	      
	      Image profile3 = new ImageIcon(log.getClass().getResource("/deadpool.png")).getImage();
	      Image image4 = profile3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon deadpoolpng = new ImageIcon(image4);
	      
	      Image profile4 = new ImageIcon(log.getClass().getResource("/godfather.jpg")).getImage();
	      Image image5 = profile4.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon godfatherpng = new ImageIcon(image5);
	      
	      Image profile5 = new ImageIcon(log.getClass().getResource("/heisenberg.png")).getImage();
	      Image image6 = profile5.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon heisenbergpng = new ImageIcon(image6);
	      
	      Image profile6 = new ImageIcon(log.getClass().getResource("/iroh.jpg")).getImage();
	      Image image7 = profile6.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon irohpng = new ImageIcon(image7);
	      
	      Image profile7 = new ImageIcon(log.getClass().getResource("/knightking.png")).getImage();
	      Image image8 = profile7.getScaledInstance(50, 50,Image.SCALE_DEFAULT);
	      ImageIcon knightkingpng = new ImageIcon(image8);
	      
	      Image profile8 = new ImageIcon(log.getClass().getResource("/punisher.jpg")).getImage();
	      Image image9 = profile8.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon punisherpng = new ImageIcon(image9);
	      
	      Image profile9 = new ImageIcon(log.getClass().getResource("/geraltofrivia2.jpg")).getImage();
	      Image image10 = profile9.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon witcherpng = new ImageIcon(image10); 
	      
	      Image profile10 = new ImageIcon(log.getClass().getResource("/behzat.jpg")).getImage();
	      Image image11 = profile10.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
	      ImageIcon behzatpng = new ImageIcon(image11);
	      
	      
	      // Creating the users, also adding created icons.
	      PremiumUser berkyavas = new PremiumUser("m.berk","123","Berk"," Yavas","Turkey","21","football",null);
	      PremiumUser morty = new PremiumUser("morty","jessica","Morty", " Smith","Turkey","14","gaming",mortypng);
	      PremiumUser batman = new PremiumUser("batman","1939","Bruce"," Wayne","USA","45","heroism",batmanpng);
	      PremiumUser deadpool = new PremiumUser("dead","blood","Wade"," Wilson","USA","43","heroism",deadpoolpng);

	      AppUser godfather = new AppUser("godfather" ,"sicilia","Don"," Corleone","USA","48","football",godfatherpng );
	      AppUser heisenberg = new AppUser("heisenberg","meth","Walter"," White","Turkey","50","football",heisenbergpng);
	      AppUser iroh = new AppUser("iroh","jasmine","Uncle"," Iroh","USA","58","gaming",irohpng);
	      AppUser knightking = new AppUser("nightking" ,"cold","Name", " Unknown","USA","45","gaming",knightkingpng);
	      AppUser punisher = new AppUser("punisher","marine","Frank"," Castle","USA","47","heroism",punisherpng);
	      AppUser redditor = new AppUser ("redditor","meirl","Redditor"," Forever","Turkey","25","gaming",null);
	      AppUser witcher = new AppUser("witcher","ciri","Geralt"," of Rivia","USA","46","gaming",witcherpng);
	      AppUser behzat = new AppUser("behzat","ankara","Behzat"," Ç","Turkey","45","football",behzatpng);

	      
	      
	   
	      
	      
	      //Creating posts, and getting the post images using Image and ImageIcon. 
	      //3 posts for each users profile. Some of them have 1 imagepost, some have 2 and some have 3. I showed my Post flexibility this way.
	      Image deadpoolPost1 = new ImageIcon(log.getClass().getResource("/deadpoolpost1.jpg")).getImage();
	      Image deadpoolPost1New = deadpoolPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon deadpoolPost11 = new ImageIcon(deadpoolPost1New);
	      Image deadpoolPost2 = new ImageIcon(log.getClass().getResource("/deadpoolpost2.jpg")).getImage();
	      Image deadpoolPost1New2 = deadpoolPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon deadpoolPost22 = new ImageIcon(deadpoolPost1New2);
	      LocalDateTime dp1 = LocalDateTime.of(2022, 4, 12, 13, 4,2);
	      LocalDateTime dp2 = LocalDateTime.of(2022, 3, 9, 19, 6,3);
	      LocalDateTime dp3 = LocalDateTime.of(2022, 2, 17, 9, 8,9);
	      deadpool.createContent(deadpoolPost11, "Selfie Time", dp1,"deadpool 1st post");
	      deadpool.createContent(null,"I am not crazy, I prefer the term mentally hilarious.",dp2,"deadpool 2nd post");
	      deadpool.createContent(deadpoolPost22, "Wearing red was the best idea I ever had.", dp3,"deadpool 3rd post");
	      
	      Image punisherPost1 = new ImageIcon(log.getClass().getResource("/punisherpost1.jpg")).getImage();
	      Image punisherPost1New = punisherPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon punisherPost11 = new ImageIcon(punisherPost1New);
	      Image punisherPost2 = new ImageIcon(log.getClass().getResource("/punisherpost2.jpg")).getImage();
	      Image punisherPost1New2 = punisherPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon punisherPost22 = new ImageIcon(punisherPost1New2);
	      LocalDateTime pu1 = LocalDateTime.of(2022, 8, 12, 13, 1,2);
	      LocalDateTime pu2 = LocalDateTime.of(2022, 2, 12, 4, 7,3);
	      LocalDateTime pu3 = LocalDateTime.of(2022, 1, 17, 9, 8,9);
	      punisher.createContent(punisherPost11, "Chilling before mass murder", pu1,"punisher 1st post");
	      punisher.createContent(null,"M4A4 has the best recoil, fav gun",pu2,"punisher 2nd post");
	      punisher.createContent(punisherPost22, "I am coming for everyone that deserves it.", pu3,"punisher 3rd post");
      
	      Image berkyavasPost1 = new ImageIcon(log.getClass().getResource("/memepost1.jpg")).getImage();
	      Image berkyavasPost1New = berkyavasPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon berkyavasPost11 = new ImageIcon(berkyavasPost1New);
	      Image berkyavasPost2 = new ImageIcon(log.getClass().getResource("/memepost2.jpg")).getImage();
	      Image berkyavasPost2New = berkyavasPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon berkyavasPost22 = new ImageIcon(berkyavasPost2New);
	      LocalDateTime by1 = LocalDateTime.of(2022, 1, 12, 13, 1,21);
	      LocalDateTime by2 = LocalDateTime.of(2021, 2, 9, 2, 7,46);
	      LocalDateTime by3 = LocalDateTime.of(2020, 1, 4, 9, 8,14);
	      berkyavas.createContent(null,"This project has damaged by mental health.",by1,"berkyavas 1st post");
	      berkyavas.createContent(berkyavasPost11, "best meme of 2022", by2,"berkyavas 2nd post");
	      berkyavas.createContent(berkyavasPost22, "trump funny go brrrrr",by3,"berkyavas 3rd post");
	      
	      
	      Image babyPost1 = new ImageIcon(log.getClass().getResource("/babypost1.jpg")).getImage();
	      Image babyPost1New = babyPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon babyPost11 = new ImageIcon(babyPost1New);
	      Image babyPost2 = new ImageIcon(log.getClass().getResource("/babypost2.jpg")).getImage();
	      Image babyPost2New = babyPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon babyPost22 = new ImageIcon(babyPost2New);
	      LocalDateTime by11 = LocalDateTime.of(2022, 1, 12, 13, 1,55);
	      LocalDateTime by22 = LocalDateTime.of(2021, 2, 10, 11, 7,46);
	      LocalDateTime by33 = LocalDateTime.of(2018, 1, 4, 9, 8,14);
	      redditor.createContent(babyPost11, "Me while doing this project", by11,"redditor 1st post");
	      redditor.createContent(babyPost22, "Reddit has the best memes", by22,"redditor 2nd post");
	      redditor.createContent(null,"Cici dunyanın ne iyi bebek yiyecegidir" ,by33,"redditor 3rd post" );
	      
	      Image batmanPost1 = new ImageIcon(log.getClass().getResource("/batmanpost1.jpg")).getImage();
	      Image batmanPost1New = batmanPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon batmanPost11 = new ImageIcon(batmanPost1New);
	      Image batmanPost2 = new ImageIcon(log.getClass().getResource("/batmanpost2.jpg")).getImage();
	      Image batmanPost2New = batmanPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon batmanPost22 = new ImageIcon(batmanPost2New);
	      Image batmanPost3 = new ImageIcon(log.getClass().getResource("/batmanpost3.jpg")).getImage();
	      Image batmanPost3New = batmanPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon batmanPost33 = new ImageIcon(batmanPost3New);
	      
	      LocalDateTime by111 = LocalDateTime.of(2022, 2, 12, 3, 1,5);
	      LocalDateTime by222 = LocalDateTime.of(2021, 9, 1, 11, 7,26);
	      LocalDateTime by333 = LocalDateTime.of(2012, 1, 4, 9, 8,18);
	      batman.createContent(batmanPost11, "Felt cute might delete later", by111,"batman 1st post" );
	      batman.createContent(batmanPost22, "Alfred farts while sleeping", by222,"batman 2nd post" );
	      batman.createContent(batmanPost33, "New Batman Movie sucks", by333,"batman 3rd post" );
	      
	      Image heisenbergPost1 = new ImageIcon(log.getClass().getResource("/heisenbergpost1.png")).getImage();
	      Image heisenbergPost1New = heisenbergPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon heisenbergPost11 = new ImageIcon(heisenbergPost1New);
	      Image heisenbergPost2 = new ImageIcon(log.getClass().getResource("/heisenbergpost2.png")).getImage();
	      Image heisenbergPost2New = heisenbergPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon heisenbergPost22 = new ImageIcon(heisenbergPost2New);
	      LocalDateTime l = LocalDateTime.of(2021, 11, 12, 3, 1,15);
	      LocalDateTime l1 = LocalDateTime.of(2021, 9, 1, 18, 7,53);
	      LocalDateTime l2 = LocalDateTime.of(2021, 7, 4, 12, 8,24);
	      heisenberg.createContent(heisenbergPost11, "My product is the best",l ,"heisenberg 1st post");
	      heisenberg.createContent(heisenbergPost22, "Gus Fring is gae",l1 ,"heisenberg 2nd post");
	      heisenberg.createContent(null, "They pay teachers 40k a year then wonder why they cook meth",l2 ,"heisenberg 3rd post");
	      
	      Image witcherPost1 = new ImageIcon(log.getClass().getResource("/witcherpost1.jpg")).getImage();
	      Image witcherPost1New = witcherPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon witcherPost11 = new ImageIcon(witcherPost1New);
	      Image witcherPost2 = new ImageIcon(log.getClass().getResource("/witcherpost2.png")).getImage();
	      Image witcherPost2New = witcherPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon witcherPost22 = new ImageIcon(witcherPost2New);
	      LocalDateTime lk = LocalDateTime.of(2019, 11, 12, 3, 1,6);
	      LocalDateTime l11 = LocalDateTime.of(2018, 9, 1, 17, 7,3);
	      LocalDateTime l21 = LocalDateTime.of(2017, 7, 4, 12, 8,14);
	      witcher.createContent(witcherPost11, "Medallion is humming, wind's howling.",lk ,"witcher 1st post");
	      witcher.createContent(null, "Never going to Velen again, 20 coins for a drowner? It is disgraceful.",l11 ,"witcher 2nd post");
	      witcher.createContent(witcherPost22, "A succesful hunt",l21 ,"witcher 3rd post");
	     
	      Image mortyPost1 = new ImageIcon(log.getClass().getResource("/mortypost1.jpg")).getImage();
	      Image mortyPost1New = mortyPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon mortyPost11 = new ImageIcon(mortyPost1New);
	      LocalDateTime a = LocalDateTime.of(2022, 6, 12, 3, 1,9);
	      LocalDateTime a1 = LocalDateTime.of(2021, 9, 12, 7, 7,13);
	      LocalDateTime a2 = LocalDateTime.of(2017, 11, 4, 9, 8,47);
	      morty.createContent(mortyPost11, "My grandpa, ready to shoot some brains out.", a,"morty 1st post");
	      morty.createContent(null, "These adventures are making me crazy.", a1,"morty 2nd post");
	      morty.createContent(null, "I should have kept my Zorp son", a2,"morty 3rd post");
	      
	      Image godfatherPost1 = new ImageIcon(log.getClass().getResource("/godfatherpost1.jpg")).getImage();
	      Image godfatherPost1New = godfatherPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon godfatherPost11 = new ImageIcon(godfatherPost1New);
	      Image godfatherPost2 = new ImageIcon(log.getClass().getResource("/godfatherpost2.jpg")).getImage();
	      Image godfatherPost2New = godfatherPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon godfatherPost22 = new ImageIcon(godfatherPost2New);
	      LocalDateTime b = LocalDateTime.of(2019, 6, 12, 3, 1,7);
	      LocalDateTime b1 = LocalDateTime.of(2018, 12, 12, 7, 6,45);
	      LocalDateTime b2 = LocalDateTime.of(2018, 7, 4, 18, 8,11);
	      godfather.createContent(godfatherPost11, "Family is first, always.", b,"godfather 1st post");
	      godfather.createContent(godfatherPost22, "My son has come a long way.", b1,"godfather 2nd post");
	      godfather.createContent(null, "Sono la migliore mafia che sia mai esistita, cazzo.", b2,"godfather 3rd post");
	      
	      Image irohPost1 = new ImageIcon(log.getClass().getResource("/irohpost1.jpg")).getImage();
	      Image irohPost1New = irohPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon irohPost11 = new ImageIcon(irohPost1New);
	      Image irohPost2 = new ImageIcon(log.getClass().getResource("/irohpost2.jpg")).getImage();
	      Image irohPost2New = irohPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon irohPost22 = new ImageIcon(irohPost2New);
	      Image irohPost3 = new ImageIcon(log.getClass().getResource("/irohpost3.jpg")).getImage();
	      Image irohPost3New = irohPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon irohPost33 = new ImageIcon(irohPost3New);
	      LocalDateTime c1 = LocalDateTime.of(2022, 5, 17, 19, 1,5);
	      LocalDateTime c2 = LocalDateTime.of(2019, 5, 8, 15, 6,3);
	      LocalDateTime c3 = LocalDateTime.of(2017, 4, 2, 3, 8,1);
	      iroh.createContent(irohPost11, "Ah shit zuko has lost his path again.", c1,"iroh 1st post");
	      iroh.createContent(irohPost22, "No steroid, full Fire Nation testosterone", c2,"iroh 2nd post");
	      iroh.createContent(irohPost33, "I could kill my nephew for some jasmine tea", c3,"iroh 3rd post");
	      
	      Image knightkingPost1 = new ImageIcon(log.getClass().getResource("/knightkingpost1.jpg")).getImage();
	      Image knightkingPost1New = knightkingPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon knightkingPost11 = new ImageIcon(knightkingPost1New);
	      Image knightkingPost2 = new ImageIcon(log.getClass().getResource("/knightkingpost2.jpg")).getImage();
	      Image knightkingPost2New = knightkingPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon knightkingPost22 = new ImageIcon(knightkingPost2New);
	      LocalDateTime d1 = LocalDateTime.of(2022, 5, 1, 22, 1,3);
	      LocalDateTime d2 = LocalDateTime.of(2021, 7, 20, 6, 6,33);
	      LocalDateTime d3 = LocalDateTime.of(2019, 5, 12, 3, 8,24);
	      knightking.createContent(knightkingPost11, "My favourite spot beyond the wall", d1,"knightking 1st post");
	      knightking.createContent(knightkingPost22, "Fan Art from my snow gang", d2,"knightking 2nd post");
	      knightking.createContent(null, "1 dragon is better than no dragon", d3,"knightking 3rd post");
	      
	      Image behzatPost1 = new ImageIcon(log.getClass().getResource("/behzatpost1.jpg")).getImage();
	      Image behzatPost1New = behzatPost1.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon behzatPost11 = new ImageIcon(behzatPost1New);
	      Image behzatPost2 = new ImageIcon(log.getClass().getResource("/behzatpost2.jpg")).getImage();
	      Image behzatPost2New = behzatPost2.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon behzatPost22 = new ImageIcon(behzatPost2New);
	      LocalDateTime e1 = LocalDateTime.of(2022, 12, 19, 22, 1,35);
	      LocalDateTime e2 = LocalDateTime.of(2022, 7, 20, 6, 6,13);
	      LocalDateTime e3 = LocalDateTime.of(2019, 5, 12, 3, 8,12);
	      behzat.createContent(behzatPost11, "Ercüment Çözer seni yakalayacam oğlum", e1,"behzat 1st post");
	      behzat.createContent(null, "Tahsin müdürün verdiği arabalar resmen kayıyor.", e2,"behzat 2nd post");
	      behzat.createContent(behzatPost22, "Saçma sapan konuşma la",e3,"behzat 3rd post");
	      
  
	      
	      // Creating 4 groups , 3 users for each.
	      ArrayList<AppUser> memegroup = new ArrayList<>();
	      memegroup.add(batman);
	      memegroup.add(witcher);
	      memegroup.add(punisher);    
	      AppGroup group1 = new AppGroup("Meme Group","Turkey", "gaming",batman, memegroup);  
	      
	      ArrayList<AppUser> othergroup = new ArrayList<>();
	      othergroup.add(knightking);
	      othergroup.add(deadpool);
	      othergroup.add(redditor);	      
	      AppGroup group2 = new AppGroup("Funny Group","USA", "gaming",deadpool, othergroup);	      	      
     
	      ArrayList<AppUser> heroes = new ArrayList<>();
	      heroes.add(morty);
	      heroes.add(godfather);
	      heroes.add(behzat);	      
	      AppGroup group3 = new AppGroup("Serious Group","USA", "football",morty, heroes);	      
	      
	      ArrayList<AppUser> fthgroup = new ArrayList<>();
	      fthgroup.add(iroh);
	      fthgroup.add(berkyavas);
	      fthgroup.add(heisenberg);	      
	      AppGroup group4 = new AppGroup("Football Group","Turkey", "football",berkyavas, fthgroup);
	      
	      
	      
	      // Creating content for groups , 1 post for each user.	
	      Image behzatPost3 = new ImageIcon(log.getClass().getResource("/behzatpost3.jpg")).getImage();
	      Image behzatPost3New = behzatPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon behzatPost33 = new ImageIcon(behzatPost3New);
	      
	      Image batmanPost4 = new ImageIcon(log.getClass().getResource("/batmanpost4.jpg")).getImage();
	      Image batmanPost4New = batmanPost4.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon batmanPost44 = new ImageIcon(batmanPost4New);
	      
	      Image deadpoolPost3 = new ImageIcon(log.getClass().getResource("/deadpoolpost3.jpg")).getImage();
	      Image deadpoolPost3New = deadpoolPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon deadpoolPost33 = new ImageIcon(deadpoolPost3New);
	      
	      Image godfatherPost3 = new ImageIcon(log.getClass().getResource("/godfatherpost3.jpg")).getImage();
	      Image godfatherPost3New = godfatherPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon godfatherPost33 = new ImageIcon(godfatherPost3New);
	      
	      
	      Image irohPost4 = new ImageIcon(log.getClass().getResource("/irohpost4.jpg")).getImage();
	      Image irohPost4New = irohPost4.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon irohPost44 = new ImageIcon(irohPost4New);
	      
	      Image heisenbergPost3 = new ImageIcon(log.getClass().getResource("/heisenbergpost3.png")).getImage();
	      Image heisenbergPost3New = heisenbergPost3.getScaledInstance(250, 250, Image.SCALE_DEFAULT);
	      ImageIcon heisenbergPost33 = new ImageIcon(heisenbergPost3New);
	      
	      
	      // Creating post for Groups, 6 photo and 6 only text post, 1 for each user.
	      // Creating random date and time as well.
	      
	      	      
	      LocalDateTime lol = LocalDateTime.of(2022, 7, 20, 6, 6,13);	      	      
	      LocalDateTime to = LocalDateTime.of(2016, 1, 7, 17, 19,22);
	      LocalDateTime need = LocalDateTime.of(2017, 12, 6, 4, 8,22);
	      LocalDateTime words = LocalDateTime.of(2016, 5, 11, 3, 7,54);
	      LocalDateTime time = LocalDateTime.of(2022, 12, 19, 22, 1,35);
	      LocalDateTime random = LocalDateTime.of(2016, 5, 7, 5, 8,36);
	      LocalDateTime j3 = LocalDateTime.of(2019, 5, 12, 3, 8,12);
	      LocalDateTime fill = LocalDateTime.of(2017, 12, 7, 15, 45,42);
	      LocalDateTime g = LocalDateTime.of(2016, 2, 9, 5, 15,3);
	      LocalDateTime h = LocalDateTime.of(2013, 1, 4, 21, 5,35);
	      LocalDateTime j1 = LocalDateTime.of(2016, 12, 19, 22, 1,35);
	      LocalDateTime j2 = LocalDateTime.of(2022, 7, 20, 6, 6,13);


	      behzat.createGroupContent(group2, behzatPost33, "Yeni dizimi herkesin la.",time,"Yeni dizim çıkıyor la"); 
	      batman.createGroupContent(group1, batmanPost44, "Batmobile just got broken.",j3,"Batmobile Problems"); 
	      deadpool.createGroupContent(group2, deadpoolPost33, "Where is francis",lol,"Francis"); 
	      godfather.createGroupContent(group3, godfatherPost33, "Wish america had the real football",need,"Milan vs Inter"); 
	      iroh.createGroupContent(group4, irohPost44, "My fans are the best",h,"FanArt"); 
	      heisenberg.createGroupContent(group4, heisenbergPost33, "I wish I grew pot instead of ccoking meth",fill,"Weed"); 

	      	
	      witcher.createGroupContent(group1, null, "Lambert needs to stfu sometimes",j2,"Trouble in Kaer Morhen"); 
	      punisher.createGroupContent(group1, null, "I will hunt down netflix for canceling me.",j1,"Netflix"); 
	      knightking.createGroupContent(group3, null, "season 8 sucks",words,"season 8"); 
	      morty.createGroupContent(group3, null, "He turned himself into a pickle, funniest thing I have seen",to,"rick"); 
	      berkyavas.createGroupContent(group4, null, "5 suggestion rule measures nothing",g,"5 suggestion"); 
	      redditor.createGroupContent(group2, null, "meirl should be closed",random,"meirl"); 
  
	      
//	      Made these accounts to follow eachother. They follow people with different hobbies for demo purposes.
//	      Same hobbied,age,country accounts will be suggested.
	      
	      witcher.addFollower(batman);
	      berkyavas.addFollower(batman);
	      morty.addFollower(batman);
	      
	      behzat.addFollower(deadpool);
	      knightking.addFollower(deadpool);
	      godfather.addFollower(deadpool);
	      
	      morty.addFollower(punisher);
	      heisenberg.addFollower(punisher);
	      godfather.addFollower(punisher);
	      
	      batman.addFollower(berkyavas);
	      punisher.addFollower(berkyavas);
	      knightking.addFollower(berkyavas);
	      
	      godfather.addFollower(morty);
	      deadpool.addFollower(morty);
	      heisenberg.addFollower(morty);
	      
	      godfather.addFollower(morty);
	      deadpool.addFollower(morty);
	      heisenberg.addFollower(morty);
	      
	      witcher.addFollower(godfather);
	      deadpool.addFollower(godfather);
	      punisher.addFollower(godfather);
	      
	      witcher.addFollower(heisenberg);
	      redditor.addFollower(heisenberg);
	      berkyavas.addFollower(heisenberg);
     
	      behzat.addFollower(iroh);
	      batman.addFollower(iroh);
	      heisenberg.addFollower(iroh);
	      
	      godfather.addFollower(knightking);
	      behzat.addFollower(knightking);
	      heisenberg.addFollower(knightking);
	      
	      witcher.addFollower(redditor);
	      iroh.addFollower(redditor);
	      punisher.addFollower(redditor);
	      
	      berkyavas.addFollower(witcher);
	      redditor.addFollower(witcher);
	      iroh.addFollower(witcher);
	      
	      berkyavas.addFollower(behzat);
	      redditor.addFollower(behzat);
	      iroh.addFollower(behzat);
	      
	
	}
}