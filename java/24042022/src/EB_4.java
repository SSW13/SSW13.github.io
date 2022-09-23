import java.util.Scanner;
public class EB_4
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a = 50000000;
		int b = 70000000;
		int n = 0;
		while(true) {
			a = a+(a*3/100);
			b = b+(b*2/100);
			if(a>b) {
				break;
			}
			n++;
		}
		System.out.println((int)n);
	}

}
