import java.util.Scanner;

public class EH2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		double sum = 0;
		for(int  i =0;i<10;i++) {
			sum += a;
			sum += sum*(b/100.00);
		}
		System.out.println(sum);
	}

}
