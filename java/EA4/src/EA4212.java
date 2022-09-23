import java.util.Scanner;

public class EA4212
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		if(a>0&&a<=1) {
			System.out.println(50);
		}else if(a>=1.1&&a<=2) {
			System.out.println(60);
		}
		else if(a>=2.1&&a<=3) {
			System.out.println(70);
		}else if(a>3) {
			System.out.println(100);
		}
		
	}

}
