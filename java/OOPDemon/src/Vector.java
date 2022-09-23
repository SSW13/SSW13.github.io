
public class Vector
{
	private double x,y;
	public Vector(){
		setX(0);
		setY(1);
	}
	public Vector(double x,double y){
		this.setX(x);
		this.setY(y);
	}
	public Vector add(Vector v){
		return new Vector(getX()+v.getX() , getY()+v.getY());
	}
	public double getY(){
		return y;
	}
	public void setY(double y){
		this.y = y;
	}
	public double getX(){
		return x;
	}
	public void setX(double x){
		this.x = x;
	}
	
	
}
