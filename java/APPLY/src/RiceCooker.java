
public class RiceCooker
{
	private int rice ;
	private int water;
	private String mode;

	public RiceCooker()
	{
		// TODO Auto-generated constructor stub
		System.out.println("Create Rice Cooker!");
	}
	
	public void addRice(int r) {
		this.rice = r;
		System.out.println("Add the rice "+this.rice+" g");
	}
	
	public void addWater(int w) {
		this.water = w;
		System.out.println("Add the water "+this.rice+" g");
	}
	
	public int getRice() {
		return this.rice;
	}
	
	public int getWater() {
		return this.water;
	}
	
	public void selectMode(String m) {
		this.mode = m;
		if(this.rice == 0 && this.water>0) {
			System.out.println("Please add rice");
			return;
		}else if(this.rice >0 && this.water==0) {
			System.out.println("Please add water");
			return;
		}else if(this.rice ==0 && this.water==0) {
			System.out.println("Please add rice and water");
			return;
		}
		
		if(m.equals("white")) {
			if(this.rice*1.25 == this.water) {
				System.out.println("Good, this is white mode");
			}else {
				System.out.println("Ratio not correct, the water shouldbe");
				System.out.println(this.rice*1.25);
			}
		}else if(m.equals("brown")) {
			if(this.rice*2 == this.water) {
				System.out.println("Good, this is brown mode");
			}else {
				System.out.println("Ratio not correct, the water shouldbe");
				System.out.println(this.rice*2);
			}
		}else if(m.equals("sticky")) {
			if(this.rice == this.water) {
				System.out.println("Good, this is sticky mode");
			}else {
				System.out.println("Ratio not correct, the water shouldbe");
				System.out.println(this.rice);
			}
		}else if(m.equals("japanese")) {
			if(this.rice*1.2 == this.water) {
				System.out.println("Good, this is japanese mode");
			}else {
				System.out.println("Ratio not correct, the water shouldbe");
				System.out.println(this.rice*1.2);
			}
		}else if(m.equals("mixed")) {
			if(this.rice*1.5 == this.water) {
				System.out.println("Good, this is mixed mode");
			}else {
				System.out.println("Ratio not correct, the water shouldbe");
				System.out.println(this.rice*1.5);
			}
		}else {
			return;
		}
	}
	
	public void cook(){
		if(this.rice == 0 && this.water>0) {
			System.out.println("Cannot cook");
			return;
		}else if(this.rice >0 && this.water==0) {
			System.out.println("Cannot cook");
			return;
		}else if(this.rice ==0 && this.water==0) {
			System.out.println("Cannot cook");
			return;
		}
		System.out.println(this.mode);
		if(this.mode.equals("white")) {
			if(this.rice*1.25 == this.water) {
				for(int i = 35 ; i>=0;i--) {
					System.out.println(i);
				}
			}else {
				System.out.println("Cannot cook");
				return;
			}
		}else if(this.mode.equals("brown")) {
			if(this.rice*2 == this.water) {
				for(int i = 50 ; i>=0;i--) {
					System.out.println(i);
				}
			}else {
				System.out.println("Cannot cook");
				return;
			}
		}else if(this.mode.equals("sticky")) {
			if(this.rice == this.water) {
				for(int i = 55 ; i>=0;i--) {
					System.out.println(i);
				}
			}else {
				System.out.println("Cannot cook");
				return;
			}
		}else if(this.mode.equals("japanese")) {
			if(this.rice*1.2 == this.water) {
				for(int i = 45 ; i>=0;i--) {
					System.out.println(i);
				}
			}else {
				System.out.println("Cannot cook");
				return;
			}
		}else if(this.mode.equals("mixed")) {
			if(this.rice*1.5 == this.water) {
				for(int i = 60 ; i>=0;i--) {
					System.out.println(i);
				}
			}else {
				System.out.println("Cannot cook");
				return;
			}
		}else {
			System.out.println("Cannot cook");
			return;
		}
		
	}
	
	public void cookWithTimer(int t) {
		
	}
	

}
