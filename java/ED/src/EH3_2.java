import java.util.Scanner;

public class EH3_2
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
		int odd = 0,even=0;
		for(int i = 0 ; i < c.length;i++) {
			if(c[i]%2==0) {
				even++;
			}else {
				odd++;
			}
		}
		System.out.println(even+"\n"+odd);
	}

}
