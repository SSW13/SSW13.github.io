import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class Stock3 extends JFrame
{
	ArrayList<Double> a,mv;

	public static void main(String[] args) throws IOException
	{
		char ch =0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Write e");
		while(ch != 'e') {
			ch = (char)br.read();
			System.out.println("you type:"+ch);
		}
	}
}
