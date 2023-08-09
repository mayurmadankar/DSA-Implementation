package inheritance;

public class Vehicle {
         private String Color;
         protected int maxSpeed;
         
         public void setColor(String color) {
        	 this.Color=color;
         }
         public String getColor() {
        	 return Color;
         }
         public void print() {
        	 System.out.println("Vehicle "+" color "+Color+" maxSpeed "+maxSpeed);
  
         }
}
