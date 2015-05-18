import com.ridgesoft.intellibrain.IntelliBrain;
import com.ridgesoft.io.Speaker;

public class DoBeep implements Runnable
{
	public void run()
	{
		Speaker speaker = IntelliBrain.getBuzzer();
		speaker.beep();
	}
	
	public String toString()
	{
		return "Beep";
	}
}
