import java.util.Arrays;

public class Sorting
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int n = 10;
		int [] a = new int [n];
		for(int i = 0 ; i < n ; i++) {
			a[i] = (int)(Math.random()*1000);
		}
		System.out.println(Arrays.toString(a));
		insert(a);
		System.out.println(Arrays.toString(a));

	}
	
	public static void bubble(int []a ) {
		long startTime = System.nanoTime();
		int t;
		for(int j = 0 ; j<a.length ; j++) {
		for(int i = 0 ; i < a.length-j-1 ; i++) {
			if(a[i] > a[i+1]) {
				t = a[i+1];
				a[i+1] = a[i];
				a[i] = t;
			}			
		}
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	public static void selection(int []a ) {
		long startTime = System.nanoTime();
		for(int j = 0 ; j<a.length ; j++) {
			int last = a.length-j-1;
			int max_index = 0;
			int max = Integer.MIN_VALUE;
			for(int i = 0 ; i <=last ; i++) 
			{
				if(a[i] > max){
					max=a[i];
					max_index = i;
				}				
			}
			int t = a[last];	
			a[last] = max;
			a[max_index] = t;
		}
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}
	
	public static void insert(int []a ) {
		long startTime = System.nanoTime();
		for(int i = 0 ; i<a.length ; i++) {
			int temp = a[i];
			int j;
			for( j = i - 1 ; j>=0 ; j--) {
				if(temp > a[i]) break;
				a[j+1] = a[j];
			}	
			a[j+1] = temp;
		}		
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}	
	
	
	

}
