import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EE5
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int prime;
		int count;
		int i;
		for( i = 10000000 ; i>0;i--) {
			count = 0;
			for(int j = 1;j<i;j++) {
				if(i%j==0) {
					count ++;
				}
			}
			if(count ==1) break;
		}
		System.out.println(i);
	}
	

}
