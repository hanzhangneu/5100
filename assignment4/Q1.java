class Q1 {
 
   String name;
   double perimeter;
   double area;
   public Q1(){}
	public void draw(){
		System.out.println("Drawing Shape");
	};
	public double getArea(){
		return area;
		
	}
	public double getPerimeter(){
		return perimeter;
		
	}
	
}

class Circle extends Q1{
	double radius;
	
	public Circle(double radius){
		this.radius=radius;
	}
	public double getArea(){
		return area=radius*3.14*3.14;
		
	}
	@Override
	public double getPerimeter() {
		return perimeter=radius*3.14*2;
		
	}
	public void draw(){
		System.out.println("Drawing Circle");
	}
	
}

class Rectangle extends Q1{
    double width;
    double height;
	public Rectangle(double width,double height){
		this.width=width;
		this.height=height;
	}
	public double getArea(){
		return area=width*height;
	}
	public double getPerimeter() {
	return perimeter=(width+height)*2;
	}
	public void draw(){
		System.out.println("Drawing Rectangle");
	}
}

class Square extends Q1{
	double side;
	public Square(double side){
		this.side=side;
	}
	public void draw(){
		System.out.println("Drawing Square");
	}
	public double getArea(){
		return area=side*side;
	}
	public double getPerimeter() {
	return perimeter=side*4;
	}
}

class ShapeTester{
	public static void main(String args[]){
		Q1 s=new Q1();
		s.draw();
	}
}




