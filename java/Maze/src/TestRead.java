import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestRead
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String fileName = "maze.txt";
	    File file = new File(fileName);

	    byte [] fileBytes = Files.readAllBytes(file.toPath());
	    char singleChar;
	    for(byte b : fileBytes) {
	      singleChar = (char) b;
	      System.out.print(singleChar);
	    }
	}

}
