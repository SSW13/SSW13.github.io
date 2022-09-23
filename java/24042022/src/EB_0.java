import java.util.Scanner;
public class EB_0
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum,n;
		sum = 0;
		for(int i = 1 ; i<=10;i++) {
			n = sc.nextInt();
			sum +=n;
		}
		System.out.println(sum);

	}

}
