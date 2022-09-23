import java.util.Scanner;

public class ST02
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String t;
		int c = sc.nextInt();
		String result;
		if(c<0 ||c > a.length()) {
			result = a+b;
			System.out.println(result);
			return;
		}
		
		t = a.substring(0, c);
		result = t+b+a.substring(c);
		System.out.println(result);
	}

}
