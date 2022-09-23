import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

import javax.swing.JFrame;

public class GUI_Maze2 extends JFrame
{
	int [] [] maze = new int [40][40];
	public void readFile() throws IOException
	{
		ArrayList<Character> chr = new ArrayList<Character>();
		String fileName = "maze.txt";
	    File file = new File(fileName);

	    byte [] fileBytes = Files.readAllBytes(file.toPath());
	    char singleChar;
	    for(byte b : fileBytes) {
	      singleChar = (char) b;
	      chr.add(singleChar);
	      //System.out.print(singleChar);
	      
	    }
	    System.out.println(fileBytes.length);
	    int k = 0;
	    while(k < fileBytes.length)
		for(int i = 0 ; i < 40 ; i++)
		{
			for(int j = 0 ; j < 40 ; i++)
			{
				if(fileBytes[k] == 'x')
				maze[j][i] = -10;
			}
			k++;
		}
	}
	public GUI_Maze2() throws IOException
	{
		readFile();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		int size = 15;
		for(int i = 0 ;i < 40 ; i++)
		{
			for(int j =0 ; j < 40 ; j++)
			{
				if(maze[i][j] == -10)
				{
					g.fillRect(j*size, i*size+40, size, size);
				}
				else
				{
					g.drawRect(j*size, i*size+40, size, size);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		new GUI_Maze2();

	}

}
