
public class C1_7
{
	public static void main(String[] args)
	{
		for(int i =0; i<10;i++) {
			int m = i;
			for(int j=0; j<9-i;j++) {
				System.out.print("-");}
				for(int k=1; k<=i+1;k++) {
					System.out.print(k);
									}
				for(int l=1; l<=i;l++) {
					System.out.print(m);
					m--;
									}
				System.out.println("");
			}
			
		
	}
}