import java.util.Scanner;
public class EA1_3
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double m1,m2,R,f,G;
		m1 = sc.nextDouble();
		m2 = sc.nextDouble();
		R = sc.nextDouble();
		f = sc.nextDouble();
		G = (f*R*R)/(m1*m2);
		System.out.println(G);
	}
}
