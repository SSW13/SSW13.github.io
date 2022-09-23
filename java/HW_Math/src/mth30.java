import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mth30
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		double r,a;
		Scanner sc = new Scanner(System.in);
		a = sc.nextDouble();
		r = Math.sqrt(a/3.14);
		System.out.println(String.format("%1.3f", r));
	}

}
