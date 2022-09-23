import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE13
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][]a=new int[n][5];
		for(int i =0 ; i<a.length;i++) {
			for(int j =0 ; j<a[0].length;j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int []sums = new int[n];
		for(int i = 0;i<n;i++) {
			for(int j =0 ; j<a[0].length;j++) {
				sums[i] +=a[i][j];
			}
		}
		double [] avgs = new double[n];
		for(int i = 0;i<sums.length;i++) {
			avgs[i]=sums[i]/5.0;
		}
		
		int [] sumt = new int[5];
		for(int i =0;i<5;i++) {
			for(int j =0 ; j<n;j++) {
				sumt[i] += a[j][i];
			}
		}
		double [] avgt = new double[5];
		for(int i = 0;i<sumt.length;i++) {
			avgt[i]=sumt[i]/(double)n;
		}
		for(int i = 0;i<avgs.length;i++) {
			System.out.println(avgs[i]);
		}
		for(int i = 0;i<avgt.length;i++) {
			System.out.println(avgt[i]);
		}
	}
	

}
