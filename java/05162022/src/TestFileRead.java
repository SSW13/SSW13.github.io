import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TestFileRead
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		File f = new File("D://xxxx.txt");
		Scanner sc = null;
		try
		{
			System.out.println("Start read :");
			sc = new Scanner(f);
			while(sc.hasNext()) {
				String s = sc.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			System.out.println("ERROR");
			e.printStackTrace();
		} finally
		{
			System.out.println("END");
			if(sc != null) {
				sc.close();
			}
		}
	}

}
