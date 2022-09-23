import java.awt.*;
import java.io.*;
import javax.swing.*;

public class MazegGenerator extends JFrame
{
	

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		File f = new File("maze.txt");
		FileWriter fw = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i = 0 ; i < 40 ; i++)
		{			
			for(int j =0 ; j<40;j++) {
				if(Math.random() < 0.2) 
				{
					bw.write("x");
				}
				else {
					bw.write(" ");
				}
			}
			bw.write("\n");
		}
		bw.close();
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
