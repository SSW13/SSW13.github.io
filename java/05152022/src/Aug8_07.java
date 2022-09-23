import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Aug8_07
{

	public static void main(String[] args)
	{
		File f = new File("D://xxx.txt");
		FileOutputStream outs ;
		PrintWriter pw = null;
		try
		{
			outs = new FileOutputStream(f, true);
			pw = new PrintWriter(outs);
			pw.println("HELLO");
			pw.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
