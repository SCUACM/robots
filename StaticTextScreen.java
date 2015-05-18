import com.ridgesoft.io.Display;

public class StaticTextScreen implements Screen
{
	private String mLine1;
	private String mLine2;

	public StaticTextScreen(String line1, String line2)
	{
		mLine1 = line1;
		mLine2 = line2;
	}

	public void update(Display display)
	{
		display.print(0, mLine1);
		display.print(1, mLine2);
	}

}