import javax.swing.*;
import java.io.*;
import javax.sound.sampled.*;
import java.awt.*;

public class PokemonDemo extends Thread implements Runnable
{
	final static String url = "music/pokemon.wav";
		
	static Thread mainThread;
	static Icon icon = new ImageIcon("images/oak.jpg");
	static Icon icon2 = new ImageIcon("images/oakwithpokeball.jpg");
	static Icon icon3 = new ImageIcon("images/oakwithnidoranf.jpg");
	static Icon icon4 = null; //This is for the player's gender -- the image changes based on their response.
	static Icon icon5 = new ImageIcon("images/rival.jpg");
	static Pokemon intro = new Pokemon();
	static int response;
	static String holder;
	static String[] options = {"Boy", "Girl"};
			
	public static void main(String [] args)
	{
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
		
		BeginningInformation();
		Gender();
		Name();
		Rival();
		FinalInformation();
	}
	
	public static void BeginningInformation()
	{
		JOptionPane.showMessageDialog(null, "Hello there!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "Glad to meet you!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "Welcome to the world of Pok\u00E9mon.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "My name is Oak.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);	 
		JOptionPane.showMessageDialog(null, "People affectionately refer to me as the Pok\u00E9mon Professor.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
		JOptionPane.showMessageDialog(null, "This world...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon2);
		JOptionPane.showMessageDialog(null, "...is inhabited far and wide by creatures called Pok\u00E9mon.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon3);
		JOptionPane.showMessageDialog(null, "For some people, Pok\u00E9mon are pets. Others use them for battling.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon3);
		JOptionPane.showMessageDialog(null, "As for myself...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon2);
		JOptionPane.showMessageDialog(null, "I study Pok\u00E9mon as a profession.", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
   		JOptionPane.showMessageDialog(null, "But first tell me a little bit about yourself...", "Oak", JOptionPane.INFORMATION_MESSAGE, icon);
	}
	
	public static void Gender()
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
			
   			//Gets the user's gender. Next step checks to verify that they entered the gender they wanted; if they did not, it reruns the entire do-while.
			
   			if(intro.getGender().equals("Boy"))
   			{
   				holder = "boy";
   				intro.setGender(holder);
   			}
   			else if(intro.getGender().equals("Girl"))
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
	}
	
	public static void Name()
	{
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
	}
	
	public static void Rival()
	{
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
	}
	
	public static void FinalInformation()
	{
   		JOptionPane.showMessageDialog(null, "Your very own Pok\u00E9mon legend is about to unfold!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
  	 	JOptionPane.showMessageDialog(null, "A world of dreams and adventures with Pok\u00E9mon awaits!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   	 	JOptionPane.showMessageDialog(null, "Let's go!", "Oak", JOptionPane.INFORMATION_MESSAGE, icon4);
   	 	
   	 	System.exit(0);
	}
}


