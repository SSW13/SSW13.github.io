
public class Stove
{
	private int isPlug;
	private int hasPan;
	private int time;
	private String mode;
	
	public Stove()
	{
		// TODO Auto-generated constructor stub
		System.out.println("Create Electric Stove!");
	}
	
	public Stove(int x) {
		this.isPlug = x;
		if(this.isPlug==0) {
			System.out.println("Create Electric Stove!");
		}else if(this.isPlug==1) {
			System.out.println("Create Electric Stove and put the plug in");
		}
	}
	
	public void putPan(int x) {
		this.hasPan = x;
		if(this.hasPan==0) {
			System.out.println("Remove the pan from a Stove");
		}else if(this.hasPan==1) {
			System.out.println("Put the pan on a stove");
		}		
	}
	
	public void setTime(int m,int s) {
		if(this.isPlug == 0) {
			System.out.println("Please plug in");
			return;
		}
		this.time = (m*60)+s;
		System.out.println("Set time "+this.time+" seconds");
	}
	
}
