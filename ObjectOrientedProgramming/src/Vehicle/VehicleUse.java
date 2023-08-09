package Vehicle;

public class VehicleUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vehicle v = new Vehicle();
        v.setcolor("Red");
        v.getcolor();
		 v.setmaxSpeed(122);
        v.getmaxSpeed();
        v.print();
        
        Car c = new Car(10,500);
       // c.numGears = 10;
        c.setcolor("Blue");
        c.getcolor();
        c.setmaxSpeed(299);
        c.getmaxSpeed();
        c.print();
        
	}

}
