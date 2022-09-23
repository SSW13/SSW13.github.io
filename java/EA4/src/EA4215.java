import java.util.Scanner;

public class EA4215
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a+b == c) {
			System.out.println("+");
		}else if(a-b==c) {
			System.out.println("-");
		}else if(a*b==c) {
			System.out.println("*");
		}else if(a/b==c) {
			System.out.println("/");
		}
		
	}

}
