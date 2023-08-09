package inheritance;

public class Car extends Vehicle{
	
	int numDoors;
	
	public void print() {
		super.print();
		System.out.println("Car "+" numDoors "+ numDoors);
		
	}

}
