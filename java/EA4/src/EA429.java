import java.util.Scanner;

public class EA429
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a<50) {
			System.out.println("F");
		}else if(a<=59) {
			System.out.println("D");
		}else if(a<=69) {
			System.out.println("C");
		}else if(a<=79) {
			System.out.println("B");
		}else {
			System.out.println("A");
		}
	}

}
