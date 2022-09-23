import java.util.Scanner;
public class EB_1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int min,max;
		min =  Integer.MAX_VALUE;
		max =  Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int sum,n,round;
		sum = 0;
		round = sc.nextInt();
		for(int i = 1 ; i<=round;i++) {
			n = sc.nextInt();
			if(n < min) {
				min = n;
			}
			if(n>max) {
				max = n;
			}
			sum +=n;
		}
		System.out.println((double)sum/round);
		System.out.println(min);
		System.out.println(max);
	}

}
