import java.util.Scanner;

public class EB_6
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int i = 1;
		while (i <= 110)
		{
			while(true) {
			if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0)
			{
				System.out.print("CozaLozaWoza");
				break;
			} else if (i % 3 == 0 && i % 5 == 0)
			{
				System.out.print("CozaLoza");
				break;
				
			} else if (i % 3 == 0 && i % 7 == 0)
			{
				System.out.print("CozaWoza");
				break;
				
			} else if (i % 5 == 0 && i % 7 == 0)
			{
				System.out.print("LozaWoza");
				break;
				
			}else if (i % 3 == 0)
			{
				System.out.print("Coza");	
				break;
			}else if (i % 5 == 0)
			{
				System.out.print("Loza");				
				break;
			}else if (i % 7 == 0)
			{
				System.out.print("Woza");				
				break;
			}else {
				System.out.print(i);
				break;
			}
			}
			
			if (i % 11 == 0)
			{
				System.out.println("");
			}
			i++;
		}
	}

}
