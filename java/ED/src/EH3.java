import java.util.Scanner;

public class EH3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		String s = String.valueOf(a);
		char [] b = s.toCharArray();
		int [] c = new int [s.length()];
		for(int i = 0 ; i < c.length;i++) {
			c[i] = Character.getNumericValue(b[i]);
		}
		int sum = 0;
		for(int i = 0 ; i < c.length;i++) {
			sum += c[i];
		}
		System.out.println(sum);
	}

}
