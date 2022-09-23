import java.util.Arrays;

public class ed8
{
	
	public int ed8f(int a) {

	    boolean flag = false;
	    for (int i = 2; i <= a / 2; ++i) {
	      // condition for nonprime number
	      if (a % i == 0) {
	        flag = true;
	        break;
	      }
	    }

	    if (!flag)
	      return 0;
	    else
	      return 1;
		
	}
}
