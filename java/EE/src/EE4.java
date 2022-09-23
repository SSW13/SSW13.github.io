import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			String s = Integer.toString(a);
			char [] b = s.toCharArray();
			char t;
			for(int i=0;i<b.length/2;i++) {
				t = b[i];
				b[i] = b[b.length-1-i];
				b[b.length-1-i] = t;
			}
			System.out.println(b);
			
	}
	

}
