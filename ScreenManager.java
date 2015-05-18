import com.ridgesoft.io.Display;
import com.ridgesoft.robotics.AnalogInput;

public class ScreenManager extends Thread {
	private Display mDisplay;
	private Screen[] mScreens;
	private AnalogInput mUserInput;
	private int mPeriod;


	public ScreenManager(Display display, Screen[] screens, AnalogInput scroll, int threadPriority, int period)
	{
		mDisplay = display;
		mScreens = screens;
		mUserInput = scroll;
		mPeriod = period;
		setPriority(threadPriority);
		start();
	}
	
	public void run()
	{
		try
		{
			int divisor = mUserInput.getMaximum() + 1;
			while(true)
			{
				try
				{
					int index = (mUserInput.sample() * mScreens.length) / divisor;
					mScreens[index].update(mDisplay);
				} catch(Exception e){
					e.printStackTrace();
				}
				Thread.sleep(mPeriod);
			} //end of while

		}catch(Throwable t){
			t.printStackTrace();
		}
	}
}