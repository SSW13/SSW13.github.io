import java.util.Scanner;

public class EA427
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a<1) {
			System.out.println(0);
		}else {
			if(b==0) {
				System.out.println(a*30-30);
			}else {
				System.out.println(a*30);
			}
		}
	}

}
