public class Vector2D {
	
	double x, y;
	
	Vector2D() {}
	
	Vector2D(double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	void add(Vector2D v) {
		
		this.x += v.x;
		this.y += v.y;
		
	}
	
	void sub(Vector2D v) {
		
		this.x -= v.x;
		this.y -= v.y;
		
	}
	
	void div(double d) {
		
		x /= d;
		y /= d;
		
	}
	
	void mult(double d) {
		
		x *= d;
		y *= d;
		
	}
	
	double mag() {
		
        return Math.sqrt(x*x + y*y);
		
    }
	
	void normalize() {
		double mag = mag();
		if (mag != 0) {
			x /= mag;
			y /= mag;
		}
		
	}
	
}
