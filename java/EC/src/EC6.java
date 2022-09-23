import java.util.Arrays;
import java.util.Scanner;

public class EC6
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		double min = Integer.MAX_VALUE;
		double max = Integer.MIN_VALUE;
		int [] a = new int [x];
		for(int i = 0 ; i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		for(int i = 0 ; i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
		}
		for(int i = 0 ; i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		int sum = 0;
		for(int i = 0 ; i<a.length;i++) {
			sum += a[i];
		}
		double avg = (double)sum/x;
		System.out.println(min+"\n"+max+"\n"+avg);
	}

}
