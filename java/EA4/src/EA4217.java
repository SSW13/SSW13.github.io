import java.util.Scanner;

public class EA4217
{

	public static void main(String[] args)
	{
		int n = 10;
		for(int i = 0 ; i <n/2;i++) {
			for(int j = 0 ; j <1+(2*i);j++) {
				System.out.print("*");				
			}
			for(int j = 0 ; j <n-1-(2*i);j++) {
				System.out.print("-");
			}
			for(int j = 0 ; j <n-1-(2*i);j++) {
				System.out.print("-");
			}
			for(int j = 0 ; j <1+(2*i);j++) {
				System.out.print("*");				
			}
			System.out.println("");
			}
		for(int i = 0 ; i<n*2;i++)
		System.out.print("*");
		System.out.println();
		for(int i = (n/2)-1 ; i >=0;i--) {
			for(int j = 0 ; j <1+(2*i);j++) {
				System.out.print("*");				
			}
			for(int j = 0 ; j <n-1-(2*i);j++) {
				System.out.print("-");
			}
			for(int j = 0 ; j <n-1-(2*i);j++) {
				System.out.print("-");
			}
			for(int j = 0 ; j <1+(2*i);j++) {
				System.out.print("*");				
			}
			if(i!=0)
			System.out.println("");
			}
		
	}

}
