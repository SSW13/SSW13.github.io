import java.util.Scanner;

public class EF3
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int hr , min;
		if(a>c) {
			hr = 12-a+c;
			if(b>d) {
				min = 60-b+d;
				hr--;
			}else {
				min = d-b;
			}
		}else {
			hr = c-a;
			if(b>d) {
				min = 60-b+d;
				hr--;
			}else {
				min = d-b;
			}
		}
		System.out.println(hr+"\n"+min);
	}

}
