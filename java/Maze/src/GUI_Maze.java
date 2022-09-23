import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

public class GUI_Maze extends JFrame
{
	int [] [] maze = new int [40][40];
	public void readFile() throws IOException
	{
		File f= new File("maze.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		String str = br.readLine();
		//System.out.println(str);
		int j = 0;
		String s;
		while( (s = br.readLine()) != null)
		{			
			for(int i = 0 ; i < s.length() ; i++)
			{
				if(s.charAt(i)=='x')
				{
					maze[j][i] = -10;
				}
			}
			j++;
		}	
		br.close();
	}
	public GUI_Maze() throws IOException
	{
		readFile();
		MazeSolve sole = new MazeSolve();
		sole.solve(maze);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 900);
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
					g.setColor(Color.black);
					g.fillRect(j*size+40, i*size+40, size, size);
				}
				else if(maze[i][j] == 1)
				{
					g.setColor(Color.pink);
					g.fillRect(j*size+40, i*size+40, size, size);
				}
				else
				{
					g.drawRect(j*size+40, i*size+40, size, size);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		new GUI_Maze();

	}

}
