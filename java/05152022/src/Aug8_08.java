import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Aug8_08
{

	public static void main(String[] args)
	{
		File f = new File("D://xxx.txt");
		Scanner sc;
		try
		{
			sc = new Scanner(f);
			while(sc.hasNext()) {
				String s = sc.nextLine();
				System.out.println(s);
			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
