import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
	
		Student[] s = new Student[10];
		for(int i = 0; i < 10; i++)
		{
			int id = Integer.parseInt(sc.nextLine());
			String name = sc.nextLine();
			String surname = sc.nextLine();
			String classroom = sc.nextLine();
			int score = Integer.parseInt(sc.nextLine());
			
			s[i] = new Student(id,name,surname,classroom,score);
		}

		
		System.out.println(Student.scoreAverage(s));
		
		sc.close();
	}

}
