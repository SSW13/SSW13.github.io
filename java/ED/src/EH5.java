import java.util.ArrayList;
import java.util.Scanner;

public class EH5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> a = new ArrayList<Integer>();
		int b;
		for(;;) {
			b =sc.nextInt();
			if(b==0) break;
			a.add(b);
		}
		int sum = 0;
		for(int i =0 ; i < a.size() ;i++) {
			sum += a.get(i);
		}
		double avg = (double)sum/a.size();
		System.out.println(sum+"\n"+avg);
	}

}
