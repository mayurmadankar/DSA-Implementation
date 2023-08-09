package Vehicle;

public class Vehicle {
       private String color;
       private int maxSpeed;
       
       
       public Vehicle(int maxSpeed) {
    	   this.maxSpeed=maxSpeed;
    	   System.out.println("Vehicle Constructor");
       }
       public Vehicle() {
    	   
       }
       public int getmaxSpeed() {
    	   return maxSpeed;
       }
       public void setmaxSpeed(int max) {
    	   this.maxSpeed=max;
       }
       public String getcolor() {
    	   return color;
       }
       public void setcolor(String clr) {
    	   this.color=clr;
       }
       
       public void print() {
   	   System.out.println("Vehicle Color : " + color);
   	   System.out.println("Vehicle Speed : " +maxSpeed);
       }
}
