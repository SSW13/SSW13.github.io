
public class mth28
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a = 1010111;
		String as = a + "";
		int sum = 0;
		for(int i = 0 ; i < as.length();i++) {
			int base = a % 10;
			a = a / 10;
			int pow = (int)Math.pow(2, i);
			sum += base*pow;
		}
		System.out.println(sum);
	}

}
