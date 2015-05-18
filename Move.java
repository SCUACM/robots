import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.robotics.Servo;

public class Move implements Runnable //Runnable implies that you can have this program run in the background
{
	public void run()
	{
		try
		{
			/**
			  Servos are how our robot moves.
			  From reading the Ridgesoft API, we can interact with these Servos by creating Servo objects
			  and have them listen to port 1 and port 2. If we had more wheels/Servos, we would listen at different ports.
			  */
			Servo leftServo = IntelliBrain.getServo(1); 
			Servo rightServo = IntelliBrain.getServo(2);

			/**
			 *Try to get this program to move in a straight line
			 *Refer to the Ridgesoft API Online.
		 	 *(Hint: lookup Ridgesoft Servo.setPosition)
			 */
			leftServo.setPosition(100);  
			rightServo.setPosition(0);
			Thread.sleep(5000); //This makes the robot not execute any successive commands in the program for 5 seconds
			leftServo.off();
			rightServo.off();
			Thread.sleep(5000); 

		}catch(Throwable t)
		{
			t.printStackTrace();
		}
	}
	public String toString()
	{
		return "Moving Forward";
	}
}
