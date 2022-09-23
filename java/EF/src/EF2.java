import java.util.Scanner;

public class EF2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		for(int i =1;i<500;i++) {
			for(int j =i ;j<500;j++ ) {
				for(int k =j ; k<500;k++) {
					if(i*i+j*j==k*k) {
						System.out.println(i+", "+j+", "+k);
					}
				}
			}
		}
		

	}

}
