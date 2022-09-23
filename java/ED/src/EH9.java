import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EH9
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double [] a = new double[5];
		for(int i =0 ; i<a.length;i++) {
			a[i]= sc.nextDouble();
		}
		double sum =0;
		for(int i =0 ; i < a.length ;i++) {
			sum += a[i];
		}
		double avg = sum/5;
		System.out.println(sum+"\n"+avg);
	}

}
