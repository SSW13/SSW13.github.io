package exam1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class P20
{

	public static void main(String[] args)  
	{
		ArrayList<String> ppl = new ArrayList<String>();
		 try (FileInputStream fis = new FileInputStream("D:\\Eclipe\\Prj\\exam1\\src\\data_sale.csv");
			       InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			       BufferedReader reader = new BufferedReader(isr)
			  ) {

			      String str;
			      while ((str = reader.readLine()) != null) {
			          ppl.add(str);
			      }

			  } catch (IOException e) {
			      e.printStackTrace();
			  }
		 ppl.remove(0);
		 String [] str1 = new String[6];
		 ppl [] ppl1 = new ppl[ppl.size()];
		 ArrayList<ppl> ppl2 = new ArrayList<ppl>();
		 for(int  i =0 ; i < ppl.size();i++) {
			 str1 = ppl.get(i).split(",");
			 str1[4] = str1[4].replace("\"", "");			 
			 str1[5] = str1[5].replace("\"", "");
			 ppl1[i].id =  str1[0];
			 System.out.println(ppl1[i].id);
			 ppl1[i].group = Integer.parseInt(str1[1]);
			 ppl1[i].name = str1[2];
			 ppl1[i].surname = str1[3];
			 ppl1[i].sales = Integer.parseInt(str1[4]+str1[5]);
			 ppl2.add(ppl1[i]);	
			 System.out.println(ppl2.get(i).sales);
		 }
		 
		 

	}

}
