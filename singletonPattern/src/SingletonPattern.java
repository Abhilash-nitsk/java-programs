
class SingletonDesign{
	private static SingletonDesign singleInstance = new SingletonDesign();
	private SingletonDesign(){}
	public static SingletonDesign getInstance(){
		return singleInstance;
	}
	public void display(){
		System.out.println("Display Method of the singleton object");
	}
}
public class SingletonPattern{
	public static void main(String args[]){
		SingletonDesign obj = SingletonDesign.getInstance();
		obj.display();
	}
}
