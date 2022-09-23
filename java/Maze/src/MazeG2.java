import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MazeG2 extends JFrame
{
	

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		File f = new File("maze2.txt");
		f.createNewFile();
		FileWriter fw = new FileWriter(f);
		for(int i = 0 ; i < 40 ; i++)
		{			
			for(int j =0 ; j<40;j++) {
				if(Math.random() < 0.2) 
				{
					fw.write("x");
					fw.flush();
				}
				else {
					fw.write(" ");
					fw.flush();
				}
			}
			fw.write("\n");
			fw.flush();
		}
		fw.close();
		/*for(int i = 0 ; i < maze.length ; i++)
		{
			for(int j = 0 ; j < maze[0].length ; j++)
			{
				System.out.print(maze[i][j] + "\t");
			}
			System.out.println();
		}
		*/
	}

}