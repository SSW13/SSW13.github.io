import java.util.Stack;

public class StackTest
{
	Stack<String> stack;
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String [] infix = new String[] {"2", "9", "+", "7", "*", "5", "+", "3", "5", "2", "/", "+"};
		int value = evaluate(infix);
		System.out.println(value);
	}
	
	public static int evaluate(String [] s) 
	{
		Stack<String> sk = new Stack<String>();
		for(int i =0 ; i < s.length ; i++)
		{
			String k = s[i];
			System.out.println(k);
			if(k.equals("+")||k.equals("-")||k.equals("*")||k.equals("/"))
			{
				int a = Integer.parseInt(sk.pop());
				int b = Integer.parseInt(sk.pop());
				if(k.equals("+")) {
					sk.push(""+(a+b));
				}else if(k.equals("-")) {
					sk.push(""+(a-b));
				}else if(k.equals("/")) {
					sk.push(""+(a/b));
				}else if(k.equals("*")) {
					sk.push(""+(a*b));
				}
			}else 
			{
				sk.push(k);
			}			
		}
		return Integer.parseInt(sk.pop());
	}

}
