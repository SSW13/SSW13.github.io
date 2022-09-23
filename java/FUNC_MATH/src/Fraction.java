
public class Fraction
{

	public int N;
	public int D;
	
	public Fraction() {
		
	}
	
	public Fraction reduce() {
		Fraction a = new Fraction();
		a.N=N;
		a.D=D;
		int min = N>D ? D:N;

		for(int i=1;i<=min;i++) {
			if(a.D%i==0 && a.N%i==0) {
				min/=i;
				a.N/=i;
				a.D/=i;

			}
		}	
		
		return a;
	}
	
	public Fraction add(Fraction x) {
		if(D==x.D) {
		x.N = x.N+this.N;
		}else {
		x.N = x.N*D;
		N=N*x.D;
		x.D = D*x.D;
		x.N = x.N+N;
		}
		x=x.reduce();
		return x;
	}
	
	public Fraction minus(Fraction x) {
		if(D==x.D) {
			x.N = x.N+this.N;
			}else {
			x.N = x.N*D;
			N=N*x.D;
			x.D = D*x.D;
			x.N = N-x.N;
			}
		x=x.reduce();
		return x;
	}

	

}
