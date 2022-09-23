
public class C1_8
{
	public static void main(String[] args)
	{
		for (int i = 0; i < 10; i++)
		{
			int m = i+i+1;
			for (int j = 0; j < 9 - i; j++)
			{
				System.out.print("-");
			}
			if (i % 2 != 0)
			{
				for (int k = 1; k <= i + i + 1; k++)
				{
					System.out.print(k);
				}
			}else {
				for(int l=1; l<=i+i+1;l++) {
					System.out.print(m);
					m--;}
			}

			System.out.println("");
		}

	}
}