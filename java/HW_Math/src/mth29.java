import java.util.ArrayList;
import java.util.List;

public class mth29
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int a10 = 84;
		List ans = new ArrayList();
		do {
			int bit = a10%2;
			a10 = a10/2;
			ans.add(bit);
			}while(a10>0);
		for (int i = ans.size();i>0;i--) {
			System.err.print(ans.get(i-1));
		}
	}

}
