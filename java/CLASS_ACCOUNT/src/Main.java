import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		String id = sc.nextLine();
		String name = sc.nextLine();
		String surname = sc.nextLine();
		double balance = Double.parseDouble(sc.nextLine());		
		Account a1 = new Account(id,name,surname,balance);
		id = sc.nextLine();
		name = sc.nextLine();
		surname = sc.nextLine();
		balance = Double.parseDouble(sc.nextLine());		
		Account a2 = new Account(id,name,surname,balance);
		
		
		Account.transfer(a1,a2,10000);
		a1.deposit(5000);
		System.out.println(a1.getBalance());
		a1.deposit(5000);
		System.out.println(a1.getBalance());
		a2.withdraw(5000);
		System.out.println(a2.getBalance());
		Account.transfer(a2,a1,20000);
		
		sc.close();
	}

}
