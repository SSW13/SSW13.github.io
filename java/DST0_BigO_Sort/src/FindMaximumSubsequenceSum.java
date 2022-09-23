
public class FindMaximumSubsequenceSum
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int n = 5000;
		int [] a = new int[n];
		for(int i = 0 ; i < n ; i++) {
			a[i] = (int)(Math.random()*n-n/2);
		}		
		mss1(a);
		mss2(a);
		mss3(a);
	}
	
	public static int mss1(int [] a ) {
		long startTime = System.nanoTime();
		int max = 0;		
		for(int i =0  ; i < a.length ; i++) {
			for(int j = i ; j < a.length ; j++) {
				int sum = 0 ;
				for(int k = i ; k <= j ; k++) {
					sum = sum+a[k];					
				}
				if(sum > max) max = sum;
			}
		}		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		return max;		
	}
	
	public static int mss2(int [] a ) {
		long startTime = System.nanoTime();
		int max = 0;		
		for(int i =0  ; i < a.length ; i++) {
			int sum = 0 ;
			for(int j = i ; j < a.length ; j++) {
				sum = sum+a[i];
				if(sum > max) max = sum;
			}
		}		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		return max;		
	}
	
	public static int mss3(int [] a ) {
		long startTime = System.nanoTime();
		int max = 0;	
		int sum = 0;
		for(int i =0  ; i < a.length ; i++) {
			sum = sum+a[i];
			if(sum < 0 ) {
				sum = 0;
			}
			if(sum > max) {
				max = sum;
			}			
		}		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
		return max;		
	}
	
	

}
