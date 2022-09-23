import java.util.Scanner;
public class EA1_1
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double m1,m2,R,f,G;
		m1 = sc.nextDouble();
		m2 = sc.nextDouble();
		R = sc.nextDouble();
		G = 6.6E-11;
		f = (G*m1*m2)/(R*R);
		System.out.println(f);
	}
}
