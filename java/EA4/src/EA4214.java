import java.util.Scanner;

public class EA4214
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a+b>c && a+c>b && b+c>a) {
			System.out.println("triangle");
		}else  {
			System.out.println("not triangle");
		}
		
	}

}
