
public class Vector2D
{
	public double X;
	public double Y;
	
	public Vector2D() {
		
	}
	
	public Vector2D add(Vector2D vector2) {
		vector2.X= X+vector2.X;
		vector2.Y= Y+vector2.Y;
		return vector2;
				
	}
	
	public Vector2D minus(Vector2D vector2) {
		vector2.X= X-vector2.X;
		vector2.Y= Y-vector2.Y;
		return vector2;
	}

	public double dot(Vector2D vector2) {
		double dot = X*vector2.X+Y*vector2.Y ;
		
		return dot ;
	}
	
	public double size() {
		double size = Math.sqrt( X*X+Y*Y );
		
		return size ;
	}
	
	public Vector2D unit() {
		
		Vector2D aa = new Vector2D();
		
		aa.X =X/Math.sqrt(X*X+Y*Y);
		aa.Y = Y/Math.sqrt(X*X+Y*Y);
		
		return aa ;
	}

}
