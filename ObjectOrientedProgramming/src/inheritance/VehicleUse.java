package inheritance;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Vehicle v = new Vehicle();
       v.setColor("red");
       v.maxSpeed=80;
       v.print();
       
       Car c = new Car();
       c.setColor("black");
       c.maxSpeed =100;
       c.numDoors = 4;
       c.print();  
	}
}
