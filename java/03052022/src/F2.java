import java.util.Scanner;
public class F2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 number");
		int x,y;
		x = sc.nextInt();
		y = sc.nextInt();
		int z[] = new int[1];
		sum(x,y,z);
		System.out.println(z[0]);
		int a1,b1;
		a1 = 2;
		b1 = 3;
		a1 = b1;
		System.out.println(a1);
	}

	public static void sum(int a, int b, int[]c)
	{
		c[0]=a+b;
	}

}
