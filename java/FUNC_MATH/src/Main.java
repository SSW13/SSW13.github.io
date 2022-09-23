import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		Fraction fraction1 = new Fraction();
		fraction1.N = sc.nextInt();
		fraction1.D = sc.nextInt();
		Fraction fraction2 = new Fraction();
		fraction2.N = sc.nextInt();
		fraction2.D = sc.nextInt();
		
		Fraction result = fraction1.add(fraction2);
		System.out.println(result.N);
		System.out.println(result.D);
		
		result = fraction1.minus(fraction2);
		System.out.println(result.N);
		System.out.println(result.D);
		
		sc.close();
	}

}
