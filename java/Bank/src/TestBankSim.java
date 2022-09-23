import java.util.Scanner;

public class TestBankSim
{
	public static int printMenu(Scanner sc) {
		System.out.println("===========MENU==========");
		System.out.println("Please Select Your Option");
		System.out.println("1. DEPOSIT");
		System.out.println("2. WITHDRAW");
		System.out.println("3. CHECK BALANCE");
		System.out.println("4. EXIT");
		

		int i = sc.nextInt();sc.nextLine();
		while(i<=0 || i>4) {
			System.out.println("===========MENU==========");
			System.out.println("Please Select Your Option");
			System.out.println("1. DEPOSIT");
			System.out.println("2. WITHDRAW");
			System.out.println("3. CHECK BALANCE");
			System.out.println("4. EXIT");
			i = sc.nextInt();sc.nextLine();
		}

		return i;
		
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		BankSim sim = new BankSim();
		while(true) {
		int i = printMenu(sc);
		if(i==1) {
			System.out.println("ACC NO");
			int accNo = sc.nextInt();
			System.out.println("Amount");
			double amount = sc.nextDouble();
			sim.deposit(accNo, amount);

		}else if(i==2) {
			System.out.println("ACC NO");
			int accNo = sc.nextInt();sc.nextLine();
			System.out.println("Password");
			String password = sc.nextLine();
			System.out.println("Amount");
			double amount = sc.nextDouble();
			sim.withdraw(accNo, password, amount);

		}else if(i==3) {
			System.out.println("ACC NO");
			int accNo = sc.nextInt();sc.nextLine();
			System.out.println("Password");
			String password = sc.nextLine();			
			sim.checkBalance(accNo, password);

		}else {
			return;
		}
		}
	}

}
