package Vehicle;

public class Car extends Vehicle{
	int numGears ;
	boolean isConvertible;
	
	public Car(int numGears,int maxSpeed) {
		super(maxSpeed);
		this.numGears=numGears;
		System.out.println("Car constructor");
	}
	
	public void print() {
		super.print();
		System.out.println("Car Color : "+ getcolor());
		System.out.println("Car Speed : "+ getmaxSpeed());
		System.out.println("Car numGears : "+ numGears);
		System.out.println("Car isConvertible : "+ isConvertible);
	}

}
