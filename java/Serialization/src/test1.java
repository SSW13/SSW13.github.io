import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class test1
{
	public static void main(String[] args) {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try
		{
			test jame = new test();
			jame.id  = 1;
			jame.name = "jame";
			jame.surname = "ssw";
			jame.phone = "0812345678";
			
			ObjectOutputStream out = new ObjectOutputStream(bout);
			
			
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
