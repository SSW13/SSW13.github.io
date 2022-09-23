import java.util.Scanner;

public class EF1
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] a = new int [4];
		for(int i = 0 ;i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ;i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
		}
		int sum = a[0]+a[1]+a[2]+a[3];
		int pay = sum-min;
		sc.close();
		System.out.println((double)sum+"\n"+(double)pay);
		
		

	}

}
