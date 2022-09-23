import java.util.Arrays;
import java.util.Scanner;

public class EC15
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int p, q;
		p = a * d + c * b;
		q = d * b;
		System.out.println(p+"/"+q);
		for(int i =q ; i>0;i--) {
			if(p%i==0 && q%i==0) {
				p /=i;
				q /=i;
			}
		}
		System.out.println(p+"/"+q);
	}

}
