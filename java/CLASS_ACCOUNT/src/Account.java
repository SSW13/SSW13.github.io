
public class Account
{

	private String id;
	private String name;
	private String surname;
	private double balance;
	
	public Account()
	{
		// TODO Auto-generated constructor stub
	}
	public Account(String xid, String xname, String xsurname, double xbalance)
	{
		// TODO Auto-generated constructor stub
		id = xid;
		name = xname;
		surname = xsurname;
		balance = xbalance;
		
	}
	
	public String getFullname() {
		return name+" "+surname;
	}
	
	public void setBalance(double x ) {
		this.balance = x;
	}

	public double getBalance() {
		return balance;
	}
	
	public void deposit(double x) {
		Account.this.setBalance(x+Account.this.getBalance());
	}
	
	public void withdraw(double x ) {
		if(x > Account.this.getBalance()) {
			return;
		}
		Account.this.setBalance(Account.this.getBalance()-x);
	}
	
	public static void transfer(Account src,Account des,double x) {
		
		if(x >src.balance ) {
			System.out.println(src.getFullname());
			System.out.println(src.getBalance());
			System.out.println(des.getFullname());
			System.out.println(des.getBalance());
			return;
		}
		src.setBalance(src.getBalance()-x);
		des.setBalance(des.balance+x);
		
		System.out.println(src.getFullname());
		System.out.println(src.getBalance());
		System.out.println(des.getFullname());
		System.out.println(des.getBalance());
		
	}
}
