import java.util.Arrays;

public class ed6
{
	
	public int ed6f(int a) {
		int b =2;
		while(b<a) {
			b*=2;
			if(b>a) {
				return b/2;
			}
		}
		return a;
		
	}
}
