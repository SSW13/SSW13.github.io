import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Stock extends JFrame
{
	ArrayList<Double> a,mv;

	public Stock()
	{
		a = new ArrayList<Double>();
		try
		{
			File f = new File("X://Eclipe//Prj//BEAUTY.xls");
			Scanner sc = new Scanner(f);
			while (sc.hasNext())
			{
				String s = sc.nextLine();
				double x = Double.parseDouble(s);
				a.add(x);
			}
			sc.close();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			System.out.println("Error:"+e.getMessage());
		} finally
		{

		}
		mv = new ArrayList<Double>();
	}
}
