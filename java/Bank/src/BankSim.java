
public class BankSim
{
	Account [] accs;
	public BankSim() {
		accs = new Account[10];
		
		accs[0] = new Account();
		accs[0].accNo = 1;
		accs[0].accName = "ssw";
		accs[0].accPassword = "132613";
		accs[0].balance = 1000000;
		
		accs[1] = new Account();
		accs[1].accNo = 2;
		accs[1].accName = "sssw";
		accs[1].accPassword = "132613";
		accs[1].balance = 1000000;
		
		accs[2] = new Account();
		accs[2].accNo = 3;
		accs[2].accName = "ssssw";
		accs[2].accPassword = "132613";
		accs[2].balance = 1000000;
		
	}
	private void printBalance(Account a) {
		if(a==null) return;
		System.out.println(a.accName+" have balance "+a.balance);
	}
	
	private Account getAccByAccNo(int accNo) {
		for(int i =0 ; i<accs.length;i++) {
			if(accs == null) continue;
			if(accs[i].accNo == accNo) return accs[i];
			
		}
		return null;
	}
	
	public void deposit(int accNo,double amount) {
		Account a = getAccByAccNo(accNo);
		if(a==null) {System.out.println("!! account not found");
		return;}
		a.balance += amount;
		printBalance(a);
	}
	public void withdraw(int accNo,String password,double amount) {
		Account a = getAccByAccNo(accNo);
		if(a==null) {System.out.println("!! account not found");
		return;}
		if(a.accPassword.equals(password)) {
			
		}else {
			System.out.println("Wrong Password");
			return;
		}
		if(a.balance - amount < 0 ) {
			System.out.println("Not Enough");
			return;
		}
		a.balance -= amount;
		printBalance(a);
	}
	public void checkBalance(int accNo,String password) {
		Account a = getAccByAccNo(accNo);
		if(a==null) {System.out.println("!! account not found");
		return;}
		if(a.accPassword.equals(password)) {
			
		}else {
			System.out.println("Wrong Password");
			return;
		}
		
		printBalance(a);
	}
}
