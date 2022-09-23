import java.util.Scanner;

public class EB_8
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

		int i,j,k,l;
		for(i=0;i<=9;i++) {
			if(i==0) {
				System.out.print("*|");
			}else {
				System.out.print("\t"+i);
			}
		}
		System.out.println("");
		for(j=1;j<=77;j++) {
			System.out.print("-");
		}
		System.out.println("");
		for(k=1;k<=9;k++) {
			for(l=0;l<=9;l++) {
				if(l==0) {
					System.out.print(k+"|");
				}else {
					System.out.print("\t"+(l*k));
				}
			}
		System.out.println("");
		}
		
	}

}
