import java.util.Scanner;
public class F1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 number");
		int x,y;
		x = sc.nextInt();
		y = sc.nextInt();
		int z = sum(x,y);
		System.out.println(z);
	}

	public static int sum(int a, int b)
	{
		int r = a+b;
		return r;
	}

}
