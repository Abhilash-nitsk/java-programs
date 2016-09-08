interface shape{
	public void draw();
}
class circle implements shape{
	@Override
	public void draw(){
		System.out.println("Circle is drawn");
	}
}
class square implements shape{
	@Override
	public void draw(){
		System.out.println("Circle is drawn");
	}
}
class triangle implements shape{
	@Override
	public void draw(){
		System.out.println("Circle is Drawn");
	}
}
class shapeFactory{
	public shape getShape(String s){
		if(s == null){
	         return null;
	      }
		if(s.equals("circle"))
			return new circle();
		else if(s.equals("square"))
			return new square();
		else if(s.equals("triangle"))
			return new triangle();
		else
			return null;
	}
}
public class FactoryDesignPattern {
	public static void main(String args[]){
		shapeFactory sf = new shapeFactory();
		shape s = sf.getShape("circle");
		s.draw();
	}

}
