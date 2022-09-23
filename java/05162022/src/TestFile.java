import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TestFile
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File f = new File("D://xxxx.txt");
		try
		{
			PrintWriter pw = new PrintWriter(f);
			pw.println("HELLO");
			pw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
