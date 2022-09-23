import java.util.Scanner;

public class EA4213
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		if(a==1) {
			System.out.println(b+c);
		}else if(a==2) {
			System.out.println(b*c);
		}else if(a==3) {
			System.out.println(b/c);
		}else {
			System.out.println("please select only 1-3");
		}
		
	}

}
