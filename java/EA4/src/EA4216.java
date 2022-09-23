import java.util.Scanner;

public class EA4216
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a ==b && b!=c) {
			System.out.println("a = b");
		}else if(a ==c && b!=c) {
			System.out.println("a = c");
		}else if(c ==b && b!=a) {
			System.out.println("b = c");
		}else if(a ==b&&b==c) {
			System.out.println("a = b = c");
		}else {
			System.out.println("a != b != c");
		}
		
	}

}
