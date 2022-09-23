
public class Fibonacci
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
	
	public static int fibo(int  n ) {
		if(n ==1 || n==2) return 1;
		
		return fibo(n-1)+fibo(n-2);
	}
	
	

}
