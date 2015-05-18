import com.ridgesoft.io.Display;
import com.ridgesoft.robotics.PushButton;
import com.ridgesoft.intellibrain.IntelliBrain;

public class MyBot
{
	public static void main(String args[])
	{
		try
		{
			/** 
			  This block initializes the LCD Display, Start Button and Stop Button
			  using predefined classes in Ridgesoft's RoboJDE, as seen at the top
			  of the file.
			  */
			Display display = IntelliBrain.getLcdDisplay();
			PushButton startButton = IntelliBrain.getStartButton();
			PushButton stopButton = IntelliBrain.getStopButton();
		
			/** 
			  These are the possible functions that the robot can accomplish.
			  If these objects have a "toString" method, you will be able to see these in the Robot's screen.
			  */

			/**
			 * Based off of some of the code provided, try adding your own functions to this array
			 */
			Runnable functions[] = new Runnable[]{new DoBeep(), new DoNothing(), new Move()};
			//Runnable is a particular kind of Java Interface -- It allows you to multitask and run multiple programs at once

			/**
			  Display functions on screen, listen/wait for button presses
			  */
			startButton.waitReleased();
			IntelliBrain.setTerminateOnStop(false);
			int selectedFunction = 0; 
 			display.print(0, "Function"); 
 			display.print(1, functions[selectedFunction].toString());  //There's that toString method!

			
			while (!startButton.isPressed()) 
			{ 
				if (stopButton.isPressed()) 
				{ 
					if (++selectedFunction >= functions.length) 
						selectedFunction = 0; 
					display.print(1, functions[selectedFunction].toString()); 
					
					stopButton.waitReleased();
 				} 
 			}

			/**
			  These are some custom screens -- Test these out and see what happens
			  */
			IntelliBrain.setTerminateOnStop(true); 
			Screen[] screens = new Screen[] 
			{ 
 				new StaticTextScreen("MyBot", "Version 1.0"), 
 				new StaticTextScreen("Screen 1", "ACM is cool"), 
				new StaticTextScreen("Screen 2", "Big Booties"),
				//new StaticTextScreen("My favorite", "officer is Roshan")
			}; 
 			
			/**
			  The Screen Manager relates data to the screen in relation to the thumbwheel
			  */
			new ScreenManager(display, screens, IntelliBrain.getThumbWheel(),Thread.MIN_PRIORITY,500); 

			/**
			  Once you have selected a function, use the run() command to execute it as a separate Runnable thread
			  */
 			functions[selectedFunction].run(); 
 		} catch (Throwable t) { 
			//A try-catch block allows you to write code that may inevitably have errors. 
 			t.printStackTrace(); 
 		} 
 	} 
} 
