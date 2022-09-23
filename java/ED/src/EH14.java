import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EH14
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] a = new int[3];
		for(int i =0 ; i<a.length;i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		System.out.println(a[2]+"\n"+a[0]+"\n"+Arrays.toString(a));
	}

}
