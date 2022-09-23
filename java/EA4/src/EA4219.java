import java.util.Scanner;

public class EA4219
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int e = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int f = sc.nextInt();
		sc.close();
		double x,y;
		x = ((double)e*d-b*f)/(a*d-b*c);
		y = ((double)a*f-e*c)/(a*d-b*c);
		System.out.println(x+"\n"+y);
	}

}
