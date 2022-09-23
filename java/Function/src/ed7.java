import java.util.Arrays;

public class ed7
{
	
	public int ed7f(int a) {

	    boolean flag = false;
	    for (int i = 2; i <= a / 2; ++i) {
	      // condition for nonprime number
	      if (a % i == 0) {
	        flag = true;
	        break;
	      }
	    }

	    if (!flag)
	      return 1;
	    else
	      return 0;
		
	}
}
