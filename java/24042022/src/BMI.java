import java.util.Scanner;

public class BMI
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("weight :");
		double a = sc.nextDouble();
		System.out.println("height :");
		double b = sc.nextDouble();
		double BMI = a / Math.pow((b / 100), 2);
		if (BMI < 20)
		{
			System.out.println("thin");
		} else
		{
			if (BMI > 25)
			{
				System.out.println("fat");
			} else
			{
				System.out.println("normal");
			}
		}
		sc.close();
	}

}
