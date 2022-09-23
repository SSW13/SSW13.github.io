import java.util.Arrays;
import java.util.Comparator;

public class Student
{
	private int id;
	private String name;
	private String surname;
	private String classroom;
	private int score;

	public Student()
	{
		// TODO Auto-generated constructor stub
	}
	public Student(int xid,String xname,String xsurname , String xclassroom,int xscore) {
		id = xid;
		name = xname;
		surname = xsurname;
		classroom = xclassroom;
		score = xscore;
	}
	
	public String getFullname() {
		return name+" "+surname;
	}
	
	public String getClassroom() {		
		return classroom;
	}
	public int getScore() {
		return score;
	}
	
	public String getGrade() {
		if(score > 90) {
			return "A";
		}else if(score >= 81) {
			return "B";
		}else if(score >= 71) {
			return "C";
		}else if(score >= 61) {
			return "D";
		}else {
			return "F";
		}		
	}
	
	public static double scoreAverage(Student s[]) {
		int count = s.length;
		int sum=0;
		for(int i =0 ; i<s.length;i++) {
			sum += s[i].score;
		}
		
		
		return (double)sum/count;
	}
	
	public static double scoreClass(Student s[], String classroom) {
		int count = 0 ;
		int sum=0;
		for(int i =0 ; i<s.length;i++) {
			if(s[i].classroom.equals(classroom)) {
				count ++;
				sum+=s[i].score;
			}
		}
		return (double)sum/count;
	}
	
	public static void ranking(Student s[]) {
		int [] sc = new int [10];
		for(int i = 0 ; i<10;i++) {
			sc[i] = s[i].score;
		}
		Arrays.sort(sc);
		for(int i =9;i>=0;i--) {
			for(int j = 0 ; j<10 ; j++) {
				if(sc[i] == s[j].score) {
					System.out.println(s[j].getFullname());
					break;
				}
			}
		}
		
	}

}
