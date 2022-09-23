import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE10
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int [] a = new int [10];
		for(int i =0 ; i < a.length;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		double avg;
		int sum = 0;
		for(int i =0;i<a.length;i++) {
			sum += a[i];
		}
		avg = sum/10.0;
		System.out.println((double)a[9]+"\n"+(double)a[0]+"\n"+avg);
		
	}
	

}
