import java.util.Scanner;

public class EF6
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		String ISBN13  = Long.toString(sc.nextLong());
	    ISBN13 = "978" + ISBN13.substring(0,9);
	    //if (LOG_D) Log.d(TAG, "ISBN13 without sum" + ISBN13);
	    int d;

	    int sum = 0;
	    for (int i = 0; i < ISBN13.length(); i++) {
	        d = ((i % 2 == 0) ? 1 : 3);
	        sum += ((((int) ISBN13.charAt(i)) - 48) * d);
	        //if (LOG_D) Log.d(TAG, "adding " + ISBN13.charAt(i) + "x" + d + "=" + ((((int) ISBN13.charAt(i)) - 48) * d));
	    }
	    sum = 10 - (sum % 10);
	    ISBN13 += sum;

	    System.out.println(ISBN13);
	}

}
