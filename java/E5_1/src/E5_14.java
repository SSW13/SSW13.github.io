import java.util.Scanner;

public class E5_14
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a, b, c, d, f;
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		f = sc.nextInt();
		System.out.println((double)(a*4+b*3+c*2+d*1+f*0)/(a+b+c+d+f));
	}

}
