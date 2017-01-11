import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.*;

public class PokemonDemo extends Thread implements Runnable
{
	boolean done = false;
	final static String url = "music/pokemon.wav";

			//Old style of multithreading
				/*	static Runnable r1 = new Runnable(){public void run()
				{	
					try 
					{
						Clip clip = AudioSystem.getClip();
						AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
						PokemonDemo control = new PokemonDemo();
						clip.open(inputStream);
						clip.start();
					}
					catch (Exception e) 
					{
						System.err.println(e.getMessage());
					}
					}
				};
			*/
		
	static Thread mainThread;
	
	public static void main(String [] args)
	{
		String holder;
		int response;
		String[] options = {"Boy", "Girl"};
		Icon icon = new ImageIcon("images/oak.jpg");
		Icon icon2 = new ImageIcon("images/oakwithpokeball.jpg");
		Icon icon3 = new ImageIcon("images/oakwithnidoranf.jpg");
		Icon icon4 = null; //This is for the player's gender -- the image changes based on their response.
		Icon icon5 = new ImageIcon("images/rival.jpg");
		
				//Thread thr1 = new Thread(r1);
				//Old Style of multithreading
				
		mainThread = new Thread(() -> //the () -> this is a lambda expression. Thread knows it needs runnable --> Runnable only has one method, and the lambda expression takes its place.
		{
			try 
			{
			      Clip clip = AudioSystem.getClip();
			      AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(url));
			      PokemonDemo control = new PokemonDemo();
			      clip.open(inputStream);
				  while(true)
				  {
			     	 clip.start();
			      }
			}
			catch (Exception e) 
			{
				System.err.println(e.getMessage());
			}
		});
		
		mainThread.start();
		
				//thr1.start();
				//Old way of multithreading
				
		Pokemon intro = new Pokemon();
		
		JOptionPane.showMessageDialog(null, "Hello there!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "Glad to meet you!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "Welcome to the world of Pokémon.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "My name is Oak.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);	 
		JOptionPane.showMessageDialog(null, "People affectionately refer to me as the Pokémon Professor.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "This world...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon2);
		JOptionPane.showMessageDialog(null, "...is inhabited far and wide by creatures called Pokémon.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon3);
		JOptionPane.showMessageDialog(null, "For some people, Pokémon are pets. Others use them for battling.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon3);
		JOptionPane.showMessageDialog(null, "As for myself...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon2);
		JOptionPane.showMessageDialog(null, "I study Pokémon as a profession.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
   		JOptionPane.showMessageDialog(null, "But first tell me a little bit about yourself...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
   		
   		do
   		{
   			do
   			{
   				response = JOptionPane.showOptionDialog(null, "Now tell me. Are you a boy, or are you a girl?", "Oak", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icon, options, options[1]);
   				if(response == JOptionPane.NO_OPTION)
   				{
   					intro.setGender("girl");
   					icon4 = new ImageIcon("images/girl.jpg");
				}
				else if(response == JOptionPane.YES_OPTION)
				{
   					intro.setGender("boy");
   					icon4 = new ImageIcon("images/boy.jpg");
				}
				else
				{
					System.exit(0);
				}
   			}while(!(intro.getGender().equals("Boy") || intro.getGender().equals("boy") || intro.getGender().equals("BOY") || intro.getGender().equals("Girl") || intro.getGender().equals("girl") || intro.getGender().equals("GIRL")));
   			
   			if(intro.getGender().equals("Boy") || intro.getGender().equals("boy") || intro.getGender().equals("BOY"))
   			{
   				holder = "boy";
   				intro.setGender(holder);
   			}
   			else if(intro.getGender().equals("Girl") || intro.getGender().equals("girl") || intro.getGender().equals("GIRL"))
   			{
   				holder = "girl";
   				intro.setGender(holder);
   				
   			}
   		
  					 response = JOptionPane.showConfirmDialog(null, "You are a " + intro.getGender() + ". Is that correct?", "Oak", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icon4);
  					 
   					 if(response == JOptionPane.NO_OPTION) 
   					 {
						 intro.setConfirmationOne("no");
   					 } 
					 else if(response == JOptionPane.YES_OPTION) 
					 {
    					intro.setConfirmationOne("yes");
    				 }
    				 else
    				 {
    				 	System.exit(0);
    				 }
   		}while(intro.getConfirmationOne().equals("no"));
   		
   		JOptionPane.showMessageDialog(null, "Let's begin with your name.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   		
   		do
   		{
   			holder = (String)JOptionPane.showInputDialog(null, "What is it?", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4, null, "");
   			intro.setPlayerName(holder);
   			
   			while(holder == null || holder.equals("") || holder.length() == 0 || holder.isEmpty())
   			{
   					JOptionPane.showMessageDialog(null, "Let's begin with your name.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   					holder = (String)JOptionPane.showInputDialog(null, "What is it?", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4, null, "");
   					intro.setPlayerName(holder);
   			}
   					response = JOptionPane.showConfirmDialog(null, "Right... so your name is " + intro.getPlayerName() + ".", "Oak", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icon4);
   					
   					if(response == JOptionPane.NO_OPTION) 
   					{
						 intro.setConfirmationTwo("no");
   					} 
					 else if(response == JOptionPane.YES_OPTION) 
					{
    					intro.setConfirmationTwo("yes");
    				}
    				 else
    				{
    				 	System.exit(0);
    				}
   		}while(intro.getConfirmationTwo().equals("no"));
   
   		JOptionPane.showMessageDialog(null, "This is my grandson.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon5);
    	JOptionPane.showMessageDialog(null, "He's been your rival since you both were babies.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon5);
    
    	do
    	{		
    		holder = (String)JOptionPane.showInputDialog(null, "...Erm, what was his name now?", "Oak", JOptionPane.INFORMATION_MESSAGE, icon5, null, "");
    		intro.setRivalName(holder);
    		
    		while(holder == null || holder.equals("") || holder.length() == 0 || holder.isEmpty())
   			{
   					holder = (String)JOptionPane.showInputDialog(null, "...Erm, what was his name now?", "Oak", JOptionPane.INFORMATION_MESSAGE, icon5, null, "");
    				intro.setRivalName(holder);
    		}
    			
    				response = JOptionPane.showConfirmDialog(null, "...Er, was it " + intro.getRivalName() + "?", "Oak", JOptionPane.YES_NO_OPTION, JOptionPane.DEFAULT_OPTION, icon5);
    				
    				if(response == JOptionPane.NO_OPTION) 
   					{
						 intro.setConfirmationThree("no");
   					} 
					 else if(response == JOptionPane.YES_OPTION) 
					{
    					intro.setConfirmationThree("yes");
    				}
    				 else
    				{
    				 	System.exit(0);
    				}
   		}while(intro.getConfirmationThree().equals("no"));
   		
   		JOptionPane.showMessageDialog(null, "That's right! I remember now! His name is " + intro.getRivalName() + "!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon5);
   		
   		JOptionPane.showMessageDialog(null, "Your very own Pokémon legend is about to unfold!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
  	 	JOptionPane.showMessageDialog(null, "A world of dreams and adventures with Pokémon awaits!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   	 	JOptionPane.showMessageDialog(null, "Let's go!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   	 	
   	 	System.exit(0);
	}
}


