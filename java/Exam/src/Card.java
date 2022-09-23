import java.util.Arrays;
import java.util.Scanner;

public class Card
{
	private String rank[] =
	{ "CLB", "SPD", "HRT", "DIM" };
	private String number[] =
	{ "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };

	public Card()
	{
		// TODO Auto-generated constructor stub
	}

	public void show_all_deck()
	{
		for (int i = 0; i < this.rank.length; i++)
		{
			for (int j = 0; j < this.number.length; j++)
			{
				if (i == this.rank.length - 1 && j == this.number.length - 1)
				{
					System.out.print("(" + this.rank[i] + ", " + this.number[j] + ")");
				} else
				{
					System.out.print("(" + this.rank[i] + ", " + this.number[j] + ") ");
				}
			}
		}
	}
	
	public static void compare(String cardvalue1 , String cardvalue2 ) {
		Card c = new Card();
		
		String cc1 = cardvalue1.replace("(", "").replace(")", "").replace(" ", "");
		String [] cv1 = cc1.split(",");
		int [] cv1i = new int [2];
		for(int i = 0 ;i<c.rank.length;i++) {
			if(cv1[0].equals(c.rank[i])) {
				cv1i[0]= i;
			}
		}
		for(int i = 0 ;i<c.number.length;i++) {
			if(cv1[1].equals(c.number[i])) {
				cv1i[1]= i;
			}
		}
		
		String cc2 = cardvalue2.replace("(", "").replace(")", "").replace(" ", "");
		String [] cv2 = cc2.split(",");
		int [] cv2i = new int [2];
		for(int i = 0 ;i<c.rank.length;i++) {
			if(cv2[0].equals(c.rank[i])) {
				cv2i[0]= i;
			}
		}
		for(int i = 0 ;i<c.number.length;i++) {
			if(cv2[1].equals(c.number[i])) {
				cv2i[1]= i;
			}
		}
		if(cv1i[0] == cv2i[0]) {
			System.out.println( cv1i[1]<cv2i[1] ? cardvalue1:cardvalue2  );
		}else if(cv1i[0] < cv2i[0]) {
			System.out.println(cardvalue2);
		}else {
			System.out.println(cardvalue1);
		}
		
		
				
		
	}
	
	
	public static void compare3(String cardvalue1 , String cardvalue2) {
		Card c = new Card();
		int [] a1 = new int [2];
		int [] b1 = new int [2];
		
		String cc1 = cardvalue1.replace(") (", ", ").replace("(", "").replace(")", "");
		String [] cv1 = cc1.split(", ");
		int [] cv1i = new int [6];
		for(int j = 0 ;j<cv1.length;j+=2) {
		for(int i = 0 ;i<c.rank.length;i++) {
			if(cv1[j].equals(c.rank[i])) {
				cv1i[j]= i;
			}
		}}
		for(int j = 1 ;j<cv1.length;j+=2) {
		for(int i = 0 ;i<c.number.length;i++) {
			if(cv1[j].equals(c.number[i])) {
				cv1i[j]= i;
			}
		}}
		
		String cc2 = cardvalue2.replace(") (", ", ").replace("(", "").replace(")", "");
		String [] cv2 = cc2.split(", ");
		int [] cv2i = new int [6];
		for(int j = 0 ;j<cv2.length;j+=2) {
		for(int i = 0 ;i<c.rank.length;i++) {
			if(cv2[j].equals(c.rank[i])) {
				cv2i[j]= i;
			}
		}}
		for(int j = 1 ;j<cv2.length;j+=2) {
		for(int i = 0 ;i<c.number.length;i++) {
			if(cv2[j].equals(c.number[i])) {
				cv2i[j]= i;
			}
		}}
		
		
		
		if(cv1i[1] == cv1i[3] && cv1i[3] == cv1i[5]) {
			a1[0] = 3;
			a1[1] = cv1i[1];
		}else if(cv1i[0] == cv1i[2] && cv1i[2] == cv1i[4]) {
			a1[0] = 2;
			int max = 0;
			for(int i = 1 ; i < cv1i.length ; i+=2) {
				if(cv1i[i]>max) {
					max = cv1i[i];
				}
			}
			a1[1] = max;
		}else if(cv1i[1] == cv1i[3] || cv1i[3] == cv1i[5] || cv1i[1] == cv1i[5]) {
			a1[0] = 1 ;
			if(cv1i[1] == cv1i[3]) {
				a1[1] = cv1i[1];
			}else if(cv1i[3] == cv1i[5]) {
				a1[1] = cv1i[3];
			}else if(cv1i[1] == cv1i[5]) {
				a1[1] = cv1i[5];
			}
		}else {
			a1[0] = 0;
			int max = 0;
			for(int i = 0 ; i<cv1i.length ; i+=2) {
				if( max < ((cv1i[i]+1)*100)+cv1i[i+1] ) {
					max = ((cv1i[i]+1)*100)+cv1i[i+1];
				}
			}
			a1[1] = max;

		}
		
		
		if(cv2i[1] == cv2i[3] && cv2i[3] == cv2i[5]) {
			b1[0] = 3;
			b1[1] = cv2i[1];
		}else if(cv2i[0] == cv2i[2] && cv2i[2] == cv2i[4]) {
			b1[0] = 2;
			int max = 0;
			for(int i = 1 ; i < cv2i.length ; i+=2) {
				if(cv2i[i]>max) {
					max = cv2i[i];
				}
			}
			b1[1] = max;
		}else if(cv2i[1] == cv2i[3] || cv2i[3] == cv2i[5] || cv2i[1] == cv2i[5]) {
			b1[0] = 1 ;
			if(cv2i[1] == cv2i[3]) {
				b1[1] = cv2i[1];
			}else if(cv2i[3] == cv2i[5]) {
				b1[1] = cv2i[3];
			}else if(cv2i[1] == cv2i[5]) {
				b1[1] = cv2i[5];
			}
		}else {
			b1[0] = 0;
			int max = 0;
			for(int i = 0 ; i<cv2i.length ; i+=2) {
				if( max < ((cv2i[i]+1)*100)+cv2i[i+1] ) {
					max = ((cv2i[i]+1)*100)+cv2i[i+1];
				}
			}
			b1[1] = max;
		}
		
		if(a1[0] > b1[0]) {
			System.out.println("1");
		}else if(a1[0] < b1[0]) {
			System.out.println("2");
		}else {
			if(a1[1] > b1[1]) {
				System.out.println("1");
			}else {
				System.out.println("2");
			}
		}	
		

	}
	
	public static void suffle_all_deck() {
		Card x = new Card();
		int [] aa = new int [52];
		String [] bb = new String [52];
		int CLB = 0; 
		int SPD = 0;
		int HRT = 0; 
		int DIM = 0;
				
		for(int i = 0 ;i<52;i++) {

			if(i<13) {
				bb[i] = "("+"CLB"+", "+x.number[CLB]+")";
				CLB++;

			}else if(i < 26) {
				bb[i] = "("+"SPD"+", "+x.number[SPD]+")";
				SPD++;
			}else if(i < 39) {
				bb[i] = "("+"HRT"+", "+x.number[HRT]+")";
				HRT++;
			}else if(i < 52) {
				bb[i] = "("+"DIM"+", "+x.number[DIM]+")";
				DIM++;
			}else {}
		}
		
		
		
		
		for(int i = 0 ;i <52 ;i++) {
			aa[i] = i;
		}
		int temp;
		
		for(int i = 0 ; i <52/2 ; i+=2) {
			temp = aa[i];
			aa[i] = aa[51-i];
			aa[51-i] = temp;
		}
		
		System.out.print(bb[aa[0]]);
		for(int i = 1 ; i<aa.length ;i++) {
			System.out.print(" "+bb[aa[i]]);
		}
		
		
		
		
	}
	
	
	public static void cutting() {
		
	}
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Card a = new Card();
		Scanner sc = new Scanner(System.in);
		//String a1 = sc.nextLine();
		//String b1 = sc.nextLine();
		
		Card.suffle_all_deck();


		
		
	}

}
