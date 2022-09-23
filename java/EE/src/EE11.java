import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE11
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int [] a = new int [n];
		for(int i =0 ; i < a.length;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		double avg;
		int sum = 0;
		for(int i =0;i<a.length;i++) {
			sum += a[i];
		}
		avg = (double)sum/n;
		System.out.println((double)a[a.length-1]+"\n"+(double)a[0]+"\n"+avg);
		
	}
	

}
