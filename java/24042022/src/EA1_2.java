import java.util.Scanner;
public class EA1_2
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		double g,G,m2,R;
		g=9.8;
		R=6371E3;
		m2=5.974E24;
		G=(g*R*R)/m2;
		System.out.println(G);
	}
}
