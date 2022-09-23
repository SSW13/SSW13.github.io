import java.util.Scanner;

public class E5_16
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int s,mi,h,d,mo,y;
		s = a%60;
		mi = ((a/60)%60);
		h = (((a/60)/60)%24);
		d = (((a/60)/60)/24)%30;
		mo = (((a/60)/60)/24)/30%12;
		y = (((a/60)/60)/24)/30/12;
		System.out.println(y+"\n"+mo+"\n"+d+"\n"+h+"\n"+mi+"\n"+s);
	}

}
