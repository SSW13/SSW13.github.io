
public class B1_10
{

	public static void main(String[] args)
	{
		for (int i = 1; i <= 1000; i++)
		{
			if (i%3 ==0 || i%5 == 0 || i%7 ==0)
			{
				if(i%3 ==0 && i%5 == 0 && i%7==0) {
					
				}else if(i%3 ==0 && (i%5 ==0 || i%7 ==0)){
					System.out.println(i);
				}else if(i%5 ==0 && (i%3 ==0 || i%7 ==0)){
					System.out.println(i);
				}else if(i%7 ==0 && (i%5 ==0 || i%3 ==0)){
					System.out.println(i);
				}else {
					
				}
			}
		}

	}

}
