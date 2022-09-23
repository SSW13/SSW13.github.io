import java.util.Scanner;

public class EA425
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int m = sc.nextInt();
		int y=0;
		if(m>5) {
			y = A*m*2 + B*m + C;
		}else if(m==5) {
			y = A*m*2 + B*m -C;
		}else if(m<5){
			y = A*m*2 + B*m;
		}
		System.out.println(y);
	}

}
