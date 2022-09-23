import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE8
{

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m =sc.nextInt();
		int n = sc.nextInt();
		if(m>=n) {
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int i =n;i<=m;i++) {
				a.add(i);
			}
			System.out.print(a.get(0));
			for(int i =1 ; i<a.size();i++) {
				System.out.print(","+a.get(i));
			}
		}
		
	}
	

}
